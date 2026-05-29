package model.service;

import java.util.HashMap;

import model.entity.Cliente;
import model.repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrar (int id, String nome, String endereco) {

        try {

            if(nome == null || nome.isEmpty()) {
                return false;
            }

            if (endereco == null || endereco.isEmpty()) {
                return false;
            }

            Cliente cliente = new Cliente(id, nome, endereco);
            repository.salvar(cliente);

            return true;


        } catch (Exception e) {

            System.out.println("Erro ao cadastrar cliente!");
            return false;
        }
    }

    public Cliente buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public HashMap<Integer, Cliente> listar() {
        return repository.listar();
    }

    public boolean atualizar (int id, String novoNome, String novoEndereco) {

        try {

            Cliente cliente = repository.buscarPorId(id);

            if (cliente == null) {
                return false;
            }

            if (novoNome == null || novoNome.isEmpty()) {
                return false;
            }

            if (novoEndereco == null || novoEndereco.isEmpty()) {
                return false;
            }

            cliente.setNome(novoNome);
            cliente.setEndereco(novoEndereco);

            return true;

        } catch(Exception e) {

            System.out.println("Erro ao atualizar cliente!");
            return false;
        }
    }

    public boolean remover(int id) {

        try {

            Cliente cliente = repository.buscarPorId(id);

            if (cliente == null) {
                return false;
            }

            repository.remover(id);
            return true;

        } catch (Exception e) {

            System.out.println("Erro ao atualizar cliente!");
            return false;
        }
    }
}