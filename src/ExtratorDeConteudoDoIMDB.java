import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {

    public List<Conteudo> extrairConteudos (String json) {

        // extrair só os dados que interessam (título , poster, classificação )
        var extrair = new JsonParser();
        List<Map<String, String>> listaDeAtributos = extrair.parse(json);

        // Popular a lsita de conteudos
        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {

            var regex = "(_+)(.*).jpg$";
            var replacement = ".jpg";

            var titulo = atributos.get("title");
            var urlImagem = atributos.get("image").replaceAll(regex, replacement);
            var conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        }

        return conteudos;
    }

}
