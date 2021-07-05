package com.example.urllibrary.controller.controller;

import com.example.urllibrary.controller.service.CategoryService;
import com.example.urllibrary.model.pojo.Category;
import com.example.urllibrary.model.pojo.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return this.categoryService.getAllCategories();
    }

    @GetMapping(path = "/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        try {
            return this.categoryService.getCategoryById(id);
        } catch (NoSuchFieldException ex) {
            System.out.println("No category in db");
            return null;
        }
    }

    @PostMapping
    public ResponseEntity addCategory (@RequestBody Category category, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        categoryService.createCategory(category);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public void updateCategory(@RequestBody Category category) {
        this.categoryService.updateCategory(category);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        this.categoryService.deleteCategoryById(id);
    }


}
