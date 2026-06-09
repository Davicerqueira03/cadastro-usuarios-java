package repository;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;


public class UsuarioRepository {
    private static UsuarioRepository instancia;
    private List<Usuario> usuarios;

    private UsuarioRepository() {
        usuarios = new ArrayList<>();
    }

    public static UsuarioRepository getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioRepository();
        }
        return instancia;
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> listar(){
        return usuarios;
    }

    public Usuario buscarId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        Usuario usuario = buscarId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }


}
