package com.genericstrentals.platform.u202018627.inventories.infrastructure.persistence.jpa.repositories;

import com.genericstrentals.platform.u202018627.inventories.domain.model.aggregates.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);
    boolean existsByName(String name);
}
