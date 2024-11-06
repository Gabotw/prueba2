package com.genericstrentals.platform.u202018627.inventories.interfaces.REST.resources;

import com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects.CategoryStatus;
import com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects.Group;

public record CategoryResource(Long id, String name, Group groupId, String description, String image, CategoryStatus categoryStatus) {
}
