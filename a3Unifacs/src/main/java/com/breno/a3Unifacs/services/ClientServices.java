package com.breno.a3Unifacs.services;

import com.breno.a3Unifacs.model.Client;
import com.breno.a3Unifacs.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {
    final ClientRepository clientRepository;

    public ClientServices(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    public Client save(Client client){return clientRepository.save(client);}
    public List<Client> findAll (){ return clientRepository.findAll();}
    public Optional<Client> findById(Integer id){return clientRepository.findById(id);}
    public void delete (Client client){clientRepository.delete(client);}

}
