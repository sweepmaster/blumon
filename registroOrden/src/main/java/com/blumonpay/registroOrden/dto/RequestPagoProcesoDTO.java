package com.blumonpay.registroOrden.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestPagoProcesoDTO {
    private Long cantidad;
    private String email;

    private String numeroTarjeta;

    private String marca;

    private String banco;

}
