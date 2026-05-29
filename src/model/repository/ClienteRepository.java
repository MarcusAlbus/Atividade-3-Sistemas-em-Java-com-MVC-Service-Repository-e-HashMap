package model.repository;

import model.entity.Cliente;

import java.util.HashMap;

public class ClienteRepository {

    private HashMap <Integer, Cliente> clientes = new HashMap<>();


    public void salvar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public Cliente buscarPorId(int id){
        return clientes.get(id);
    }

    public HashMap<Integer, Cliente> listar() {
        return clientes;
    }

    public void atualizar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public void remover(int id){
        clientes.remove(id);
    }
}