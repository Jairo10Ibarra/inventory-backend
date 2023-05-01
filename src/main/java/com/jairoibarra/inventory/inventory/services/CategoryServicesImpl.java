package com.jairoibarra.inventory.inventory.services;

import com.jairoibarra.inventory.inventory.dao.InterfaceCategoryDao;
import com.jairoibarra.inventory.inventory.model.Category;
import com.jairoibarra.inventory.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServicesImpl implements InterfaceCategoryService {

    @Autowired
    private InterfaceCategoryDao interfaceCategoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {

        CategoryResponseRest categoryResponseRest = new CategoryResponseRest();

        try {

            List<Category> category = (List<Category>) interfaceCategoryDao.findAll();
            categoryResponseRest.setMetadata("Respuesta OK", "00", "RESPUESTA EXITOSA");
            categoryResponseRest.getCategoryResponse().setCategory(category);

        } catch (Exception e) {

            categoryResponseRest.setMetadata("Respuesta FAIL", "-1", "ERROR AL CONSULTAR CATEGORYS");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.OK);

    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {

        CategoryResponseRest categoryResponseRest = new CategoryResponseRest();
        List<Category> listaCategorias = new ArrayList<>();

        try {

            Optional<Category> category = interfaceCategoryDao.findById(id);

            if (category.isPresent()) {

                categoryResponseRest.setMetadata("Respuesta OK", "00", "CATEGORIA ENCONTRADA");
                listaCategorias.add(category.get());
                categoryResponseRest.getCategoryResponse().setCategory(listaCategorias);

            } else {
                categoryResponseRest.setMetadata("Respuesta FAIL", "-1", "CATEGORIA NO ENCONTRADA");
                return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {

            categoryResponseRest.setMetadata("Respuesta FAIL", "-1", "ERROR AL CONSULTAR CATEGORIAS POR ID");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.OK);
    }

    @Override
    @Transactional()
    public ResponseEntity<CategoryResponseRest> save(Category category) {

        CategoryResponseRest categoryResponseRest = new CategoryResponseRest();
        List<Category> listaCategorias = new ArrayList<>();

        try {

        Category categorySaved = interfaceCategoryDao.save(category);

        if (categorySaved != null){

            categoryResponseRest.setMetadata("Respuesta OK", "00", "CATEGORIA GUARDADA CON EXITO");
            listaCategorias.add(categorySaved);
            categoryResponseRest.getCategoryResponse().setCategory(listaCategorias);

        } else {

            categoryResponseRest.setMetadata("Respuesta FAIL", "-1", "CATEGORIA NO GUARDADA");
            return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.BAD_REQUEST);

        }

        } catch (Exception e) {

            categoryResponseRest.setMetadata("Respuesta FAIL", "-1", "ERROR AL GUARDAR CATEGORIA");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.OK);
    }


}
