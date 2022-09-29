package br.com.bcbrito.stickergenerator;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bcbrito.stickergenerator.exception.StickerApiException;
import br.com.bcbrito.stickergenerator.model.Endpoint;
import br.com.bcbrito.stickergenerator.service.StickerApi;

@Component
public class StickerApp {

	@Autowired
	private List<StickerApi> listApi;

	public void callApi(Endpoint endpoint) throws StickerApiException, FileNotFoundException 
	{		

		StickerApi api = listApi
				.stream()
				.filter(stickerApi -> stickerApi.accept(endpoint))
				.findAny()
				.orElseThrow(() -> new StickerApiException("Endpoint não mapeado a nenhuma implementação da StickerAPI."));
		
		api.consume(endpoint);
		api.minimumRating(5f);
		api.limitData(10);		
		api.printData();
		api.generateStickers();
	}
}
