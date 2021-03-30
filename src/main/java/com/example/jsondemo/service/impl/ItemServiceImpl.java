package com.example.jsondemo.service.impl;

import com.example.jsondemo.entity.Item;
import com.example.jsondemo.repository.ItemRepository;
import com.example.jsondemo.service.ItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.io.*;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Observable<Object> addItemToDatabase(MultipartFile file) {
        return Observable.create(subscriber -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                InputStream in = file.getInputStream();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                List<Item> items = objectMapper.readValue( in, new TypeReference<List<Item>>(){});
                Thread.sleep(10000);
                subscriber.onNext("Now Inserting Data");
                //System.out.println(Thread.currentThread().getName());
                itemRepository.saveAll(items);
            } catch (Exception ex ) {
                ex.printStackTrace();
            }
        });
    }
}
