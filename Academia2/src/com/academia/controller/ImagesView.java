package com.academia.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagesView {
     
    private List<String> imagenes;
     
    @PostConstruct
    public void init() {
    	imagenes = new ArrayList<String>();
    	imagenes.add("inicio1.png");
    	imagenes.add("inicio2.png");
    	imagenes.add("inicio3.jpg");
    	imagenes.add("inicio4.jpg");
        
    }
 
    public List<String> getImagenes() {
        return imagenes;
    }
}