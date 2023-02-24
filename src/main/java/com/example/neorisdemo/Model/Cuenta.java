package com.example.neorisdemo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numerocuenta", columnDefinition = "serial")
    private Long numeroCuenta;
    @Column(name = "tipocuenta")
    private String tipocuenta;
    @Column(name = "saldoinicial")
    private Long saldoInicial;
    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personaid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Movimiento> movimientos;

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta=" + numeroCuenta +
                ", tipocuenta='" + tipocuenta + '\'' +
                ", saldoInicial=" + saldoInicial +
                ", estado=" + estado +
                ", cliente=" + cliente +
                ", movimientos=" + movimientos +
                '}';
    }
}
