package com.example.neorisdemo.Controller;

import com.example.neorisdemo.Model.Cuenta;
import com.example.neorisdemo.Model.Movimiento;
import com.example.neorisdemo.Service.AccountService;
import com.example.neorisdemo.Service.MovementService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/cuenta")
    Cuenta newEmployee(@RequestBody Cuenta newCuenta, @RequestParam("clienteId") String clientId) {
        return accountService.addAccount(newCuenta, clientId);
    }
}
