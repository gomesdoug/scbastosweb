package com.scbastos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scbastos.model.Imovel;

@Repository
public interface ImoveisRepository extends JpaRepository<Imovel, Long> {
	
	public Optional<Imovel> findByCodigosc(Long codigosc);

}
