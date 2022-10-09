package com.example.demo.interfaz;

import com.example.demo.model.Client;
import org.springframework.data.repository.CrudRepository;


public interface IClientRepository extends CrudRepository<Client, Integer> {

}