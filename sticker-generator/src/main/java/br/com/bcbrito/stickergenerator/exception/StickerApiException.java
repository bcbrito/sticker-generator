package br.com.bcbrito.stickergenerator.exception;

public class StickerApiException extends RuntimeException {

	private static final long serialVersionUID = -1149093167845996356L;

	public StickerApiException(String message, Throwable error) {
		super(message, error);
	}

	public StickerApiException(String message) {
		super(message);
	}

	public StickerApiException(Throwable error) {
		super(error);
	}

}
