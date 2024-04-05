package com.example.blumon.procesamientoPago.service;

import com.example.blumon.procesamientoPago.entity.Pago;

import java.util.List;
import java.util.Optional;

public interface IPagoService {

    Optional<Pago[]> getPagos(String email);

    Pago savePago(Pago pago);

    void aceptarPagos();

    List<Pago> getPagos();

    Pago getPago(Long id);
    Optional<Pago[]> getPagosEmail(String email);



}
