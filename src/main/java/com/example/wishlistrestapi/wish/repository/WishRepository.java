package com.example.wishlistrestapi.wish.repository;

import com.example.wishlistrestapi.wish.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WishRepository extends JpaRepository<Wish, UUID> {
}
