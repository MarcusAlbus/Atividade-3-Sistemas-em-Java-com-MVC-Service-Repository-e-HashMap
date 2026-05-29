package model.service;

import java.util.HashMap;

import model.entity.Entregador;
import model.repository.EntregadorRepository;

public class EntregadorService {

    private EntregadorRepository repository;

    public EntregadorService(EntregadorRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrar (int id, String nome, String veiculo, boolean disponivel) {


        try {

            if (nome == null || nome.isEmpty()) {
                return false;
            }

            if (veiculo == null || veiculo.isEmpty()) {
                return false;
            }

            Entregador entregador = new Entregador (id, nome, veiculo, disponivel);
            repository.salvar(entregador);

            return true;

        } catch (Exception e) {

            System.out.println("Erro ao cadastrar entregador.");
            return false;
        }
    }

    public Entregador buscarPorId(int id) {
           return repository.buscarPorId(id);
    }

    public HashMap<Integer, Entregador> listar() {
        return repository.listar();
    }

    public boolean atualizar(int id, String novoNome, String novoVeiculo, boolean novoDisponivel) {

        try {

            Entregador entregador = repository.buscarPorId(id);

            if (entregador == null) {
                return false;
            }

            if (novoNome == null || novoNome.isEmpty()) {
                return false;
            }

            if (novoVeiculo == null || novoVeiculo.isEmpty()) {
                return false;
            }

            entregador.setNome(novoNome);
            entregador.setVeiculo(novoVeiculo);
            entregador.setDisponivel(novoDisponivel);

            return true;

        } catch(Exception e) {

            System.out.println("Erro ao atualizar entregador!");
            return false;
        }
    }

    public boolean remover (int id) {

        try {

            Entregador entregador = repository.buscarPorId(id);

            if (entregador == null) {
                return false;
            }

            repository.remover(id);
            return true;

        } catch(Exception e) {

            System.out.println("Erro ao remover entregador!");
            return false;

            }
        }
    }