package com.example.jsondemo.service;

import org.springframework.web.multipart.MultipartFile;
import rx.Observable;

import java.io.IOException;

public interface ItemService {
    Observable<Object> addItemToDatabase(MultipartFile file) throws IOException;
}
