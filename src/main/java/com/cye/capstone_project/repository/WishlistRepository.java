// WishlistRepository.java
package com.cye.capstone_project.repository;

import com.cye.capstone_project.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUserId(Long userId);

    Optional<Wishlist> findByUserIdAndEventId(Long userId, Long eventId); // New method
}
