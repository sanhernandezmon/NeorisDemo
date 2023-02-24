package com.example.neorisdemo.Repository;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Model.Cuenta;
import com.example.neorisdemo.Model.Movimiento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movimiento, String> {
    List<Movimiento> findAllByCuentaAndTipoMovimiento(Cuenta cuenta, String tipoMovimiento);

    List<Movimiento> findAllByCuenta(Cuenta cuenta);
    @Modifying
    @Transactional
    Integer deleteAllByCuenta(Cuenta cuenta);

    @Transactional
    Movimiento findFirstByCuentaOrderByFechaDesc(Cuenta cuenta);

    @Query(value = "from Movimiento m where (m.fecha BETWEEN :startDate AND :endDate) AND m.cuenta = :cuenta")
    List<Movimiento> findAllByCuentaAndDate(@Param("cuenta")Cuenta cuenta, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
}
