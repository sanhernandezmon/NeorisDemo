package com.example.neorisdemo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "movimientoid")
    private String movimientoId;
    @Column(name = "fecha" , nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp fecha;
    @Column(name = "tipomovimiento")
    private String tipoMovimiento;
    @Column(name = "valor")
    private Long valor;
    @Column(name = "saldo")
    private Long saldo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numerocuenta", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Cuenta cuenta;

}
