package com.example.blumon.procesamientoPago.controller;

import com.example.blumon.procesamientoPago.dto.PagoRequestDTO;
import com.example.blumon.procesamientoPago.dto.PagoResponseDTO;
import com.example.blumon.procesamientoPago.entity.Pago;
import com.example.blumon.procesamientoPago.service.PagoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ProcesoPagoController {

    @Autowired
    private PagoServiceImp pagoServiceImp;


    @PostMapping("/procesarPago/")
    public PagoResponseDTO pagoProcesamiento(@RequestBody PagoRequestDTO pagoRequestDTO){

        Optional<Pago[]> pagos= pagoServiceImp.getPagos(pagoRequestDTO.getEmail());
        PagoResponseDTO pagoResponseDTO= new PagoResponseDTO();
        Long idTransaccion=0l;

        if (pagos.isPresent()){
           if(pagos.get().length==2){

               pagoResponseDTO=PagoResponseDTO
                       .builder()
                       .approved(false)
                       .message("No se completo el pago debido a que hay dos pagos en  proceso")
                       .statusCode("400")
                       .build();
           }
           else {
               Pago pago= Pago.builder()
                       .email(pagoRequestDTO.getEmail())
                       .status(0l)
                       .cantidad(pagoRequestDTO.getCantidad())
                       .numeroTarjeta(pagoRequestDTO.getNumeroTarjeta())
                       .banco(pagoRequestDTO.getBanco())
                       .marca(pagoRequestDTO.getMarca())
                       .build();
               idTransaccion=pagoServiceImp.savePago(pago).getIdPago();
               pagoResponseDTO=PagoResponseDTO
                       .builder()
                       .approved(true)
                       .message("inicio de proceso de pago satisfactorio")
                       .statusCode("200")
                       .transactionId(idTransaccion)
                       .build();


           }
        }
        return  pagoResponseDTO;
    }

    @GetMapping("/charge/")
    public List<Pago> getPagos(){
        return pagoServiceImp.getPagos();
    }


    @GetMapping("/charge/{id}")
    public Pago getPago(@PathVariable Long id){
        return pagoServiceImp.getPago(id);
    }

    @PostMapping("/pagos/")
    public Pago[] getPagos(@RequestBody PagoRequestDTO pagoRequestDTO){

        Optional<Pago[]> pagos=  pagoServiceImp.getPagosEmail(pagoRequestDTO.getEmail());
        System.out.println(pagos);
        if(pagos.isPresent()){
            return pagos.get();
        }


        return  null;
    }

}
