package com.example.loyaltym.repository;

import com.example.loyaltym.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovimentoRepository extends JpaRepository<Movimento,Long>, PagingAndSortingRepository<Movimento, Long> {

}
