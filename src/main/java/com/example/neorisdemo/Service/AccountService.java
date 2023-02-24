package com.example.neorisdemo.Service;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Model.Cuenta;
import com.example.neorisdemo.Repository.AccountRepository;
import com.example.neorisdemo.Repository.ClientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class AccountService {
    AccountRepository accountRepository;
    ClientRepository clientRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository, MovementService movementService) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public Cuenta addAccount(Cuenta cuenta, String clientId){
        cuenta.setCliente(clientRepository.findByPersonaId(clientId));
        return accountRepository.save(cuenta);
    }

    public Cuenta getAccountById(Long numerocuenta){
        return accountRepository.findByNumeroCuenta(numerocuenta);
    }

    public List<Cuenta> getAllByClient(String clienteid){
        Cliente cliente = clientRepository.findByPersonaId(clienteid);
        return accountRepository.findAllByCliente(cliente);
    }

    public Integer deleteAccount(Long numeroCuenta){
        return accountRepository.deleteByNumeroCuenta(numeroCuenta);
    }

}
