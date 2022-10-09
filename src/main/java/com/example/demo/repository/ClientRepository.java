package com.example.demo.repository;

import com.example.demo.interfaz.IClientRepository;
import com.example.demo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository{
    @Autowired
    private IClientRepository crud;
    public List<Client> getAll() {
        return (List<Client>) crud.findAll();
    }

    public Optional<Client> getClient(Integer idClient) {
        return crud.findById(idClient);
    }

    public Client save(Client client) {
        return crud.save(client);
    }

    public void delete(Client client) {
        crud.delete(client);
    }
}