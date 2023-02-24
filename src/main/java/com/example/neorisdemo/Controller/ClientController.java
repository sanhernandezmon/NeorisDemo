package com.example.neorisdemo.Controller;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Service.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@RestController
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/api/cliente")
    Cliente NewClient(@RequestBody Cliente newClient) {
        return clientService.addClient(newClient);
    }

    @GetMapping("/api/cliente/{clienteId}")
    Cliente GetClient(@PathVariable String clienteId){
        return clientService.getClientById(clienteId);
    }

    @GetMapping("/api/cliente")
    List<Cliente> getAllClient(){
        return clientService.getAllClient();
    }

    @PutMapping("/api/cliente/{clienteId}")
    Cliente UpdateClientPhone(@PathVariable String clienteId, @RequestParam Long phone){
        return clientService.updatePhoneNumber(clienteId, phone);
    }

    @DeleteMapping("/api/cliente/{clienteId}")
    Integer DeleteClient(@PathVariable String clienteId){
        return clientService.deleteCliente(clienteId);
    }

}
