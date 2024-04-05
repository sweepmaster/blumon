package com.blumonpay.registroOrden.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePagoProcesoDTO {


    private String statusCode;
    private String message;
    private Long transactionId;
    private Boolean approved;
    private List<String> errors;
}
