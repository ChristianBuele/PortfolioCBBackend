package com.cb.portfolio.controllers;

import com.cb.portfolio.dto.CategoryDto;
import com.cb.portfolio.entities.Category;
import com.cb.portfolio.helpers.ApiResponse;
import com.cb.portfolio.helpers.ErrorsHelper;
import com.cb.portfolio.services.CategoryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<?> saveCategory(@Valid @RequestBody CategoryDto categoryDto, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder().success(false)
                            .message(ErrorsHelper.getErrorsString(result))
                            .data(null)
                            .build());
        }
        System.out.println(categoryDto);
        Category category=modelMapper.map(categoryDto,Category.class);
        return ResponseEntity.ok(categoryService.save(category));
    }

    @GetMapping
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(categoryService.findAll());
    }
}
