package br.com.bcbrito.stickergenerator.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import br.com.bcbrito.stickergenerator.exception.StickerApiException;
import br.com.bcbrito.stickergenerator.model.Endpoint;
import br.com.bcbrito.stickergenerator.model.StickerParameters;

public interface StickerApi {
	
	boolean accept(Endpoint endpoint);

	void consume(Endpoint endpoint);
	
	void limitData(int max);

	void printData();

	default String jsonFromGet(String url) throws StickerApiException {
		try 
		{
			URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            var response = client.send(request, BodyHandlers.ofString());
            return response.body();
            
		} catch (IOException e) 
		{
			throw new StickerApiException("Erro ao recuperar Json.", e);
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		return null;
	}

	void generateStickers() throws StickerApiException;

	void minimumRating(Float min) throws StickerApiException;

	default void createSticker(StickerParameters param) throws StickerApiException {
		new Sticker().create(param);
	}
}
