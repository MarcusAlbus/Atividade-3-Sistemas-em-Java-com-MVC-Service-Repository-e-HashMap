package model.entity;

public class Entrega {

    int id;
    Cliente cliente;
    Entregador entregador;
    String descricao;
    String status;

    public Entrega(int id, Cliente cliente, Entregador entregador, String descricao, String status) {
        this.id = id;
        this.cliente = cliente;
        this.entregador = entregador;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void exibirDados() {

        System.out.println("Id: " + id);
        System.out.println("Cliente: " + cliente);
        System.out.println("Entregador: " + entregador);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);

    }
}