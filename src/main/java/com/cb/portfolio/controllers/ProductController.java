package com.cb.portfolio.controllers;

import com.cb.portfolio.dto.ProductDto;
import com.cb.portfolio.entities.Product;
import com.cb.portfolio.helpers.ErrorsHelper;
import com.cb.portfolio.helpers.PaginationResponse;
import com.cb.portfolio.services.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<?> getProducts(
            @Min (0) @RequestParam(required = true) int offset, @Min(1) @RequestParam(required = true) int limit) {
        List<Product> products = this.productService.findAll(offset, limit);
        PaginationResponse response = new PaginationResponse(offset,limit,this.productService.count(),products);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Optional<Product> product = this.productService.findById(id);
        if (!product.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@Valid  @RequestBody ProductDto product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorsHelper.getErrors(result));
        }
        Product productEntity = this.modelMapper.map(product, Product.class);
        return ResponseEntity.ok(this.productService.save(productEntity));
    }

}