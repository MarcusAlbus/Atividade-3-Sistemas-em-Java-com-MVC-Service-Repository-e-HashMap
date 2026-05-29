package model.service;

import java.util.HashMap;

import model.entity.Cliente;
import model.entity.Entregador;
import model.entity.Entrega;

import model.repository.ClienteRepository;
import model.repository.EntregadorRepository;
import model.repository.EntregaRepository;


public class EntregaService {

    private ClienteRepository repositoryCliente;
    private EntregadorRepository repositoryEntregador;
    private EntregaRepository repositoryEntrega;

    public EntregaService(
            ClienteRepository repositoryCliente,
            EntregadorRepository repositoryEntregador,
            EntregaRepository repositoryEntrega) {

        this.repositoryCliente = repositoryCliente;
        this.repositoryEntregador = repositoryEntregador;
        this.repositoryEntrega = repositoryEntrega;
    }

    public boolean cadastrar(int id, int clienteId, int entregadorId, String descricao, String status) {

        try {

            Cliente cliente = repositoryCliente.buscarPorId(clienteId);
            Entregador entregador = repositoryEntregador.buscarPorId(entregadorId);


            if (cliente == null || entregador == null) {
                return false;
            }

            if (!entregador.isDisponivel()) {
                return false;
            }

            if (descricao == null || descricao.isEmpty()) {
                return false;
            }

            if (status == null || status.isEmpty()) {
                return false;
            }

            if (!status.equals ("PENDENTE")
                    && !status.equals ("EM_ANDAMENTO")
                    && !status.equals("FINALIZADA")) {
                return false;
            }

            Entrega entrega = new Entrega (id, cliente, entregador, descricao, status);

            entregador.setDisponivel(false);
            repositoryEntrega.salvar(entrega);

            return true;

        } catch(Exception e) {

            System.out.println("Erro ao cadastrar entrega!");
            return false;
        }
    }

    public Entrega buscarPorId(int id) {
        return repositoryEntrega.buscarPorId(id);
    }

    public HashMap<Integer, Entrega> listar() {
        return repositoryEntrega.listar();
    }

    public boolean atualizar(
            int id,
            int clienteId,
            int entregadorId,
            String novaDescricao,
            String novoStatus
    ) {

        try {

            Entrega entrega = repositoryEntrega.buscarPorId(id);

            Cliente cliente = repositoryCliente.buscarPorId(clienteId);

            Entregador entregador = repositoryEntregador.buscarPorId(entregadorId);

            if (entrega == null || cliente == null || entregador == null) {
                return false;
            }

            if (novaDescricao == null || novaDescricao.isEmpty()) {
                return false;
            }

            if (novoStatus == null || novoStatus.isEmpty()) {
                return false;
            }

            if (novoStatus.equals("FINALIZADA") && entrega.getStatus().equals("PENDENTE")) {
                return false;
            }

            if (!novoStatus.equals("PENDENTE")
                    && !novoStatus.equals("EM_ANDAMENTO")
                    && !novoStatus.equals("FINALIZADA")) {

                return false;
            }

            if (!entregador.isDisponivel()) {
                return false;
            }

            entrega.setCliente(cliente);
            entrega.setEntregador(entregador);
            entrega.setDescricao(novaDescricao);
            entrega.setStatus(novoStatus);

            return true;

        } catch (Exception e) {

            System.out.println("Erro ao atualizar entrega!");
            return false;
        }
    }

    public boolean remover(int id) {

        try {

            Entrega entrega = repositoryEntrega.buscarPorId(id);

            if (entrega == null) {
                return false;
            }

            if (entrega.getStatus().equals("EM_ANDAMENTO")) {
                return false;
            }

            repositoryEntrega.remover(id);
            return true;


        } catch(Exception e) {

            System.out.println("Erro ao remover entrega!");
            return false;
        }
    }
}