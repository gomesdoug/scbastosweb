package com.scbastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scbastos.model.Proprietario;


@Repository
public interface ProprietariosRepository extends JpaRepository<Proprietario, Long>{
	
	

}//END INTERFACE
