package com.lucas.dio_padroes_projeto.repository;

import com.lucas.dio_padroes_projeto.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
