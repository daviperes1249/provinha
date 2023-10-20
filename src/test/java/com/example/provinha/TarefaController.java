package com.example.provinha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/{id}")
    public Tarefa consultarTarefa(@PathVariable int id) {
        return tarefaService.consultarTarefa(id);
    }

    @PostMapping
    public Tarefa adicionarTarefa(@RequestBody TarefaRequest request) {
        return tarefaService.adicionarTarefa(request.getDescricao());
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable int id, @RequestBody TarefaRequest request) {
        return tarefaService.atualizarTarefa(id, request.getDescricao());
    }

    @PatchMapping("/{id}/status")
    public Tarefa atualizarStatusTarefa(@PathVariable int id, @RequestParam boolean concluida) {
        return tarefaService.atualizarStatusTarefa(id, concluida);
    }

    @DeleteMapping("/{id}")
    public void removerTarefa(@PathVariable int id) {
        tarefaService.removerTarefa(id):
    }
}

