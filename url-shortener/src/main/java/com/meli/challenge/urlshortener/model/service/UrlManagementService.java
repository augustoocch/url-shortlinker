package com.meli.challenge.urlshortener.model.service;

import com.meli.challenge.urlshortener.model.entity.UrlData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UrlManagementService {
    Mono<UrlData> createUrlData(String originalUrl);
    Mono<UrlData> getUrlData(String shortUrl);
    Flux<UrlData> getAllUrls();
    Mono<UrlData> updateUrl(String id, String newUrl);
    Mono<Void> toggleUrl(String id);
}
