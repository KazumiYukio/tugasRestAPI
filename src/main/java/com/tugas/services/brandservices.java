package com.tugas.services;

import javax.transaction.Transactional;

import com.tugas.model.entity.brand;
import com.tugas.model.repos.brandrepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class brandservices {
    
    @Autowired
    private brandrepos brandrepos;

    public brand save(brand brand){
        return brandrepos.save(brand);
    }

    public brand findOne(Long id){
        return brandrepos.findById(id).get();
    }

    public Iterable<brand> findAll(){
        return brandrepos.findAll();
    }

    public void deleteById(Long id){
        brandrepos.deleteById(id);
    }

}
