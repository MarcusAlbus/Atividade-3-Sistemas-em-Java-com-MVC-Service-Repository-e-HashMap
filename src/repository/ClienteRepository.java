package repository;

import entity.Cliente;

import java.util.HashMap;
import java.util.ArrayList;

public class ClienteRepository {

    private HashMap <Integer, Cliente> clientes = new HashMap<>();


    public void salvar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public Cliente buscarPorId(int id){
        return clientes.get(id);
    }

    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();

        for (Cliente cliente : clientes.values()) {
            lista.add(cliente);
        }

        return lista;
    }

    public void atualizar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public void remover(int id){
        clientes.remove(id);
    }
}