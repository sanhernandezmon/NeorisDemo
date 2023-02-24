package com.example.neorisdemo.Service;

import com.example.neorisdemo.Model.Cuenta;
import com.example.neorisdemo.Repository.AccountRepository;
import lombok.NoArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class AccountService {
    AccountRepository accountRepository;
    @Autowired
    ClientService clientService;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Cuenta addAccount(Cuenta cuenta, String clientId){
        cuenta.setCliente(clientService.getClientById(clientId));
        return accountRepository.save(cuenta);
    }

    public Cuenta getAccountById(Long cuentaId){
        return accountRepository.findByNumeroCuenta(cuentaId);
    }


}
