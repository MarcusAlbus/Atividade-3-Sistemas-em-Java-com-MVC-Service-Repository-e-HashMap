package controller;

import model.entity.Entregador;
import model.service.EntregadorService;

import java.util.HashMap;

public class EntregadorController {

    private EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService){
        this.entregadorService = entregadorService;
    }

    public void cadastrar(int id, String nome, String veiculo, boolean disponivel){
        boolean resultado = entregadorService.cadastrar(id, nome, veiculo, disponivel);
        if (resultado){
            System.out.println("Entregador cadastrado com sucesso.");
        }else{
            System.out.println("Erro ao cadastrar o entregador. Verifique os dados informados");
        }
    }

    public void buscarPorId(int id){
        Entregador entregador = entregadorService.buscarPorId(id);
        if(entregador == null){
            System.out.println("Entregador com ID "+ id + " não foi encontrado");
        }else{
            entregador.exibirDados();
        }
    }

    public void listar(){
        HashMap<Integer, Entregador> entregadores = entregadorService.listar();

        if(entregadores.isEmpty()){
            System.out.println("Nenhum entregador cadastrado.");
        }else{
            for (Entregador entregador: entregadores.values()){
                entregador.exibirDados();
                System.out.println("---------------------------");
            }
        }
    }

    public void atualizar(int id, String novoNome, String novoVeiculo, boolean novoDisponivel){
        boolean resultado = entregadorService.atualizar(id, novoNome, novoVeiculo, novoDisponivel);
        if (resultado){
            System.out.println("Entregador atualizado com sucesso.");
        }else{
            System.out.println("Erro ao atualizar o entregador. Verifique os dados.");
        }
    }

    public void remover(int id){
        boolean resultado = entregadorService.remover(id);
        if (resultado){
            System.out.println("Entregador removido com sucesso.");
        }else{
            System.out.println("Entregador com ID "+ id + " não encontrado.");
        }
    }

}
