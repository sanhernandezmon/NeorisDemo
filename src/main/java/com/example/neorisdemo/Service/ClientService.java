package com.example.neorisdemo.Service;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Repository.ClientRepository;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ClientService {
    ClientRepository clientRepository;

    AccountService accountService;

    MovementService movementService;
    Logger logger = LoggerFactory.getLogger(ClientService.class);


    @Autowired
    public ClientService(ClientRepository clientRepository, AccountService accountService, MovementService movementService) {
        this.clientRepository = clientRepository;
        this.accountService = accountService;
        this.movementService = movementService;
    }

    public Cliente addClient(Cliente cliente){
        return clientRepository.save(cliente);
    }

    public Cliente getClientById(String clienteId){
        return clientRepository.findByPersonaId(clienteId);
    }

    public List<Cliente> getAllClient(){
        return clientRepository.findAll();
    }
    public Integer deleteCliente(String clienteId){
        return clientRepository.deleteByPersonaId(clienteId);
    }
    public Cliente updatePhoneNumber(String personaId, Long phone){
        return clientRepository.updatePhone(personaId,phone);
    }

}
