package com.blumonpay.registroOrden.repository;

import com.blumonpay.registroOrden.entity.Tarjeta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITarjetaRepository extends CrudRepository<Tarjeta,Long> {

    @Query(value ="select * from tarjeta where numero_tarjeta= :numero ",nativeQuery = true)
    Optional<Tarjeta> findNumeroTarjeta(String numero);
}
