package com.example.neorisdemo.Repository;

import com.example.neorisdemo.Model.Cliente;
import com.example.neorisdemo.Model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Cuenta, Long> {
    Cuenta findByNumeroCuenta(Long numeroCuenta);
}
