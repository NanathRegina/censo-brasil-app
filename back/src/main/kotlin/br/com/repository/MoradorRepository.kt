package br.com.repository

import br.com.dto.Morador
import br.com.dto.Pesquisa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
public interface MoradorRepository : CrudRepository<Morador, Long>