package com.example.urllibrary.controller.controller;

import com.example.urllibrary.controller.service.CategoryService;
import com.example.urllibrary.controller.service.UrlService;
import com.example.urllibrary.model.pojo.Category;
import com.example.urllibrary.model.pojo.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/uploadtestdata")
public class DataForTesting {

    private final UrlService urlService;
    private final CategoryService categoryService;

    @GetMapping
    public void addDataForTesting() {
        Url url1 = Url.builder()
                .link("https://www.youtube.com/watch?v=gJ4Xg5aUBTE")
                .name("Bloodborne Gehrman, The First Hunter Remix - Undone by the Blood")
                .build();

        Url url2 = Url.builder()
                .link("https://www.youtube.com/watch?v=2COYyuNMOkM")
                .name("Bloodborne Hunter's Dream Remix - The Nightmare Ends")
                .build();

        Url url3 = Url.builder()
                .link("https://ochnik.com/buty-meskie-butym-0254-98z20.html")
                .name("Półbuty męskie inspirowane miejskim stylem")
                .build();

        Url url4 = Url.builder()
                .link("https://stackoverflow.com/questions/50107816/react-proxy-error-could-not-proxy-request-api-from-localhost3000-to-http-l")
                .name("React Proxy error: Could not proxy request")
                .build();

        Category category1 = Category.builder()
                .name("music")
                .description("music from youtube")
                .build();

        Category category2 = Category.builder()
                .name("clothing")
                .description("url's to clothing shops")
                .build();

        Category category3 = Category.builder()
                .name("stackoverflow")
                .description("category for itself")
                .build();

        urlService.createUrl(url1);
        urlService.createUrl(url2);
        urlService.createUrl(url3);
        urlService.createUrl(url4);

        categoryService.createCategory(category1);
        categoryService.createCategory(category2);
        categoryService.createCategory(category3);
    }
}
