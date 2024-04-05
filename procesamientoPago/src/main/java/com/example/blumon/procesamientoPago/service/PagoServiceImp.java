package com.example.blumon.procesamientoPago.service;

import com.example.blumon.procesamientoPago.entity.Pago;
import com.example.blumon.procesamientoPago.repository.IPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class PagoServiceImp implements IPagoService {

    @Autowired
    private IPagoRepository pagoRepository;
    @Override
    public Optional<Pago[]> getPagos(String email) {
        return pagoRepository.getPagos(email);
    }

    @Override
    public Pago savePago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    @Transactional
    public void aceptarPagos() {
        pagoRepository.aceptarPagos();
    }

    @Override
    public List<Pago> getPagos() {
        return (List<Pago>) pagoRepository.findAll();
    }

    @Override
    public Pago getPago(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Pago[]> getPagosEmail(String email) {
        return pagoRepository.getPagosEmail(email);
    }


}
