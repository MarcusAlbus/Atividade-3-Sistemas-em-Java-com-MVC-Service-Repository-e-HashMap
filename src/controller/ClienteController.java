package controller;

import model.entity.Cliente;
import model.service.ClienteService;

import java.util.HashMap;

public class ClienteController {

    ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public void cadastrar(int id, String nome, String endereco){
        boolean resultado = clienteService.cadastrar(id,nome,endereco);
        if(resultado){
            System.out.println("Cliente cadastrado com sucesso.");
        }else{
            System.out.println("Erro ao cadastrar o cliente. Verifique os dados informados");
        }
    }

    public void buscarPorId(int id){
        Cliente cliente = clienteService.buscarPorId(id);
        if(cliente == null){
            System.out.println("Cliente com ID "+ id + " não encontrado.");
        }else {
            cliente.exibirDados();
        }
    }

    public void listar(){
        HashMap<Integer, Cliente> clientes = clienteService.listar();
        if(clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado.");
        }else {
            for(Cliente cliente : clientes.values()){
                cliente.exibirDados();
                System.out.println("----------------------");
            }
        }
    }

    public void atualizar(int id, String novoNome, String novoEndereco){
        boolean resultado = clienteService.atualizar(id, novoNome, novoEndereco);
        if(resultado){
            System.out.println("CLiente atuliazado com sucesso.");
        }else{
            System.out.println("Erro: ao atualizar cliente. Verifique os dados informados");
        }
    }

    public void remover(int id){
        boolean resultado = clienteService.remover(id);
        if (resultado){
            System.out.println("CLiente removido");
        }else{
            System.out.println("Cliente com ID "+ id + "não encontrado.");
        }

    }
}
