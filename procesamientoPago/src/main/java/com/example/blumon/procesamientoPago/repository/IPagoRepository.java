package com.example.blumon.procesamientoPago.repository;

import com.example.blumon.procesamientoPago.entity.Pago;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IPagoRepository extends CrudRepository<Pago,Long> {

    @Query(value = "select * from pago where status= 0 and email= :email", nativeQuery = true)
    Optional<Pago[]> getPagos(String email);
    @Modifying
    @Query(value = "update pago set status=1 where status=0",nativeQuery = true)
    void aceptarPagos();

    @Query(value = "select * from pago where email= :email", nativeQuery = true)
    Optional<Pago[]> getPagosEmail(String email);
}
