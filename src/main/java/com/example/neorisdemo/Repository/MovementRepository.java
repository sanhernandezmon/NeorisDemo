package com.example.neorisdemo.Repository;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Model.Cuenta;
import com.example.neorisdemo.Model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movimiento, String> {
    List<Movimiento> findAllByCuentaAndTipoMovimiento(Cuenta cuenta, String tipoMovimiento);
}
