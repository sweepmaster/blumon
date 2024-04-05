package com.blumonpay.registroOrden.service;

import com.blumonpay.registroOrden.entity.Tarjeta;
import com.blumonpay.registroOrden.repository.ITarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TarjetaServiceImp implements ITarjetaService{
    @Autowired
    private ITarjetaRepository tarjetaRepository;

    @Override
    public Optional<Tarjeta> encontrarTarjeta(String numero) {
        return tarjetaRepository.findNumeroTarjeta(numero);
    }

    @Override
    public void saveTarjeta(Tarjeta tarjeta) {
        tarjetaRepository.save(tarjeta);
    }

}
