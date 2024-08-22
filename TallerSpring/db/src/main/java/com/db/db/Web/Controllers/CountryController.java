package com.db.db.Web.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.xml.catalog.Catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.db.Domain.Entities.Country;
import com.db.db.Domain.Service.Country.CountryInterface;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/api/countries")

public class CountryController {

    @Autowired 
    private CountryInterface service;


    @GetMapping("/all")
    public ResponseEntity<Page<Country>> findAll(Pageable pageable) {
        
        Page<Country> countryPage = service.findAll(pageable);

        if (countryPage.hasContent()) {
            return ResponseEntity.ok(countryPage);
        }

        return ResponseEntity.notFound().build();
        
        
    }


    @GetMapping("/{id}")
    public ResponseEntity<Country> view (@PathVariable int id) {
        Optional<Country> country = service.findById(id); 

        if (country.isPresent()) {
            return ResponseEntity.ok(country.orElseThrow());
        }

        return ResponseEntity.notFound().build();

        
    }

    // response entity variable para personalizar salida enviar el estado de la peticion 

    // el valid va para validar el objeto de entrada 
    @PostMapping 
    public ResponseEntity<Country> create(@Valid @RequestBody Country country) {

        Country countryNew = service.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryNew);
    }  

/* 
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Country country, BindingResult result){
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(country));
    } */
    
/*     private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    } */


    

}
