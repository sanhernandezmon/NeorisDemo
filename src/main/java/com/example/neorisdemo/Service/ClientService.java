package com.example.neorisdemo.Service;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Repository.ClientRepository;
import com.example.neorisdemo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PersonRepository personRepository;

    public ClientService() {
    }

    public Cliente addClient(Cliente cliente){
        return clientRepository.save(cliente);
    }
}
