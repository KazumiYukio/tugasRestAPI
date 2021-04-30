package com.tugas.services;

import javax.transaction.Transactional;

import com.tugas.model.entity.product;
import com.tugas.model.repos.productrepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class productservice {
    
    @Autowired
    private productrepos productrepos;

    public product save(product product){
        return productrepos.save(product);
    }

    public product findOne(String id){
        return productrepos.findByIdContain(id);
    }

    public Iterable<product> findAll(){
        return productrepos.findAll();
    }

    public void deletebyid(String id){
        productrepos.deleteId(id);
    }

}
