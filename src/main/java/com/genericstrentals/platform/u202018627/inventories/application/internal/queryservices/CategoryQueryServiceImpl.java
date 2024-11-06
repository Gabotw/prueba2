package com.genericstrentals.platform.u202018627.inventories.application.internal.queryservices;

import com.genericstrentals.platform.u202018627.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202018627.inventories.domain.model.queries.GetAllCategoriesQuery;
import com.genericstrentals.platform.u202018627.inventories.domain.model.queries.GetCategoryByIdQuery;
import com.genericstrentals.platform.u202018627.inventories.domain.services.CategoryQueryService;
import com.genericstrentals.platform.u202018627.inventories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryQueryServiceImpl implements CategoryQueryService {
    private final CategoryRepository categoryRepository;

    public CategoryQueryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> handle(GetCategoryByIdQuery query) {
        return categoryRepository.findById(query.id());
    }

    @Override
    public List<Category> handle(GetAllCategoriesQuery query) {
        return categoryRepository.findAll();
    }
}
