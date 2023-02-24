package com.example.neorisdemo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numerocuenta")
    private Long numeroCuenta;
    @Column(name = "tipocuenta")
    private String tipocuenta;
    @Column(name = "saldoinicial")
    private Integer saldoInicial;
    @Column(name = "estado")
    private String estado;


}
