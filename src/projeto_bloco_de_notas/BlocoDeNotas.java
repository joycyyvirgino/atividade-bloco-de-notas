package projeto_bloco_de_notas;

import java.util.ArrayList;
import java.util.List;

public class BlocoDeNotas {
    private List<Anotacoes> anotacao = new ArrayList<Anotacoes>();

    public List<Anotacoes> getAnotacoes() {
        return anotacao;
    }

    //adicionar anotações
    public void adicionarTexto(String texto) {
        int index = anotacao.size();
        try {
            anotacao.add(new Anotacoes(texto, index+1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    // EXIBIR ANOTAÇÕES
    public void exibirAnotacoes() {
        System.out.println("=-=-=-= MINHAS ANOTAÇÕES =-=-=-=");
        for (Anotacoes anotacoes : this.anotacao) {
            System.out.println(anotacoes.getId() + " - " + anotacoes.getTexto() + " - " + anotacoes.getDataDeCriacao());
        }
    }
    //Buscar Anotações
    public List<Anotacoes> bucarAnotacao(String buscar) {
        List<Anotacoes> resultados = new ArrayList<>();
        for (Anotacoes anotacoes : anotacao) {
            if (anotacoes.contemTexto(buscar) && !anotacoes.isDeleted()) {
                resultados.add(anotacoes);
            }
        }
        return resultados;
    }
    //Editar texto
    public void editarAnotacao(int index, String novoTexto) {
        // COMO AS ANOTAÇÕES SÃO EXIBIDAS COM OS ID'S COMEÇANDO A PARTIR DO 1, É RETIRADO 1 DO INDICE ENVIADO PARA PEGAR A ANOTAÇÃO CORRETA NA LISTA, JÁ QUE ELA COMEÇA A PARTIR DO 0

        try {
            Anotacoes anotacao = this.anotacao.get(index-1);
            anotacao.setTexto(novoTexto);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //Remover notas
    public void remover(int index) {
        try {
            anotacao.remove(index-1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "BlocoDeNotas{" +
                "anotacao=" + anotacao +
                '}';
    }
}