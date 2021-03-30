package com.example.jsondemo.service.impl;

import com.example.jsondemo.entity.Item;
import com.example.jsondemo.repository.ItemRepository;
import com.example.jsondemo.service.ItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.jvm.Items;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.io.*;
import java.util.List;
import java.util.concurrent.Future;

import static reactor.core.publisher.Flux.just;

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
                Thread.sleep(2000);
                subscriber.onNext(itemRepository.saveAll(items));
                subscriber.onCompleted();
            } catch (Exception ex ) {
                ex.printStackTrace();
            }
        }).subscribeOn(Schedulers.computation());
    }
}
