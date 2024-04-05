package com.example.blumon.procesamientoPago.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PagoRequestDTO {

    private Long cantidad;
    private String email;

    private String numeroTarjeta;

    private String marca;

    private String banco;
}
