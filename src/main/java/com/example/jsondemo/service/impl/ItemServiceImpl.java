package com.example.jsondemo.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.example.jsondemo.entity.Item;
import com.example.jsondemo.repository.ItemRepository;
import com.example.jsondemo.service.ItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Async
    @Override
    public void addItemToDatabase(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> mockObject = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();
        try (InputStream in = file.getInputStream()) {
            //mockObject = objectMapper.readValue(in, ArrayList.class);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            List<Item> items = objectMapper.readValue(in, new TypeReference<List<Item>>(){});
            itemRepository.saveAll(items);
        } catch (Exception ex ) {
            ex.printStackTrace();
        }


//        for(Map<String,Object> itemObject : mockObject) {
//            Item item = new Item();
//            item.setDemand(Long.parseLong(String.valueOf(itemObject.get("demand"))));
//          item.setDoi(Double.parseDouble(String.valueOf(itemObject.get("doi"))));
//            item.setInventory(Long.parseLong(String.valueOf(itemObject.get("inventory"))));
//            item.setItemCode((String)itemObject.get("itemCode"));
//            item.setQtyToReachDoi(Long.parseLong(String.valueOf(itemObject.get("qtyToReachDoi"))));
//            item.setAreaCode((String) itemObject.get("areaCode"));
//            itemRepository.save(item);
//        }

//        for(Map<String,Object> itemObject: mockObject) {
//            Gson gson = new Gson();
//            Item item = gson.fromJson(itemObject.toString(),Item.class);
//            itemList.add(item);
//        }
//        itemRepository.saveAll(itemList);
        System.out.println("Success");
    }
}
