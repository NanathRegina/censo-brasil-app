package br.com.repository

import br.com.dto.Unidade
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
public interface UnidadeRepository :CrudRepository<Unidade, Long>