package com.breno.a3Unifacs.controllers;

import com.breno.a3Unifacs.dtos.ClientDto;
import com.breno.a3Unifacs.model.Client;
import com.breno.a3Unifacs.services.ClientServices;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
