package model.entity;

public class Entregador {

    int id;
    String nome;
    String veiculo;
    boolean disponivel;

    public Entregador(int id, String nome, String veiculo, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.veiculo = veiculo;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void exibirDados() {

        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Veículo: " + veiculo);
        System.out.println("Dísponivel: " + disponivel);
    }
}