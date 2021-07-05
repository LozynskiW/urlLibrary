package com.example.urllibrary.controller.service;

import com.example.urllibrary.controller.repository.CategoryRepository;
import com.example.urllibrary.controller.repository.UrlRepository;
import com.example.urllibrary.model.entity.CategoryEntity;
import com.example.urllibrary.model.entity.UrlEntity;
import com.example.urllibrary.model.pojo.Category;
import com.example.urllibrary.model.pojo.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntityList = this.categoryRepository.findAll();

        return mapEntityToModel(categoryEntityList);
    }

    public Category getCategoryById(Long id) throws NoSuchFieldException {

        Optional<CategoryEntity> categoryEntity = this.categoryRepository.findById(id);

        if (categoryEntity.isPresent()) {
            CategoryEntity ce = categoryEntity.get();
            return mapEntityToModel(List.of(ce)).get(0);
        }
        throw new NoSuchFieldException("No such url in data basse");

    }

    public void updateCategory(Category category) {

        if (categoryRepository.existsById(category.getId())){

            CategoryEntity categoryEntity = CategoryEntity.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .description(category.getDescription())
                    .photoUrl(category.getPhotoUrl())
                    .build();

            categoryRepository.deleteById(category.getId());
            categoryRepository.save(categoryEntity);
        }
        throw new NoSuchElementException("No such url was found in db");
    }

    public void deleteCategoryById(Long id) {

        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
        throw new NoSuchElementException("No such url was found in db");
    }

    public void createCategory(Category category) {

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .photoUrl(category.getPhotoUrl())
                .build();

        categoryRepository.save(categoryEntity);
    }

    private List<Category> mapEntityToModel(List<CategoryEntity> categoryEntityList) {

        return categoryEntityList.stream().map(ce ->
                Category.builder()
                        .id(ce.getId())
                        .name(ce.getName())
                        .description(ce.getDescription())
                        .photoUrl(ce.getPhotoUrl())
                        .build())
                .collect(Collectors.toList());

    }

    private Set<Category> mapEntityToModel(Set<CategoryEntity> categoryEntitySet) {

        return categoryEntitySet.stream().map(ce ->
                Category.builder()
                        .id(ce.getId())
                        .name(ce.getName())
                        .description(ce.getDescription())
                        .photoUrl(ce.getPhotoUrl())
                        .build())
                .collect(Collectors.toSet());
    }
}
