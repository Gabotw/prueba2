package com.genericstrentals.platform.u202018627.inventories.interfaces.REST.transform;

import com.genericstrentals.platform.u202018627.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202018627.inventories.interfaces.REST.resources.CategoryResource;

public class CategoryResourceFromEntityAssembler {
    public static CategoryResource toResourceFromEntity(Category category) {
        return new CategoryResource(category.getId(), category.getName(), category.getGroupid(), category.getDescription(), category.getReferenceImageUrl(), category.getStatus());
    }
}
