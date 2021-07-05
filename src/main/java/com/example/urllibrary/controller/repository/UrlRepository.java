package com.example.urllibrary.controller.repository;

import com.example.urllibrary.model.entity.UrlEntity;
import com.example.urllibrary.model.pojo.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    Set<UrlEntity> findAllByCategory_NameEquals(String category);

    Set<UrlEntity> findAllByLinkContains(String prefix);
}
