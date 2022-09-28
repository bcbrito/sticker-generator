package br.com.bcbrito.stickergenerator.model;

import lombok.Builder;

@Builder
public record StickerContent(String title, String urlImage, String rating) {
	
}
