package com.jairoibarra.inventory.inventory.controller;

import com.jairoibarra.inventory.inventory.model.Category;
import com.jairoibarra.inventory.inventory.response.CategoryResponseRest;
import com.jairoibarra.inventory.inventory.services.InterfaceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CategoryRestController {

    @Autowired
    private InterfaceCategoryService interfaceCategoryService;

    /**
     *GET ALL CATEGORIES
     * @return
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest>  searhCategories(){
        ResponseEntity<CategoryResponseRest> response = interfaceCategoryService.search();
        return response;
    }

    /**
     *GET ONE CATEGORY BY ID
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest>  searhCategoriesById(@PathVariable Long id){
        ResponseEntity<CategoryResponseRest> response = interfaceCategoryService.searchById(id);
        return response;
    }

    /**
     *SAVE ONE CATEGORY
     * @param "Category"
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest>  save(@RequestBody Category category){
        ResponseEntity<CategoryResponseRest> response = interfaceCategoryService.save(category);
        return response;
    }
}
