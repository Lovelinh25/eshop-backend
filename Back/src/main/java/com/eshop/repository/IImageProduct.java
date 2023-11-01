package com.eshop.repository;

import com.eshop.entity.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageProduct extends JpaRepository<ImageProduct, Integer> {
}
