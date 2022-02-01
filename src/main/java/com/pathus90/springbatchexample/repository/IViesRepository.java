package com.pathus90.springbatchexample.repository;

import com.pathus90.springbatchexample.model.Vies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViesRepository extends JpaRepository<Vies, Long> {
}
