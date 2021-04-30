package com.tugas.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "product")
public class product implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    private String id_barang;

    @NotEmpty(message = "Nama is Required")
    private String nama_product;

    @NotEmpty(message = "Keterangan in Required")
    private String keterangan;

    private double harga;

    @ManyToOne
    private brand brand;

    public brand getBrand() {
        return brand;
    }

    public void setBrand(brand brand) {
        this.brand = brand;
    }

    public product() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_product() {
        return nama_product;
    }

    public void setNama_product(String nama_product) {
        this.nama_product = nama_product;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public product(String id_barang, String nama_product, String keterangan, double harga) {
        this.id_barang = id_barang;
        this.nama_product = nama_product;
        this.keterangan = keterangan;
        this.harga = harga;
    }

}
