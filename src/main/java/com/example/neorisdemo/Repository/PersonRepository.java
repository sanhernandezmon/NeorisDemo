package com.example.neorisdemo.Repository;

import com.example.neorisdemo.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Persona, String> {

}
