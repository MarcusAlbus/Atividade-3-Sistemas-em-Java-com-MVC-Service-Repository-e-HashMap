package repository;

import entity.Entrega;

import java.util.HashMap;
import java.util.ArrayList;

public class EntregaRepository {

    private HashMap <Integer, Entrega> entregas = new HashMap<>();

    public void salvar(Entrega entrega) {
        entregas.put(entrega.getId(), entrega);
    }

    public Entrega buscarPorId(int id) {
        return entregas.get(id);
    }

    public ArrayList<Entrega> listar() {

        ArrayList<Entrega> lista = new ArrayList<>();

        for (Entrega entrega : entregas.values()) {
            lista.add(entrega);
        }

        return lista;
    }

    public void atualizar(Entrega entrega) {
        entregas.put(entrega.getId(), entrega);
    }

    public void remover (int id) {
        entregas.remove(id);
    }
}