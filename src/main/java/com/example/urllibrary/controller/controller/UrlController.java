package com.example.urllibrary.controller.controller;

import com.example.urllibrary.controller.service.UrlService;
import com.example.urllibrary.model.pojo.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

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

    @PutMapping
    public void updateUrl(@Valid @RequestBody Url url, BindingResult bindingResult) {

        urlService.updateUrl(url);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUrl(@RequestParam Long id) {
        urlService.deleteUrlById(id);
    }

}
