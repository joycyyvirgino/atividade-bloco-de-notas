package clasemetado;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
        //Atributos
    private List<Contato> contatos =new ArrayList<Contato>();

    public List<Contato> getContatos() {
        return contatos;
    }
    //Adicionar contato
    public boolean adicionarContato(String nome, String telefone, String email){
       return contatos.add(new Contato(nome,telefone,email));
    }
    //Buscar contato
    public List<Contato> buscarContato(String nome){
        List<Contato> validos = new ArrayList<>();
        for (Contato c : contatos) {
            if (c.getNome().equals(nome)) {
                validos.add(c);
            }
        }
        return validos;
    }
    //Editar contato
    public boolean editarContato(String nome, String email) {
        for (Contato c : contatos) {
            if (c.getNome().equals(nome)) {
                c.setEmail(email);
                return true;
            }
        }
        return false; // Retorna false se nenhum contato com esse nome for encontrado
    }


    @Override
    public String toString() {
        return "Agenda{" +
                "contatos=" + contatos +
                '}';
    }
}
