package com.example.urllibrary.controller.controller;

import com.example.urllibrary.controller.service.CategoryService;
import com.example.urllibrary.controller.service.UrlService;
import com.example.urllibrary.model.pojo.Category;
import com.example.urllibrary.model.pojo.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;
    private final CategoryService categoryService;

    @GetMapping
    public List<Url> getAll() {
        return urlService.getAllUrls();
    }

    @GetMapping(path = "/category/{category}")
    public Set<Url> getAllOfCategory(@PathVariable String category) {
        return urlService.getUrlByCategory(category);
    }

    @GetMapping(path = "/prefix/{prefix}")
    public Set<Url> getAllOfPrefix(@PathVariable String prefix) {

        return urlService.getUrlByPrefix(prefix);
    }

    @PostMapping
    public ResponseEntity addUrl (@Valid @RequestBody Url url, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        urlService.createUrl(url);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/addCategory/{categoryName}")
    public void bindUrlToCategory (@PathVariable Long id, @PathVariable String categoryName) {

        Url url;
        Category category;
        Optional<Category> maybeCategory;
        try {
            url = urlService.getUrlById(id);
            maybeCategory = categoryService.getAllCategories().stream().filter(c -> c.getName().equals(categoryName))
                    .findFirst();
            if (maybeCategory.isPresent()) {
                category = maybeCategory.get();
                urlService.bindUrlToCategoryByCategoryName(url, category);
            }

        } catch (NoSuchFieldException ex) {
            System.out.println(("No url or category"));
        }
    }

    @PutMapping("/{id}")
    public void updateUrl(@PathVariable Long id, @Valid @RequestBody Url url) {

        urlService.updateUrl(id, url);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUrl(@PathVariable Long id) {
        urlService.deleteUrlById(id);
    }

}
