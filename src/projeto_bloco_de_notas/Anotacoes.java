package projeto_bloco_de_notas;

import java.time.LocalDate;
import java.util.Objects;

public class Anotacoes {
    //atributos
    private String texto;
    private int id;
    private LocalDate dataDeCriacao;
    private boolean isDeleted;

    public Anotacoes(String texto, int id)throws Exception {
        verificarTexto(texto);
        this.id = id;
        this.texto = texto;
        this.dataDeCriacao = LocalDate.now();
        this.isDeleted = false; // Inicialmente, a anotação não está deletada
    }
//Exceções
    private void verificarTexto(String texto) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("Erro: O texto da anotação não pode estar vazio.");
        }
    }
    private void encontrarTexto(String texto) throws  Exception{
        if (texto == null || texto.trim().isEmpty()){
            throw new Exception("Texto não encontrado");

        }
    }
    //metados de retorno
    public String getTexto() {
        return texto;
    }

    public int getId() {
        return id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean contemTexto(String busca) {
        return texto.contains(busca);
    }

    @Override
    public String toString() {
        return "Anotacao{" +
                "texto='" + texto + '\'' +
                ", dataDeCriacao=" + dataDeCriacao +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Anotacoes anotacao = (Anotacoes) obj;
        return Objects.equals(texto, anotacao.texto) &&
                Objects.equals(dataDeCriacao, anotacao.dataDeCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, dataDeCriacao);
    }
}
