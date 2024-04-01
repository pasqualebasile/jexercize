package com.example.loyaltym.repository;

import com.example.loyaltym.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface ProdottoRepository extends JpaRepository<Prodotto,Long>,
        PagingAndSortingRepository<Prodotto, Long>,
        QueryByExampleExecutor<Prodotto>,
        JpaSpecificationExecutor<Prodotto> {

    Optional<Prodotto> findProdottoById(Long id);

    Optional<Prodotto> findProdottoByCodice(String codice);

    @Query(value = "SELECT *  FROM prodotto ORDER BY random() LIMIT 1", nativeQuery = true)
    public List<Prodotto> getProdottoCasuale();
}
