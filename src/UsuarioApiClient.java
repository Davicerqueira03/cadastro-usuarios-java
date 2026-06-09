import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UsuarioApiClient {

    private static final String BASE_URL = "http://localhost:8080/usuarios";
    private final HttpClient client;

    public UsuarioApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    public void criarUsuario(int id, String nome, String email) {
        String json = String.format(
                "{\"id\":%d,\"nome\":\"%s\",\"email\":\"%s\"}",
                id, nome, email
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        enviarRequisicao(request);
    }

    public void listarUsuarios() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        enviarRequisicao(request);
    }

    public void atualizarUsuario(int id, String nome, String email) {
        String json = String.format(
                "{\"id\":%d,\"nome\":\"%s\",\"email\":\"%s\"}",
                id, nome, email
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        enviarRequisicao(request);
    }

    public void removerUsuario(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .DELETE()
                .build();

        enviarRequisicao(request);
    }

    private void enviarRequisicao(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("\nStatus HTTP: " + response.statusCode());
            System.out.println("Resposta: " + response.body());

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao conectar com a API.");
            System.out.println("Verifique se o projeto Spring Boot esta rodando.");
        }
    }
}