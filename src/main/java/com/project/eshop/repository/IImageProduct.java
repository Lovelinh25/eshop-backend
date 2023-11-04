package com.project.eshop.repository;

import com.project.eshop.entity.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageProduct extends JpaRepository<ImageProduct, Integer> {
}

