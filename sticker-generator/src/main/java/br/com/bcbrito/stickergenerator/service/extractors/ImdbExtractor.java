package br.com.bcbrito.stickergenerator.service.extractors;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

import br.com.bcbrito.stickergenerator.exception.StickerApiException;
import br.com.bcbrito.stickergenerator.model.Endpoint;
import br.com.bcbrito.stickergenerator.model.StickerContent;
import br.com.bcbrito.stickergenerator.model.StickerParameters;
import br.com.bcbrito.stickergenerator.service.AbstractExtractor;

@Component
@Getter
@Setter
public class ImdbExtractor extends AbstractExtractor {

  private static final TreeMap<Integer, String> RATING_TEXT = new TreeMap<>();
  static {
    RATING_TEXT.put(0, "AVALIAR");
    RATING_TEXT.put(1, "PESSIMO");
    RATING_TEXT.put(4, "RUIM");
    RATING_TEXT.put(6, "MEIA BOCA");
    RATING_TEXT.put(8, "TOP");
  }

  @Override
  public boolean accept(Endpoint endpoint) {
    return Endpoint.isImdb(endpoint);
  }

  @Override
  public void consume(Endpoint endpoint) throws StickerApiException {
    var key = "k_4hhbeiwn"; 
    
    try {
      var jsonNode = new ObjectMapper().readTree(jsonFromGet(endpoint.getUrl() + key));
      setData(StreamSupport.stream(jsonNode.get("items").spliterator(), false)
    		  .map(node -> StickerContent.builder()
              .title(node.get("title").asText())
              .urlImage(node.get("image").asText())
              .rating(node.get("imDbRating").asText())
              .build())
          .toList());
    } catch (StickerApiException | JsonProcessingException e) {
      throw new StickerApiException("Erro ao instanciar implementacao da API IMDB.", e);
    }
  }

  @Override
  public void generateStickers() throws StickerApiException {
    System.out.println("\nIniciando geração de Stickers do IMDB...");
    getData().stream().forEach(
        data -> {
          try {
            System.out.print(data.title() + "... ");
            Double rating = !data.rating().isBlank() ? Double.valueOf(data.rating()) : 0;
            String text = RATING_TEXT.floorEntry((int) Math.round(rating)).getValue();
            createSticker(StickerParameters.builder()
                // .image(new URL(data.urlImage().replaceAll("\\._(.+).jpg$", ".jpg")).openStream())
                .image(new URL(data.urlImage().replaceAll("(_+)(.*).jpg$", ".jpg")).openStream())
                .targetWidth(600)
                .targetHeight(1000)
                .text(text)
                .fontName("Comic Sans MS")
                .fontSize(128)
                .isTop(RATING_TEXT.lastEntry().getValue().equals(text))
                .topImage("data/image/sticker/joinha.png")
                .outputPath("data/image/sticker/imdb/")
                .outputName(data.title()).build());
            System.out.println("Ok!");
          } catch (StickerApiException | IOException e) {
            System.out.println("Fail: " + e.getMessage());
          }
        });
    System.out.println("...Finalizado! :)");
  }

  @Override
	public void minimumRating(Float min){
		
    System.out.println("Foram encontrados " + getData().size() + " ...");

		List<StickerContent> newListStickers = new ArrayList<StickerContent>();

		for (StickerContent stickerContent : getData()) {
			if (!stickerContent.rating().isEmpty() && Math.round(Float.parseFloat(stickerContent.rating())) >= min){
				newListStickers.add(stickerContent);
			}
		}

		setData(newListStickers.size() > 0 ? newListStickers : new ArrayList<StickerContent>());		
    
    System.out.println("Porém apenas " + getData().size()+ ", tem a classificação mínima de " + min + " ...");
	}

}

