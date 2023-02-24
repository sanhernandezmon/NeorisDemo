package com.example.neorisdemo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cliente extends Persona{
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "estado")
    private Boolean estado;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cuenta> cuentas;

}
