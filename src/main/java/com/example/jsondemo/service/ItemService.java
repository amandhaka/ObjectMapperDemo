package com.example.jsondemo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface ItemService {
    void addItemToDatabase(MultipartFile file) throws IOException;
}
