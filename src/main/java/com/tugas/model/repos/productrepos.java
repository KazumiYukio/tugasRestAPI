package com.tugas.model.repos;

import javax.websocket.server.PathParam;

import com.tugas.model.entity.product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface productrepos extends CrudRepository<product, String> {
    @Query("SELECT p FROM product p WHERE p.id_barang = :id")
    public product findByIdContain(@PathParam("id") String id);

    @Modifying
    @Query("DELETE FROM product p WHERE p.id_barang = :id")
    public void deleteId(@PathParam("id") String id);
}
