package com.blumonpay.registroOrden.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponsePagoProcesoOut {
private Long idPago;
private Long status;
    private Long cantidad;
    private String email;

    private String numeroTarjeta;

    private String marca;

    private String banco;
}
