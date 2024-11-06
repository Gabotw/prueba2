package com.genericstrentals.platform.u202018627.inventories.interfaces.REST;

import com.genericstrentals.platform.u202018627.inventories.domain.model.queries.GetAllCategoriesQuery;
import com.genericstrentals.platform.u202018627.inventories.domain.model.queries.GetCategoryByIdQuery;
import com.genericstrentals.platform.u202018627.inventories.domain.services.CategoryCommandService;
import com.genericstrentals.platform.u202018627.inventories.domain.services.CategoryQueryService;
import com.genericstrentals.platform.u202018627.inventories.interfaces.REST.resources.CategoryResource;
import com.genericstrentals.platform.u202018627.inventories.interfaces.REST.resources.CreateCategoryResource;
import com.genericstrentals.platform.u202018627.inventories.interfaces.REST.transform.CategoryResourceFromEntityAssembler;
import com.genericstrentals.platform.u202018627.inventories.interfaces.REST.transform.CreateCategoryCommandFromAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/categories", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Categories", description = "Categories Management Endpoints")
public class CategoryController {
    private final CategoryCommandService categoryCommandService;
    private final CategoryQueryService categoryQueryService;

    public CategoryController(CategoryCommandService categoryCommandService, CategoryQueryService categoryQueryService) {
        this.categoryCommandService = categoryCommandService;
        this.categoryQueryService = categoryQueryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResource> createCategory(@RequestBody CreateCategoryResource createCategoryResource) {
        var createCategoryCommand = CreateCategoryCommandFromAssembler.toCommandFromResource(createCategoryResource);
        var categoryId = categoryCommandService.handle(createCategoryCommand);
        if(categoryId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getCategoryByIdQuery = new GetCategoryByIdQuery(categoryId);
        var category = categoryQueryService.handle(getCategoryByIdQuery);
        if(category.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var categoryResource = CategoryResourceFromEntityAssembler.toResourceFromEntity(category.get());
        return new ResponseEntity<>(categoryResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CategoryResource>> getAllCategories() {
        var getAllCategoriesQuery = new GetAllCategoriesQuery();
        var category = categoryQueryService.handle(getAllCategoriesQuery);
        var categoryResource = category.stream().map(CategoryResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(categoryResource);
    }
}
