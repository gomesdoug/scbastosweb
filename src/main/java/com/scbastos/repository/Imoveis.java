package com.scbastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scbastos.model.Imovel;

@Repository
public interface Imoveis extends JpaRepository<Imovel, Long> {

}
