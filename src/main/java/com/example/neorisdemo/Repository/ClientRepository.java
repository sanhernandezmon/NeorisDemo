package com.example.neorisdemo.Repository;

import com.example.neorisdemo.Model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, String> {

    @Modifying
    @Transactional
    Integer deleteByPersonaId(String personaId);

    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.telefono = ?2 WHERE c.personaId = ?1")
    Cliente updatePhone(String id, Long phone);


    Cliente findByPersonaId(String clienteId);
}
