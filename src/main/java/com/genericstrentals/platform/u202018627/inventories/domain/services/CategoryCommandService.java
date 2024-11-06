package com.genericstrentals.platform.u202018627.inventories.domain.services;

import com.genericstrentals.platform.u202018627.inventories.domain.model.commands.CreateCategoryCommand;

public interface CategoryCommandService {
    Long handle(CreateCategoryCommand command);
}
