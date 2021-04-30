package com.tugas.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "brand")
public class brand implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Nama is Required")
    private String nama_brand;

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getnama_brand() {
        return nama_brand;
    }

    public void setnama_brand(String nama_brand) {
        this.nama_brand = nama_brand;
    }

}
