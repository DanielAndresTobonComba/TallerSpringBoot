package com.db.db.Web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.db.Domain.Entities.Country;
import com.db.db.Domain.Service.Country.CountryInterface;
import org.springframework.web.bind.annotation.GetMapping;




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
    


    

}
