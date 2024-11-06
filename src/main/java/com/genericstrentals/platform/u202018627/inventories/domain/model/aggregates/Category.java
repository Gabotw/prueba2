package com.genericstrentals.platform.u202018627.inventories.domain.model.aggregates;

import com.genericstrentals.platform.u202018627.inventories.domain.model.commands.CreateCategoryCommand;
import com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects.CategoryStatus;
import com.genericstrentals.platform.u202018627.inventories.domain.model.valueobjects.Group;
import com.genericstrentals.platform.u202018627.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
public class Category extends AuditableAbstractAggregateRoot<Category> {
    private String name;
    @Enumerated(EnumType.STRING)
    private Group groupid;
    private String description;
    private String referenceImageUrl;
    private CategoryStatus status;

    public Category() {
        this.name = Strings.EMPTY;
        this.groupid = Group.FORESTRY;
        this.description = Strings.EMPTY;
        this.referenceImageUrl = Strings.EMPTY;
        this.status = CategoryStatus.ACTIVE;
    }

    public Category(String name, Group groupid, String description, String referenceImageUrl, CategoryStatus status) {
        this();
        this.name = name;
        this.groupid = groupid;
        this.description = description;
        this.referenceImageUrl = referenceImageUrl;
        this.status = status;
    }

    public Category(CreateCategoryCommand command) {
        this();
        this.name = command.name();
        this.groupid = command.groupid();
        this.description = command.description();
        this.referenceImageUrl = command.referenceImageUrl();
        this.status = command.categoryStatus();
    }
}