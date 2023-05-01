package com.jairoibarra.inventory.inventory.services;

import com.jairoibarra.inventory.inventory.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface InterfaceCategoryService {

    public ResponseEntity<CategoryResponseRest> search();

}
