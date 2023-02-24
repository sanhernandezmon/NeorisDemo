package com.example.neorisdemo.Controller;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("/cliente")
    Cliente newEmployee(@RequestBody Cliente newClient) {
        return clientService.addClient(newClient);
    }
}
