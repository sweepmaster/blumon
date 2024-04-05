package com.blumonpay.registroOrden.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistroPagoDTO {

  private Long  amount;
  private String email;
  private String  cardNumber;
  private String cvv;
  private String cardholderName;
  private String  expirationYear;
  private String  expirationMonth;
}
