package com.jairoibarra.inventory.inventory.services;

import com.jairoibarra.inventory.inventory.dao.InterfaceCategoryDao;
import com.jairoibarra.inventory.inventory.model.Category;
import com.jairoibarra.inventory.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

            categoryResponseRest.setMetadata("Respuesta OK" , "00" , "RESPUESTA EXITOSA");

            categoryResponseRest.getCategoryResponse().setCategory(category);


        } catch (Exception e) {

            categoryResponseRest.setMetadata("Respuesta FAIL" , "-1" , "ERROR AL CONSULTAR CATEGORYS");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(categoryResponseRest , HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<CategoryResponseRest>(categoryResponseRest , HttpStatus.OK);

    }

}
