package com.genericstrentals.platform.u202018627.inventories.interfaces.REST.transform;

import com.genericstrentals.platform.u202018627.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects.Group;
import com.genericstrentals.platform.u202018627.inventories.interfaces.REST.resources.CreateCategoryResource;

public class CreateCategoryCommandFromAssembler {
    public static CreateCategoryCommand toCommandFromResource(CreateCategoryResource resource) {
        Group group = Group.values()[resource.groupId().intValue() - 1];
        return new CreateCategoryCommand(resource.name(), group, resource.description(), resource.image(), resource.categoryStatus());
    }
}
