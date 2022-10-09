package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> getAll(){
        return repository.getAll();

    }
    public Optional<Client> getClient(int idClient){
        return repository.getClient(idClient);
    }
    public Client save(Client client){
        if (client.getIdClient()==null){
            return repository.save(client);
        }
        else{
            Optional<Client> evt=repository.getClient(client.getIdClient());
            if(evt.get()!=null){
                return repository.save(client);
            }else{
                return client;
            }

        }

    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= repository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                repository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            repository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
