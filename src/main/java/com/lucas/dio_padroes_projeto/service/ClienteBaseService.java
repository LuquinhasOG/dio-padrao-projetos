package com.lucas.dio_padroes_projeto.service;

import com.lucas.dio_padroes_projeto.model.Cliente;
import com.lucas.dio_padroes_projeto.model.Endereco;
import com.lucas.dio_padroes_projeto.model.Model;
import com.lucas.dio_padroes_projeto.repository.ClienteRepository;
import com.lucas.dio_padroes_projeto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteBaseService implements BaseService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCEPService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(int id) {
        Optional<Cliente> cliente =  clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Model model) {
        Cliente cliente = (Cliente) model;
        inserirEnderecoCliente(cliente);
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(int id, Model model) {
        Optional<Cliente> cliente =  clienteRepository.findById(id);
        if (cliente.isPresent()) {
            inserirEnderecoCliente(cliente.get());
            clienteRepository.save(cliente.get());
        }
    }

    @Override
    public void deletar(int id) {
        clienteRepository.deleteById(id);
    }

    private void inserirEnderecoCliente(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()-> {
            Endereco novo = viaCepService.consultarCep(cep);
            enderecoRepository.save(novo);
            return novo;
        });

        cliente.setEndereco(endereco);
    }
}
