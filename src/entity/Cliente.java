package entity;

public class Cliente {

    int id;
    String nome;
    String endereço;

    public Cliente(int id, String nome, String endereço) {
        this.id = id;
        this.nome = nome;
        this.endereço = endereço;
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

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void exibirDados() {

        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereço);
    }
}
