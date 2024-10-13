// WishlistService.java
package com.cye.capstone_project.service;

import com.cye.capstone_project.model.Wishlist;
import com.cye.capstone_project.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Wishlist> getWishlistByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Wishlist addToWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public void removeFromWishlist(Long id) {
        wishlistRepository.deleteById(id);
    }
}
