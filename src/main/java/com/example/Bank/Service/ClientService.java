package com.example.Bank.Service;

import com.example.Bank.Domain.Client;
import com.example.Bank.Exception.UserNotFoundException;
import com.example.Bank.Repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo){
        this.clientRepo = clientRepo;
    }
    public Client addClient(Client client){
        //generer un identifiant random pour le client passé en param
    client.setId( UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
    return clientRepo.save(client);
    }
    public List<Client>  findAllClients(){
        return clientRepo.findAll();
    }
    public Client updateClient(Client client){
        return clientRepo.save(client);
    }
    public Client findClientById(Long id){
        //if found then return it else throw exception
        return clientRepo.findClientById(id).orElseThrow(()->new UserNotFoundException("User by id : "+id+" is not found!"));
    }
    public void deleteClient(Long id){
        clientRepo.deleteClientById(id);
    }

}