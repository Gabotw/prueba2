package com.genericstrentals.platform.u202018627.inventories.domain.model.commands;

import com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects.CategoryStatus;
import com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects.Group;

public record CreateCategoryCommand(String name, Group groupid, String description, String referenceImageUrl, CategoryStatus categoryStatus) {
}
