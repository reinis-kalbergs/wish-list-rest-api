package com.example.wishlistrestapi.wish.service;

import com.example.wishlistrestapi.wish.model.AddWishRequest;
import com.example.wishlistrestapi.wish.model.Wish;
import com.example.wishlistrestapi.wish.repository.WishRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class WishServiceTest {

    @Mock
    WishRepository wishRepository;

    @InjectMocks
    WishService wishService;

    private final Wish TEST_WISH = new Wish(
            UUID.fromString("78316a31-e245-4d45-a96f-9709dae689d5"), "Ferrari"
    );

    @Test
    public void shouldReturnWishWithUuid() {
        AddWishRequest addWishRequest = new AddWishRequest("something");
        UUID uuid = UUID.fromString("8dad6d63-084f-4e07-8b39-5eb07039ab6e");
        Wish expectedWish = new Wish(uuid, "something");

        Mockito.when(wishRepository.save(Mockito.any(Wish.class)))
                .thenReturn(new Wish(uuid, addWishRequest.getItem()));

        Wish resultWish = wishService.addWish(addWishRequest);

        Assertions.assertEquals(expectedWish, resultWish);
    }

    @Test
    public void shouldThrowWhenUpdatingNonExistingWish() {

        Mockito.when(wishRepository.existsById(Mockito.any(UUID.class)))
                .thenReturn(false);

        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> wishService.updateWish(TEST_WISH));

        Assertions.assertEquals(exception.getStatus(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void shouldThrowWhenDeletingNonExistingWish() {
        UUID uuid = TEST_WISH.getUuid();
        Mockito.when(wishRepository.existsById(Mockito.any(UUID.class)))
                .thenReturn(false);

        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> wishService.deleteWish(uuid));

        Assertions.assertEquals(exception.getStatus(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void shouldGetWish() {
        UUID uuid = TEST_WISH.getUuid();
        Optional<Wish> optionalWish = Optional.of(TEST_WISH);

        Mockito.when(wishRepository.findById(Mockito.any(UUID.class)))
                .thenReturn(optionalWish);
        Wish result = wishService.getWish(uuid);

        Assertions.assertEquals(result, TEST_WISH);
    }

    @Test
    public void shouldGetWishList() {
        Wish wish2 = new Wish(UUID.fromString("26214c99-2961-4549-ad79-c42b6de03ca8"), "Porsche");
        Wish wish3 = new Wish(UUID.fromString("4de03225-23aa-4513-be72-d98886c606cf"), "Pizza");
        List<Wish> expectedResult = List.of(TEST_WISH, wish2, wish3);

        Mockito.when(wishRepository.findAll())
                .thenReturn(List.of(TEST_WISH, wish2, wish3));
        List<Wish> result = wishService.getWishList();

        Assertions.assertEquals(expectedResult, result);
    }
}
