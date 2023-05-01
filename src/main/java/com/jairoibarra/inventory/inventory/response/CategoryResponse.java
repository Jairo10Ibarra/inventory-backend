package com.jairoibarra.inventory.inventory.response;

import com.jairoibarra.inventory.inventory.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private List<Category> category;
}
