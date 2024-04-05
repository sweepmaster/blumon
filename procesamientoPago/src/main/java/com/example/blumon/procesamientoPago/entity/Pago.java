package com.example.blumon.procesamientoPago.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long idPago;

    @Column(name="cantidad")
    private Long cantidad;
    @Column(name = "status")
    private Long status;
    @Column(name = "email")
    private String email;

    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;


    @Column(name = "banco")
    private String banco;

    @Column(name = "marca")
    private String marca;

}
