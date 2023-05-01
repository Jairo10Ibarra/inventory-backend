package com.jairoibarra.inventory.inventory.controller;

import com.jairoibarra.inventory.inventory.response.CategoryResponseRest;
import com.jairoibarra.inventory.inventory.services.InterfaceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class CategoryRestController {

    @Autowired
    private InterfaceCategoryService interfaceCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest>  searhCategories(){
        ResponseEntity<CategoryResponseRest> response = interfaceCategoryService.search();
        return response;
    }

}
