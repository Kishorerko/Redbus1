package com.example.kishorerko.redbus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kishorerko.redbus.dto.RedbusRequest;

@Repository
public interface RedBusRepository extends JpaRepository<RedbusRequest, Long>{

}
