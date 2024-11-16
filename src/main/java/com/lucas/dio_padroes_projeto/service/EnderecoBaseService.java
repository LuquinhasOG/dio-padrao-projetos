package com.lucas.dio_padroes_projeto.service;

import com.lucas.dio_padroes_projeto.model.Endereco;
import com.lucas.dio_padroes_projeto.model.Model;
import org.springframework.stereotype.Service;

@Service
public class EnderecoBaseService implements BaseService {
    @Override
    public Iterable<Endereco> buscarTodos() {
        return null;
    }

    @Override
    public Endereco buscarPorId(int id) {
        return null;
    }

    @Override
    public void inserir(Model model) {

    }

    @Override
    public void atualizar(int id, Model model) {

    }

    @Override
    public void deletar(int id) {

    }
}
