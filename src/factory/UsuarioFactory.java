package factory;
import model.Usuario;

public class UsuarioFactory {

    public static Usuario criarUsuario(int id, String nome, String email) {
        return new Usuario(id, nome, email);
    }
}
