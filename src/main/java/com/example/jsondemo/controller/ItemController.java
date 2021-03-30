package com.example.jsondemo.controller;


import com.example.jsondemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/add",consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public String addItemToDatabase(@RequestParam("file") MultipartFile file) throws IOException {
         itemService.addItemToDatabase(file).subscribe(
                 line -> System.out.println(line)
         );
         return "Please Wait";
    }
}
