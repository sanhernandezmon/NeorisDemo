package com.example.neorisdemo.Controller;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Service.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/cliente")
    Cliente newEmployee(@RequestBody Cliente newClient) {
        return clientService.addClient(newClient);
    }
}
