package clasemetado;

public class AgendaCelular {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        // Adicionando contatos
        agenda.adicionarContato("João", "123456", "joao@email.com");
        agenda.adicionarContato("Maria", "654321", "maria@email.com");

        // Testando a edição
        boolean atualizado = agenda.editarContato("João", "joao.novo@email.com");
        agenda.buscarContato("joycy");
       

    }
}
