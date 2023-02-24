package com.example.neorisdemo.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "movimientos")
public class Movimientos {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "movimientoid")
    private String movimientoId;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "tipomovimiento")
    private String tipoMovimiento;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "saldo")
    private Integer saldo;
}
