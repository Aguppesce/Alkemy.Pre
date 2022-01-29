package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.entity.Charcter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CharcterRepository extends JpaRepository<Charcter, Long> {
    List<Charcter> findAll(Specification<Charcter> spec);
}
