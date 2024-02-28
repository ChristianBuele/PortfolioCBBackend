package com.cb.portfolio.controllers;

import com.cb.portfolio.dto.ImageDto;
import com.cb.portfolio.entities.Image;
import com.cb.portfolio.entities.Product;
import com.cb.portfolio.helpers.ApiResponse;
import com.cb.portfolio.helpers.ErrorsHelper;
import com.cb.portfolio.services.ImageService;
import com.cb.portfolio.services.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<?> saveImage(@Valid  @RequestBody ImageDto image, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder().success(false)
                            .message(ErrorsHelper.getErrorsString(result))
                            .data(null)
                            .build());
        }
        Optional<Product> product = productService.findById(image.getId_product());
        if (!product.isPresent()) {
            return ResponseEntity.badRequest().body("Product not found");
        }
        Image entityImage= modelMapper.map(image, Image.class);
        entityImage.setProduct(product.get());
        return ResponseEntity.ok(imageService.saveImage(entityImage));
    }

    @GetMapping
    public ResponseEntity<?> getImages() {
        return ResponseEntity.ok(imageService.getImages());
    }
}
