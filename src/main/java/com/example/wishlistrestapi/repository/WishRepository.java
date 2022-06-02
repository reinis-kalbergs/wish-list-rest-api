package com.example.wishlistrestapi.repository;

import com.example.wishlistrestapi.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WishRepository extends JpaRepository<Wish, UUID> {
}
