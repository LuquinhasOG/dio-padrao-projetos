package com.lucas.dio_padroes_projeto.service;

import com.lucas.dio_padroes_projeto.model.Model;

public interface BaseService {
    Iterable<? extends Model> buscarTodos();
    Model buscarPorId(int id);
    void inserir(Model model);
    void atualizar(int id, Model model);
    void deletar(int id);
}
