package com.blumonpay.registroOrden.feign;


import com.blumonpay.registroOrden.dto.RegistroPagoDTO;
import com.blumonpay.registroOrden.dto.RequestPagoProcesoDTO;
import com.blumonpay.registroOrden.dto.ResponsePagoProcesoDTO;
import com.blumonpay.registroOrden.dto.ResponsePagoProcesoOut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "IProcesamientoPagoFeign", url = "${external.proceso.pago.url}")

public interface IProcesamientoPagoFeign {

    @PostMapping(value = "/procesarPago/", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponsePagoProcesoDTO sendRegistro(@RequestBody RequestPagoProcesoDTO requestPagoProcesoDTO);

    @GetMapping(value = "/charge/", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<ResponsePagoProcesoOut> getpagos();

    @GetMapping(value = "/charge/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
     ResponsePagoProcesoOut getPago(@PathVariable Long id);


    @PostMapping(value = "/pagos/", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponsePagoProcesoOut [] getPagosEmail(@RequestBody RequestPagoProcesoDTO requestPagoProcesoDTO);
}
