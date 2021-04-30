package com.tugas.controller;

import javax.validation.Valid;

import com.tugas.dto.brandDto;
import com.tugas.dto.repondData;
import com.tugas.model.entity.brand;
import com.tugas.services.brandservices;

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
@RequestMapping("tugasApi/brand")
public class brandController {
        
    @Autowired
    private brandservices brandservice;
    
    @PostMapping
    public ResponseEntity<repondData<brand>> create(@Valid @RequestBody brandDto brandDto, Errors errors){
        repondData<brand> respondData = new repondData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                respondData.getMessage().add(error.getDefaultMessage());
            }
            respondData.setStatus(false);
            respondData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respondData);
        }
        brand brand = new brand();
        brand.setnama_brand(brandDto.getnama_brand());

        respondData.setStatus(true);
        respondData.setPayload(brandservice.save(brand));
        return ResponseEntity.ok(respondData);
    }

    @GetMapping
    public Iterable<brand> findAll(){
        return brandservice.findAll();
    }

    @GetMapping("/{id}")
    public brand findById(@PathVariable("id") Long id){
        return brandservice.findOne(id);
    }

    @PutMapping
    public brand update(@RequestBody brand brand){
        return brandservice.save(brand);
    }

    @DeleteMapping
    public void deleteById(@PathVariable("id") Long id){
        brandservice.deleteById(id);;
    }
}
