import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://imdb-api.com/en/API/MostPopularMovies/k_4hhbeiwn";

        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        var body = response.body();

        //System.out.println(body);

        // extrair só os dados que interessam (título , poster, classificação )
        var extrair = new JsonParser();
        List<Map<String, String>> listaDeFilmes = extrair.parse(body);

        //System.out.println(listaDeFilmes.size()); 
        //System.out.println(listaDeFilmes.get(0));

        // exibir e manipular os dados
        System.out.println();
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("rank"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

    }
}
