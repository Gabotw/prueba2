package com.genericstrentals.platform.u202018627.inventories.domain.services;

import com.genericstrentals.platform.u202018627.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202018627.inventories.domain.model.queries.GetAllCategoriesQuery;
import com.genericstrentals.platform.u202018627.inventories.domain.model.queries.GetCategoryByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {
    Optional<Category> handle(GetCategoryByIdQuery query);
    List<Category> handle(GetAllCategoriesQuery query);
}
