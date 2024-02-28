package com.cb.portfolio.repositories;

import com.cb.portfolio.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
