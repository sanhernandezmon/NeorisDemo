package com.example.neorisdemo.Repository;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Model.Cuenta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Cuenta, Long> {
    Cuenta findByNumeroCuenta(Long numeroCuenta);
    List<Cuenta> findAllByCliente(Cliente cliente);
    @Transactional
    @Modifying
    Integer deleteByNumeroCuenta(Long numeroCuenta);
}
