package com.blumonpay.registroOrden.service;

import com.blumonpay.registroOrden.entity.Tarjeta;

import java.util.Optional;

public interface ITarjetaService {

    Optional<Tarjeta> encontrarTarjeta(String numero);

    void saveTarjeta(Tarjeta tarjeta);
}
