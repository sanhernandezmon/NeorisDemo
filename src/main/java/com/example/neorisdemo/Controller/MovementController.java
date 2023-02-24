package com.example.neorisdemo.Controller;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Model.Movimiento;
import com.example.neorisdemo.Service.ClientService;
import com.example.neorisdemo.Service.MovementService;
import io.vavr.control.Either;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@NoArgsConstructor
@RestController
public class MovementController {

    private MovementService movementService;

    @Autowired
    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping("/api/movimiento")
    ResponseEntity<?> newMovement(@RequestBody Movimiento newMovement, @RequestParam("cuentaId") Long cuentaId) {
        Movimiento movimiento = movementService.addMovement(newMovement, cuentaId);

        if(movimiento == null){
            return ResponseEntity.badRequest().body("Saldo insoficiente");
        }
        return ResponseEntity.ok(movimiento);
    }
    @GetMapping("/api/movimiento/{numerocuenta}")
    List<Movimiento> GetMovementsByAccount(@PathVariable Long numerocuenta) {
        return movementService.getMovementsByAccount(numerocuenta);
    }

    @DeleteMapping("/api/movimiento/{numerocuenta}")
    Integer DeleteMovementsByAccount(@PathVariable Long numerocuenta) {
        return movementService.deleteMovements(numerocuenta);
    }

}
