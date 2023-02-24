package com.example.neorisdemo.Service;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Repository.ClientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Cliente addClient(Cliente cliente){
        return clientRepository.save(cliente);
    }

    public Cliente getClientById(String clienteId){
        return clientRepository.findClienteByPersonaId(clienteId);
    }
}
