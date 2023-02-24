package com.example.neorisdemo.Service;

import com.example.neorisdemo.Model.Cuenta;
import com.example.neorisdemo.Model.Movimiento;
import com.example.neorisdemo.Repository.AccountRepository;
import com.example.neorisdemo.Repository.MovementRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class MovementService {
    MovementRepository movementRepository;
    AccountRepository accountRepository;

    @Autowired
    public MovementService(MovementRepository movementRepository, AccountRepository accountRepository) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
    }

    public Movimiento addMovement(Movimiento movimiento, Long numeroCuenta){
        Cuenta cuenta  = accountRepository.findByNumeroCuenta(numeroCuenta);
        movimiento.setCuenta(cuenta);
        Movimiento lastMovement = movementRepository.findFirstByCuentaOrderByFechaDesc(cuenta);
        long saldo = cuenta.getSaldoInicial();
        if (lastMovement!= null){
            saldo = lastMovement.getSaldo();
        }
        if (movimiento.getTipoMovimiento().equals("credito")){
            movimiento.setSaldo(saldo+ movimiento.getValor());
            return movementRepository.save(movimiento);
        }else{
            if(saldo - movimiento.getValor()<0){
                return null;
            }else{
                movimiento.setSaldo(saldo- movimiento.getValor());
                return movementRepository.save(movimiento);
            }
        }
    }

    public List<Movimiento> getMovementByAccountAndType(Long numeroCuenta, String type){
        Cuenta cuenta  = accountRepository.findByNumeroCuenta(numeroCuenta);
        return movementRepository.findAllByCuentaAndTipoMovimiento(cuenta, type);
    }

    public List<Movimiento> getMovementsByAccount(Long numerocuenta){
        Cuenta cuenta = accountRepository.findByNumeroCuenta(numerocuenta);
        return movementRepository.findAllByCuenta(cuenta);
    }

    public Integer deleteMovements(Long numerocuenta){
        Cuenta cuenta = accountRepository.findByNumeroCuenta(numerocuenta);
        return movementRepository.deleteAllByCuenta(cuenta);
    }
}
