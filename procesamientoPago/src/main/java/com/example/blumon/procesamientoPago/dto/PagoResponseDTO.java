package com.example.blumon.procesamientoPago.dto;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PagoResponseDTO {

    private String statusCode;
    private String message;
    private Long transactionId;
    private Boolean approved;
    private List<String> errors;
}
