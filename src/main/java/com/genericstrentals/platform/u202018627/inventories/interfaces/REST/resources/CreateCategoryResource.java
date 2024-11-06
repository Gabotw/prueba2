package com.genericstrentals.platform.u202018627.inventories.interfaces.REST.resources;

import com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects.CategoryStatus;

public record CreateCategoryResource(String name, Long groupId, String description, String image, CategoryStatus categoryStatus) {
}
