package com.jairoibarra.inventory.inventory.services;

import com.jairoibarra.inventory.inventory.model.Category;
import com.jairoibarra.inventory.inventory.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface InterfaceCategoryService {

    public ResponseEntity<CategoryResponseRest> search();
    public ResponseEntity<CategoryResponseRest> searchById(Long id);
    public ResponseEntity<CategoryResponseRest> save(Category category);

}
