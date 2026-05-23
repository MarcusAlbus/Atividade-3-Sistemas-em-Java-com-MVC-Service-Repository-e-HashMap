package repository;

import entity.Entregador;

import java.util.HashMap;
import java.util.ArrayList;

public class EntregadorRepository {

    private HashMap<Integer, Entregador> entregadores = new HashMap<>();

    public void salvar (Entregador entregador) {
        entregadores.put(entregador.getId(), entregador);
    }

    public Entregador buscarPorId(int id) {
        return entregadores.get(id);
    }

    public ArrayList<Entregador> listar() {

        ArrayList<Entregador> lista = new ArrayList<>();

        for(Entregador entregador : entregadores.values()) {
            lista.add(entregador);
        }

        return lista;
    }

    public void atualizar(Entregador entregador) {
        entregadores.put(entregador.getId(), entregador);
    }

    public void remover(int id) {
        entregadores.remove(id);
    }
}