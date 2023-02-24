package com.example.neorisdemo.Controller;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Model.Movimiento;
import com.example.neorisdemo.Service.ClientService;
import com.example.neorisdemo.Service.MovementService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
public class MovementController {

    private MovementService movementService;

    @Autowired
    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping("/movimiento")
    Movimiento newEmployee(@RequestBody Movimiento newMovement, @RequestParam("cuentaId") Long cuentaId) {
        return movementService.addMovement(newMovement, cuentaId);
    }
}
