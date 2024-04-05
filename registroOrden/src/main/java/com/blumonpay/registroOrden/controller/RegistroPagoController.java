package com.blumonpay.registroOrden.controller;

import com.blumonpay.registroOrden.dto.RegistroPagoDTO;
import com.blumonpay.registroOrden.dto.RequestPagoProcesoDTO;
import com.blumonpay.registroOrden.dto.ResponsePagoProcesoDTO;
import com.blumonpay.registroOrden.dto.ResponsePagoProcesoOut;
import com.blumonpay.registroOrden.entity.Tarjeta;
import com.blumonpay.registroOrden.feign.IProcesamientoPagoFeign;
import com.blumonpay.registroOrden.service.TarjetaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class RegistroPagoController {
    @Autowired
    private TarjetaServiceImp tarjetaServiceImp;
    @Autowired
    private IProcesamientoPagoFeign procesamientoPagoFeign;


    @PostMapping("/charge/")
    public ResponsePagoProcesoDTO savePago(@RequestBody RegistroPagoDTO registroPagoDTO) {
        System.out.println(registroPagoDTO);
        Optional<Tarjeta> tarjeta=tarjetaServiceImp.encontrarTarjeta(registroPagoDTO.getCardNumber());
        if (tarjeta.isEmpty()){
           Tarjeta tarjeta1= Tarjeta
                   .builder()
                   .NumeroDeTarjeta(registroPagoDTO.getCardNumber())//se setea el numero de tarjeta si no existe
                   .propietario(registroPagoDTO.getCardholderName())//se setea al dueño
                   .marca("") //TODO aqui iria una logica, que hasta donde se se basa en el principio de la tarjeta
                   .banco("")//todo de igual manera supongo que hay una logica para saber de que banco es
                   .build();
            tarjetaServiceImp.saveTarjeta(tarjeta1);
        }
        RequestPagoProcesoDTO requestPagoProcesoDTO= RequestPagoProcesoDTO.builder()
                .banco("") //aqui iria una logica de que banco es
                .marca("") //aqui iria la logica para saber de que marca
                .numeroTarjeta(registroPagoDTO.getCardNumber())
                .email(registroPagoDTO.getEmail())
                .cantidad(registroPagoDTO.getAmount())
                .build();

        ResponsePagoProcesoDTO registroPagoOutDTO=procesamientoPagoFeign.sendRegistro(requestPagoProcesoDTO);



        return registroPagoOutDTO;
    }

    @GetMapping("/charge/")
    public List<ResponsePagoProcesoOut> getTransacciones(){

        List<ResponsePagoProcesoOut> responsePagoProcesoOut= (List<ResponsePagoProcesoOut>) procesamientoPagoFeign.getpagos();
        return  responsePagoProcesoOut;
    }

    @GetMapping("/charge/{transactionId}")
    public ResponsePagoProcesoOut getTransaccionById(@PathVariable Long transactionId){
        ResponsePagoProcesoOut responsePagoProcesoOut=  procesamientoPagoFeign.getPago(transactionId);


        return responsePagoProcesoOut;


    }

    @PostMapping("/pagos/")
    public ResponsePagoProcesoOut [] getTransaccionById(@RequestBody RegistroPagoDTO registroPagoDTO){

        RequestPagoProcesoDTO requestPagoProcesoDTO= RequestPagoProcesoDTO.builder().email(registroPagoDTO.getEmail()).build();

        ResponsePagoProcesoOut[] pagos= procesamientoPagoFeign.getPagosEmail(requestPagoProcesoDTO);



        return pagos;


    }


}
