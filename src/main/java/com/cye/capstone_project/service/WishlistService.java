// WishlistService.java
package com.cye.capstone_project.service;

import com.cye.capstone_project.model.Wishlist;
import com.cye.capstone_project.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Wishlist> getWishlistByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Wishlist addToWishlist(Wishlist wishlist) {
        Optional<Wishlist> existingWishlistItem = wishlistRepository.findByUserIdAndEventId(
                wishlist.getUserId(), wishlist.getEventId()
        );

        // Check if the event is already in the user's wishlist
        if (existingWishlistItem.isPresent()) {
            return existingWishlistItem.get(); // Return the existing entry if present
        } else {
            return wishlistRepository.save(wishlist); // Save only if not present
        }
    }

    public void removeFromWishlist(Long id) {
        wishlistRepository.deleteById(id);
    }
}

