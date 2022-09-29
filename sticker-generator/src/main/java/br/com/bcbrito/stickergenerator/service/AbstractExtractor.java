package br.com.bcbrito.stickergenerator.service;

import java.util.List;
import java.util.Optional;

import br.com.bcbrito.stickergenerator.model.StickerContent;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class AbstractExtractor implements StickerApi {

	private List<StickerContent> data;

	@Override
	public void limitData(int max) {
		if (max < data.size())
			this.data = this.data.subList(0, max);
		
		System.out.println("Limitando o resultado em apenas " + max + "...");
	}	
	
	private void printDataField(String format, String field) {
		System.out.println(format + field + "\033[0m");
	}

	@Override
	public void printData() {
		for (StickerContent content : this.data) {
			printDataField("\033[1;37m", "\nTitulo: " + content.title());
			printDataField("\033[1;37m", "Image: " + content.urlImage());
			if (Optional.ofNullable(content.rating()).isPresent() && !content.rating().isBlank()) {
				printDataField("\033[0;105m", "Classificacao: " + content.rating());
				printDataField("\033[1;33m", "\u2605 ".repeat((int) Math.round(Double.valueOf(content.rating()))));
			} else {
				printDataField("\033[0;105m", "Sem classificacao");
			}			
		}
	}	
	
}
