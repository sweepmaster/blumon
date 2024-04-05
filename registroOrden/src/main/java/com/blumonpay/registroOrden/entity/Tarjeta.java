package com.blumonpay.registroOrden.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "tarjeta")
public class Tarjeta {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_tarjeta")
        private Long idTarjeta;

        @Column(name="numero_tarjeta")
        private String NumeroDeTarjeta;

        @Column(name = "marca")
        private String marca;


        @Column(name = "banco")
    private String banco;

        @Column(name = "propietario")
        private String propietario;

    }


