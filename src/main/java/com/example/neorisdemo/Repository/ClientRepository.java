package com.example.neorisdemo.Repository;

import com.example.neorisdemo.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, String> {
    Cliente findClienteByPersonaId(String clientId);
}
