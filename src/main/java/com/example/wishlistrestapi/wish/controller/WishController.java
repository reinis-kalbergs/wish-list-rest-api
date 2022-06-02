package com.example.wishlistrestapi.wish.controller;

import com.example.wishlistrestapi.wish.model.AddWishRequest;
import com.example.wishlistrestapi.wish.model.Wish;
import com.example.wishlistrestapi.wish.service.WishService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/wish-list")
public class WishController {

    private final WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Wish addWishWithoutId(@Valid @RequestBody AddWishRequest addWishRequest) {
        return wishService.addWish(addWishRequest);
    }

    @PutMapping("/update")
    public Wish updateWish(@Valid @RequestBody Wish wish) {
        return wishService.updateWish(wish);
    }

    @DeleteMapping("/delete/{uuid}")
    public void deleteWish(@PathVariable("uuid") UUID uuid) {
        wishService.deleteWish(uuid);
    }

    @GetMapping("/get/{uuid}")
    public Wish getWish(@PathVariable("uuid") UUID uuid) {
        return wishService.getWish(uuid);
    }

    @GetMapping("/get/all")
    public List<Wish> getWishList() {
        return wishService.getWishList();
    }
}
