package com.example.urllibrary.controller.service;

import com.example.urllibrary.controller.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    
}
