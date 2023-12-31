package br.com.repository

import br.com.dto.Pesquisa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
public interface PesquisaRepository : CrudRepository<Pesquisa, Long>