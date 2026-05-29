package controller;

import model.entity.Entrega;
import model.service.EntregaService;

import java.util.HashMap;

public class EntregaController {

    private EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    public void cadastrar(int id, int clienteId, int entregadorId, String descricao, String status) {
        boolean resultado = entregaService.cadastrar(id, clienteId, entregadorId, descricao, status);
        if (resultado) {
            System.out.println("Entrega cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar entrega. Verifique os dados informados.");
        }
    }

    public void buscarPorId(int id) {
        Entrega entrega = entregaService.buscarPorId(id);
        if (entrega == null) {
            System.out.println("Entrega com ID " + id + " não encontrada.");
        } else {
            entrega.exibirDados();
        }
    }

    public void listar() {
        HashMap<Integer, Entrega> entregas = entregaService.listar();
        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada.");
        } else {
            for (Entrega entrega : entregas.values()) {
                entrega.exibirDados();
                System.out.println("─────────────────────");
            }
        }
    }

    public void atualizar(int id, int clienteId, int entregadorId, String novaDescricao, String novoStatus) {
        boolean resultado = entregaService.atualizar(id, clienteId, entregadorId, novaDescricao, novoStatus);
        if (resultado) {
            System.out.println("Entrega atualizada com sucesso!");
        } else {
            System.out.println("Erro ao atualizar entrega. Verifique os dados informados.");
        }
    }

    public void remover(int id) {
        boolean resultado = entregaService.remover(id);
        if (resultado) {
            System.out.println("Entrega removida com sucesso!");
        } else {
            System.out.println("Entrega com ID " + id + " não encontrada ou em andamento.");
        }
    }
}