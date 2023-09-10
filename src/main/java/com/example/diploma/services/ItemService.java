package com.example.diploma.services;

import com.example.diploma.models.Item;
import com.example.diploma.models.Picture;
import com.example.diploma.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> listItems(String title) {
        if (title!=null) return itemRepository.findByTitle(title);
        return itemRepository.findAll();
    }

    public void SafeItem(Item item, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Picture picture1;
        Picture picture2;
        Picture picture3;
        if(file1.getSize() != 0){
            picture1 = toPictureEntity(file1);
        }

        log.info("Saving new item {}", item);
        itemRepository.save(item);
    }

    private Picture toPictureEntity(MultipartFile file) throws IOException {
        Picture picture = new Picture();
        picture.setName(file.getName());
        //picture.setOriginalFileName(file.getOriginalFilename());
        picture.setContentType(file.getContentType());
        picture.setSize(file.getSize());
        picture.setBytes(file.getBytes());
        return picture;
    }

    public void DeleteItem(Long id) {
        itemRepository.deleteById(id);
    }


    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
