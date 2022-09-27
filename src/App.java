
public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        // String url = "https://imdb-api.com/en/API/MostPopularMovies/k_4hhbeiwn";
        
        //String url = "https://api.nasa.gov/planetary/apod?start_date=2022-09-01&end_date=2022-09-22&api_key=aOPOPk0IxSc6zBgAZoVhKcUa7D10Ksx3HvhT3tj4";
        //var extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8080/linguagens";
        var extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp();
        var json = http.buscaDados(url);

        // exibir e manipular os dados
        var listaDeConteudo = extrator.extrairConteudos(json);

        // Gerar figurinha
        var gerador = new GeradorDeFigurinhas();

        for (var conteudo : listaDeConteudo) {
            if (!conteudo.getUrlImagem().isEmpty() && !conteudo.getTitulo().isEmpty()) {
                gerador.criar(conteudo.getUrlImagem(), "TOPZEIRA", conteudo.getTitulo().replaceAll(" ", "_"));
                System.out.println(conteudo.getTitulo());
            }
        }
    }
}
