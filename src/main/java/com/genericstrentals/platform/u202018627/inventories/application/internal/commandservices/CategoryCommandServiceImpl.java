package com.genericstrentals.platform.u202018627.inventories.application.internal.commandservices;

import com.genericstrentals.platform.u202018627.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202018627.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.u202018627.inventories.domain.services.CategoryCommandService;
import com.genericstrentals.platform.u202018627.inventories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryRepository categoryRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Long handle(CreateCategoryCommand command) {
        if(categoryRepository.existsByName(command.name())) {
            throw new IllegalArgumentException("Category with name already exists");
        }
        var category = new Category(command.name(), command.groupid(), command.description(), command.referenceImageUrl(), command.categoryStatus());
        try {
            categoryRepository.save(category);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving category: " + e.getMessage());
        }
        return category.getId();
    }
}