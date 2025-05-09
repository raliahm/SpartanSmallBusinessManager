package com.SpartanSmallBusinessManager.API.product;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProvider(Provider provider);
}
