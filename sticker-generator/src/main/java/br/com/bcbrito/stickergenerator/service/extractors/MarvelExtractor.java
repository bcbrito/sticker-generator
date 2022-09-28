package br.com.bcbrito.stickergenerator.service.extractors;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bcbrito.stickergenerator.exception.StickerApiException;
import br.com.bcbrito.stickergenerator.model.Endpoint;
import br.com.bcbrito.stickergenerator.model.StickerContent;
import br.com.bcbrito.stickergenerator.model.StickerParameters;
import br.com.bcbrito.stickergenerator.service.AbstractExtractor;


import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class MarvelExtractor extends AbstractExtractor {

	 @Override
	  public boolean accept(Endpoint endpoint) {
	    return Endpoint.isMarvel(endpoint);
	  }

	  @Override
	  public void consume(Endpoint endpoint) throws StickerApiException {
	    var publicKey = "b3b2b4db74c8eb8c784fed8956336503";
	    var privateKey = "0bd54f4e66c2cfcc4b9c533e20bd9c523ce4ac73";
	    var id = UUID.randomUUID();

	    try {
	    	
	      var json = jsonFromGet(
	    		  		  String.format("%s?ts=%s&apikey=%s&hash=%s&limit=100",
	    				  endpoint.getUrl(), 
	    				  id, 
	    				  publicKey,
	    				  new BigInteger(1, MessageDigest.getInstance("MD5").digest((id + privateKey + publicKey).getBytes())).toString(16)));
	      
	      setData(StreamSupport
	          .stream(new ObjectMapper().readTree(json).get("data").get("results").spliterator(), false)
	          .map(node -> StickerContent.builder()
	              .title(node.get("name").asText())
	              .urlImage(
	                  String.format("%s.%s",
	                      node.get("thumbnail").get("path").asText(),
	                      node.get("thumbnail").get("extension").asText()))
	              .build())
	          .toList());
	    } catch (StickerApiException | JsonProcessingException | NoSuchAlgorithmException e) {
	      throw new StickerApiException("Erro ao instanciar implementação da API MARVEL.", e);
	    }
	  }

	  @Override
	  public void generateStickers() {
	    System.out.println("\n Iniciando geração de Stickers da MARVEL...");
	    getData().stream().forEach(data -> {
	      try 
	      {
	        System.out.print(data.title() + "... ");
	        createSticker(StickerParameters.builder()
	            .image(new URL(data.urlImage()).openStream())
	            .targetWidth(1000)
	            .targetHeight(1500)
	            .text(data.title())
	            .fontName("Impact")
	            .fontSize(128)
	            .outputPath("data/image/sticker/marvel/")
	            .outputName(data.title()).build());
	        System.out.println("Ok!");
	      } 
	      catch (StickerApiException | IOException e) 
	      {
	        System.out.println("Fail: :( " + e.getMessage());
	      }
	    });
	    System.out.println("...Finalizado! :)");
	  }
	
}
