package com.example.urllibrary.controller.repository;

import com.example.urllibrary.model.entity.UrlEntity;
import com.example.urllibrary.model.pojo.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    List<Url> findByCategory(String category);

    List<Url> findByPrefix(String prefix);
}
