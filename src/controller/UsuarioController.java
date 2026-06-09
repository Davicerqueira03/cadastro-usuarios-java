package controller;

import factory.UsuarioFactory;
import model.Usuario;
import repository.UsuarioRepository;
import java.util.List;


public class UsuarioController {
    private UsuarioRepository repository;

    public UsuarioController() {
        this.repository = UsuarioRepository.getInstancia();
    }

    public void criarUsuario(int id, String nome, String email){
        Usuario usuario = UsuarioFactory.criarUsuario(id, nome, email);

        if (!usuario.validarEmail()){
            System.out.println("Email errado.");
            return;
        }

        if (repository.buscarId(id) != null){
            System.out.println("Erro: id ja existente.");
            return;
        }

        repository.adicionar(usuario);
        System.out.println("Usuario adicionado com sucesso.");
        return;
    }

    public void listarUsuarios(){
        List<Usuario> usuarios = repository.listar();

        if (usuarios.isEmpty()){
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }

        for (Usuario usuario : usuarios){
            System.out.println(usuario);
        }
    }

    public void atualizarUsuario(int id, String novoNome, String novoEmail){
        Usuario usuario = repository.buscarId(id);

        if (usuario == null){
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }

        if (novoEmail == null || !novoEmail.contains("@")){
            System.out.println("Erro: email invalido.");
            return;
        }

        usuario.setNome(novoNome);
        usuario.setEmail(novoEmail);
        System.out.println("Usuario atualizado com sucesso.");
    }

    public void deletarUsuario(int id){
        boolean removido = repository.remover(id);

        if (removido){
            System.out.println("Usuario removido com sucesso.");
        } else {
            System.out.println("Erro: usuario não encontrado.");
        }
    }

}
