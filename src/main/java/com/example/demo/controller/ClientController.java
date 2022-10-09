package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> getClient(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id")int idClient){
        return service.getClient(idClient);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Client client) {
        service.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Client client) {
        service.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int idClient) {
        service.deleteClient(idClient);
    }
}
