package com.boot.DasBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.DasBoot.model.Shipwreck;

@Repository(value = "shipRepo")
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
