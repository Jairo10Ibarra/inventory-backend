package com.jairoibarra.inventory.inventory.dao;

import com.jairoibarra.inventory.inventory.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCategoryDao extends CrudRepository<Category, Long> {

}
