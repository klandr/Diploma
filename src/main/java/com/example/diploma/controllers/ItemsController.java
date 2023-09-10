package com.example.diploma.controllers;


import com.example.diploma.models.Item;
import com.example.diploma.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ItemsController {

    private final ItemService itemService;

    @GetMapping("/")
    public String items(@RequestParam(name = "title", required = false)String title, Model model) {
        model.addAttribute("items", itemService.listItems(title));
        return "items";
    }

    @GetMapping("/item/{id}")
    public String itemInfo(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "item-info";
    }

    @PostMapping("/item/create")
    public String createItem(Item item) {
       // itemService.SafeItem(item);
        return "redirect:/";
    }

    @PostMapping("/item/dell/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.DeleteItem(id);
        return "redirect:/";
    }
}
