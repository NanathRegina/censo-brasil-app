package repository

import dto.Pesquisa
import org.springframework.data.repository.CrudRepository

interface PesquisaRepository : CrudRepository<Pesquisa, Long>