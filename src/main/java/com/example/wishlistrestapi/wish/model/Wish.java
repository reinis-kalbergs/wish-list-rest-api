package com.example.wishlistrestapi.wish.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @NotNull
    @NotBlank
    private String item;

    public Wish(AddWishRequest addWishRequest) {
        this.item = addWishRequest.getItem();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Wish wish = (Wish) o;
        return uuid != null && Objects.equals(uuid, wish.uuid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
