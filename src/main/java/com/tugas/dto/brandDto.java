package com.tugas.dto;

import javax.validation.constraints.NotEmpty;

public class brandDto {

    @NotEmpty(message = "Nama is Required")
    private String nama_brand;

    public String getnama_brand() {
        return nama_brand;
    }

    public void setnama_brand(String nama_brand) {
        this.nama_brand = nama_brand;
    }
}
