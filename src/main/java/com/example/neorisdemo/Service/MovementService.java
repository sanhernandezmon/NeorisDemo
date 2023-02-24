package com.example.neorisdemo.Service;

import com.example.neorisdemo.Model.Cuenta;
import com.example.neorisdemo.Model.Movimiento;
import com.example.neorisdemo.Repository.MovementRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class MovementService {
    MovementRepository movementRepository;
    private AccountService accountService;

    @Autowired
    public MovementService(MovementRepository movementRepository, AccountService accountService) {
        this.movementRepository = movementRepository;
        this.accountService = accountService;
    }

    public Movimiento addMovement(Movimiento movimiento, Long cuentaId){
        Cuenta cuenta  = accountService.getAccountById(cuentaId);
        movimiento.setCuenta(cuenta);
        long saldo = cuenta.getSaldoInicial();
        for (Movimiento mov: getMovementByAccountAndType(cuentaId, "debito")) {
            saldo += mov.getValor();
        }
        for (Movimiento mov: getMovementByAccountAndType(cuentaId, "credito")) {
            saldo -= mov.getValor();
        }
        if (movimiento.getTipoMovimiento().equals("debito")){
            movimiento.setSaldo(saldo+ movimiento.getValor());
            return movementRepository.save(movimiento);
        }else{
            if(saldo<0){
                System.out.println("saldo negativo no permite hacer movimiento de credito");
                return null;
            }else{
                movimiento.setSaldo(saldo- movimiento.getValor());
                return movementRepository.save(movimiento);
            }
        }
    }

    public List<Movimiento> getMovementByAccountAndType(Long cuentaId, String type){
        Cuenta cuenta  = accountService.getAccountById(cuentaId);
        return movementRepository.findAllByCuentaAndTipoMovimiento(cuenta, type);
    }
}
