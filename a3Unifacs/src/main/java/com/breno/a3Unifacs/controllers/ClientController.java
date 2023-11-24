package com.breno.a3Unifacs.controllers;

import com.breno.a3Unifacs.dtos.ClientDto;
import com.breno.a3Unifacs.model.Client;
import com.breno.a3Unifacs.services.ClientServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    final ClientServices clientServices;

    public ClientController(ClientServices clientServices){
        this.clientServices = clientServices;
    }
    @PostMapping("/cliente")
    public ResponseEntity<Client> saveClient( @RequestBody ClientDto clientDto){
        var client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientServices.save(client));
    }
    @GetMapping("/clientes")
    public ResponseEntity<List<Client>> getAllClient(){
        List<Client> clientList = (clientServices.findAll());

        return ResponseEntity.status(HttpStatus.OK).body(clientServices.findAll());
     }
     @GetMapping("/cliente/id/{id}")
    public ResponseEntity<Object> getClientById( @PathVariable(value = "id") Integer id ){
         Optional<Client> client1 =(clientServices.findById(id));

         if(client1.isEmpty()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe!");
         }
         return ResponseEntity.status(HttpStatus.OK).body(client1.get());
     }

    @DeleteMapping("/cliente/id/{id}")
        public ResponseEntity<Object> deleteClient(@PathVariable(value = "id")Integer id){
        Optional<Client> client1 = (clientServices.findById(id));

        if(client1.isEmpty()){
        return ResponseEntity.status(HttpStatus.OK).body("Cliente não existe!");
        }
        clientServices.delete(client1.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente apagado com Sucesso");

    }



}
