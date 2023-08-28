package com.repository

import com.dto.Pesquisa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

@Repository
@NoRepositoryBean
public interface PesquisaRepository : JpaRepository<Pesquisa, Long>