package br.com.bcbrito.stickergenerator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;

import br.com.bcbrito.stickergenerator.config.StickerConfig;
import br.com.bcbrito.stickergenerator.exception.StickerApiException;
import br.com.bcbrito.stickergenerator.model.Endpoint;

public class App {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(StickerConfig.class);) 
		{
			applicationContext.getBean(StickerApp.class).callApi(Endpoint.CHARACTERS);
		} 
		catch (StickerApiException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
