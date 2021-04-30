package com.tugas.dto;

import java.util.ArrayList;
import java.util.List;

public class repondData<M> {

    private boolean status;
    private List<String> message = new ArrayList<>();
    private M payload;
    
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public List<String> getMessage() {
        return message;
    }
    public void setMessage(List<String> message) {
        this.message = message;
    }
    public M getPayload() {
        return payload;
    }
    public void setPayload(M payload) {
        this.payload = payload;
    }
    
}
