package com.example.wishlistrestapi.service;

import com.example.wishlistrestapi.model.AddWishRequest;
import com.example.wishlistrestapi.model.Wish;
import com.example.wishlistrestapi.repository.WishRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class WishService {

    private final WishRepository wishRepository;

    public WishService(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    public Wish addWish(AddWishRequest addWishRequest) {
        return wishRepository.save(new Wish(addWishRequest));
    }

    public Wish updateWish(Wish wish) {
        if (!wishRepository.existsById(wish.getUuid())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return wishRepository.save(wish);
    }

    public void deleteWish(UUID uuid) {
        if (!wishRepository.existsById(uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        wishRepository.deleteById(uuid);
    }

    public Wish getWish(UUID uuid) {
        Optional<Wish> wishOptional = wishRepository.findById(uuid);
        if (wishOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return wishOptional.get();
    }

    public List<Wish> getWishList() {
        return wishRepository.findAll();
    }
}
