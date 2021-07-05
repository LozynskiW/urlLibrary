package com.example.urllibrary.controller.service;

import com.example.urllibrary.controller.repository.UrlRepository;
import com.example.urllibrary.model.entity.UrlEntity;
import com.example.urllibrary.model.pojo.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public List<Url> getAllUrls() {
        List<UrlEntity> urlEntityList = this.urlRepository.findAll();

        return mapEntityToModel(urlEntityList);
    }

    public Url getUrlById(Long id) throws NoSuchFieldException {

        Optional<UrlEntity> urlEntity = this.urlRepository.findById(id);

        if (urlEntity.isPresent()) {
            UrlEntity ue = urlEntity.get();
            return mapEntityToModel(List.of(ue)).get(0);
        }
        throw new NoSuchFieldException("No such url in data basse");

    }

    public Set<Url> getUrlByCategory(String categoryName) {
        Set<UrlEntity> urlEntityList = this.urlRepository.findAllByCategory_NameEquals(categoryName);
        return mapEntityToModel(urlEntityList);
    }

    public Set<Url> getUrlByPrefix(String prefix) {
        Set<UrlEntity> urlEntityList = this.urlRepository.findAllByLinkContains(prefix);
        return mapEntityToModel(urlEntityList);
    }

    public void updateUrl(Url url) {

        if (urlRepository.existsById(url.getId())){

            UrlEntity urlEntity = UrlEntity.builder()
                    .id(url.getId())
                    .name(url.getName())
                    .description(url.getDescription())
                    .additionalInfo(url.getAdditionalInfo())
                    .link(url.getLink())
                    .expiryDate(url.getExpiryDate())
                    .build();
            urlRepository.deleteById(url.getId());
            urlRepository.save(urlEntity);
        }
        throw new NoSuchElementException("No such url was found in db");
    }

    public void deleteUrlById(Long id) {

        if (urlRepository.existsById(id)) {
            urlRepository.deleteById(id);
        }
        throw new NoSuchElementException("No such url was found in db");
    }

    public void createUrl(Url url) {

        UrlEntity urlEntity = UrlEntity.builder()
                .id(url.getId())
                .name(url.getName())
                .description(url.getDescription())
                .additionalInfo(url.getAdditionalInfo())
                .link(url.getLink())
                .expiryDate(url.getExpiryDate())
                .build();

        urlRepository.save(urlEntity);
    }

    private List<Url> mapEntityToModel(List<UrlEntity> urlEntityList) {

        return urlEntityList.stream().map(ue ->
                Url.builder()
                        .id(ue.getId())
                        .name(ue.getName())
                        .description(ue.getDescription())
                        .link(ue.getLink())
                        .additionalInfo(ue.getAdditionalInfo())
                        .expiryDate(ue.getExpiryDate())
                        .build())
                .collect(Collectors.toList());

    }

    private Set<Url> mapEntityToModel(Set<UrlEntity> urlEntitySet) {

        return urlEntitySet.stream().map(ue ->
                Url.builder()
                        .id(ue.getId())
                        .name(ue.getName())
                        .description(ue.getDescription())
                        .link(ue.getLink())
                        .additionalInfo(ue.getAdditionalInfo())
                        .expiryDate(ue.getExpiryDate())
                        .build())
                .collect(Collectors.toSet());
    }

}
