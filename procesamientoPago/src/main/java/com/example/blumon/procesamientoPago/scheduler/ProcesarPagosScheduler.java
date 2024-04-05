package com.example.blumon.procesamientoPago.scheduler;

import com.example.blumon.procesamientoPago.service.PagoServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProcesarPagosScheduler {
    @Autowired
    private PagoServiceImp pagoServiceImp;

    @Scheduled(cron = "${cron.expression}", zone = "America/Mexico_City")
    public void aceptarPagos() {
        try{
            pagoServiceImp.aceptarPagos();
            log.info("se han aceptado los pagos");

        }catch (Exception e){
            log.info(e.toString());

        }
    }
}
