package com.example.clase2.repository;

import com.example.clase2.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper,Integer> {

    List<Shipper> findByCompanyname(String companyName);

    //con un Query
    @Query(value = "select * from shippers where companyname like %?1", nativeQuery = true)
    List<Shipper> listarTransportistasPorNombre(String companyName);

}
