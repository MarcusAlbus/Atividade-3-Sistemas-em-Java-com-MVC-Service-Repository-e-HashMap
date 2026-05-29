package model.service;

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



}
