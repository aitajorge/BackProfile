package com.portfoliobe.aitabe.DataTO;

import jakarta.validation.constraints.NotBlank;


public class dtoExp {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcionExp;

    public dtoExp() {
    }

    public dtoExp(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
    
    
}
