import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void criar(String imgUrl, String msg, String fileName) {
        try {
            // leitura da imagem
            // var inputStream = new FileInputStream(new File("entrada/filme.jpg"));
            var inputStream = new URL(imgUrl).openStream();
            var imgOriginal = ImageIO.read(inputStream);

            // cria nova imagem em memória com transparência e com o tamanho novo
            var largura = imgOriginal.getWidth();
            var altura = imgOriginal.getHeight();
            var alturaNova = altura + 500;

            BufferedImage imgNova = new BufferedImage(largura, alturaNova, BufferedImage.TRANSLUCENT);

            // copiar a imagem original pra nova imagem (em memoria)
            var graphics = (Graphics2D) imgNova.getGraphics();
            graphics.drawImage(imgOriginal, 0, 0, null);

            // Configurar a fonte
            var font = new Font(Font.MONOSPACED, Font.BOLD, 100);
            graphics.setFont(font);
            graphics.setColor(Color.ORANGE);

            // escrever uma frase na nova imagem
            graphics.drawString(msg, 0, alturaNova - 250);

            // escrever a nova imagem em um arquivo
            ImageIO.write(imgNova, "png", new File("saida/" + fileName + ".png"));
        } catch (Exception e) {
            System.out.println("\n Houve um erro ao criar a figurinha. Com os seguintes parametros: \n"
                                + "Imagem url:" + imgUrl + " \n"
                                + "Mensagem: " + msg + "\n"
                                + "Nome do arquivo: " + fileName + "\n"
                                + "Detalhes do erro: " + e.getMessage() + "\n");
        }
    }
}
