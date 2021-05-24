package com.example.Bank;

import com.example.Bank.Domain.Client;
import com.example.Bank.Service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
@RestController
public class ClientRessource {
    private final ClientService clientService;

    public ClientRessource(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>>  getAllClients(){
        //call the service to find all the clients
        List<Client> clients = clientService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Client>  getClientByTd(@PathVariable("id") Long id){   //taking the id on the path and it should match
        Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client){   //taking it as a json object
        Client new_client = clientService.addClient(client);
        return new ResponseEntity<>(new_client, HttpStatus.CREATED);    //because we just create it from the server
    }
    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        Client update_client = clientService.updateClient(client);
        return new ResponseEntity<>(update_client, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")     //passing a variable into the URL
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
