package br.com.bcbrito.stickergenerator.service;

import static java.awt.Transparency.TRANSLUCENT;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import br.com.bcbrito.stickergenerator.model.StickerParameters;
import br.com.bcbrito.stickergenerator.exception.StickerApiException;

public class Sticker {

	private static final String WIDTH = "width";
	private static final String HEIGHT = "height";

	public void create(StickerParameters param) throws StickerApiException {

		try {

			BufferedImage original = ImageIO.read(param.getImage());
			Map<String, Integer> size = new HashMap<>();

			formatSize(param, original, size);

			BufferedImage sticker = new BufferedImage(size.get(WIDTH), size.get(HEIGHT) + param.getHeightPlus(), TRANSLUCENT);

			Graphics2D graphic = (Graphics2D) sticker.getGraphics();
			graphic.drawImage(original, 0, 0, size.get(WIDTH), size.get(HEIGHT), null);

			formatTopImage(param, sticker, graphic);
			formatText(param, size, sticker, graphic);

			Files.createDirectories(Paths.get(param.getOutputPath()));
			ImageIO.write(sticker, param.getOutputFormat(),
					new File(param.getOutputPath() + param.getOutputName() + "." + param.getOutputFormat()));

		} catch (IOException e) {
			throw new StickerApiException("Erro ao criar Sticker.", e);
		}
	}

	private void formatSize(StickerParameters param, BufferedImage original, Map<String, Integer> size) {

		var width = original.getWidth() > param.getTargetWidth()
				? param.getTargetWidth() / Double.valueOf(original.getWidth())
				: 1;
		
		var heigth = original.getHeight() > param.getTargetHeight()
				? param.getTargetHeight() / Double.valueOf(original.getHeight())
				: 2;

		// Retorna escala com o menor dos dois valores
		Double scale = Math.min(width, heigth);

		size.put(WIDTH, (int) (original.getWidth() * scale));
		size.put(HEIGHT, (int) (original.getHeight() * scale));
	}

	private void formatTopImage(StickerParameters param, BufferedImage sticker, Graphics2D graphic) throws IOException {

		//Coloco a imagem dando joinha hu3hu3hu3hu3 
		if (param.isTop()) {
			
			var topImage = ImageIO.read(new File(param.getTopImage()));
			var width = sticker.getWidth() - topImage.getWidth() + 35; 
			var heigth = sticker.getHeight() - topImage.getHeight();
			
			graphic.drawImage(topImage, width, heigth, null);
		}
	}

	private void formatText(StickerParameters param, Map<String, Integer> size, BufferedImage sticker, Graphics2D graphic) {

		var font = new Font(param.getFontName(), param.getFontStyle(), param.getFontSize());

		Shape textShape = new TextLayout(param.getText(), font, graphic.getFontRenderContext()).getOutline(scaleText(param.getText(), size.get(WIDTH), font));

		var coordinateX = (sticker.getWidth() - textShape.getBounds().width) / 2;
		var coordinateY = ((param.getHeightPlus() - (textShape.getBounds().height)) / 2) + size.get(HEIGHT) + textShape.getBounds().height;
		graphic.translate(coordinateX, coordinateY);

		graphic.setColor(param.getTextColor());
		graphic.fill(textShape);
		graphic.setStroke(new BasicStroke(param.getStrokeNumber()));
		graphic.setColor(param.getStrokeColor());
		graphic.draw(textShape);
	}

	private AffineTransform scaleText(String text, int width, Font font) {
		
		var sizeFont = font.getStringBounds(text, new FontRenderContext(null, true, true));
		if (sizeFont.getWidth() >= width) {
			AffineTransform textScaled = new AffineTransform();
			var scale = (Double.valueOf(width) / sizeFont.getWidth()) - .1;
			textScaled.scale(scale, scale);
			return textScaled;
		}
		return null;
	}

}
