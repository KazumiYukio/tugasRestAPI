package com.tugas.controller;

import javax.validation.Valid;

import com.tugas.dto.repondData;
import com.tugas.model.entity.product;
import com.tugas.services.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tugasApi/product")
public class productController {
    
    @Autowired
    private productservice productservice;

    @PostMapping
    public ResponseEntity<repondData<product>> create(@Valid @RequestBody product product, Errors errors){
        repondData<product> respondData = new repondData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                respondData.getMessage().add(error.getDefaultMessage());
            }
            respondData.setStatus(false);
            respondData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respondData);
        }
        respondData.setStatus(true);
        respondData.setPayload(productservice.save(product));
        return ResponseEntity.ok(respondData);
    }

    @GetMapping
    public Iterable<product> findAll(){
        return productservice.findAll();
    }

    @GetMapping("/{id}")
    public product findById(@PathVariable("id") String id){
        return productservice.findOne(id);
    }

    @PutMapping
    public product update(@RequestBody product product){
        return productservice.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        productservice.deletebyid(id);
    }
}
