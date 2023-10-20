package com.example.provinha;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    public Tarefa adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(proximoId, descricao, false);
        proximoId++;
        tarefas.add(novaTarefa);
        return novaTarefa;
    }

    public Tarefa consultarTarefa(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }

    public Tarefa atualizarTarefa(int id, String novaDescricao) {
        Tarefa tarefa = consultarTarefa(id);
        if (tarefa != null) {
            tarefa.setDescricao(novaDescricao);
        }
        return tarefa;
    }

    public Tarefa atualizarStatusTarefa(int id, boolean concluida) {
        Tarefa tarefa = consultarTarefa(id);
        if (tarefa != null) {
            tarefa.setConcluida(concluida);
        }
        return tarefa;
    }
}

