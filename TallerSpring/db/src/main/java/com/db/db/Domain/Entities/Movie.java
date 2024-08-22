package com.db.db.Domain.Entities;

import java.time.LocalDateTime;
import java.util.Set;

import com.db.db.Domain.Entities.Enums.Classification;
import com.db.db.Domain.Entities.Enums.SpecialsDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "pelicula")
public class Movie {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula" , columnDefinition = "SMALLINT UNSIGNED" )
    private int id;

    @Column(name = "titulo" , columnDefinition = "varchar(255)")
    private String title; 

    @Column(name = "descripcion" , columnDefinition = "TEXT")
    private String description; 

    @Column(name = "anyo_lanzamiento" , columnDefinition = "year")
    private String releaseYear; 

    @ManyToOne
    @JoinColumn(name = "id_idioma" , columnDefinition = "SMALLINT UNSIGNED") 
    private Language language; 


    @ManyToOne 
    @JoinColumn(name = "id_idioma_original" , columnDefinition = "SMALLINT UNSIGNED") 
    private Language originalLanguage; 


    @Column(name = "duracion_alquiler" , columnDefinition = "TINYINT UNSIGNED")
    private int rentDuration ; 

    @Column(columnDefinition = "DECIMAL(4,2)" )
    private double rental_rate;


    @Column(name = "duracion" , columnDefinition = "SMALLINT UNSIGNED " )
    private double movieDuration;

    @Column(columnDefinition = "DECIMAL (5,2)")
    private double replacement_cost;

 
    // crear un enum tambien tengo una clase Classification
   @Column(name = "clasificacion" , columnDefinition = "ENUM('G' , 'PG' , 'PG_13' , 'R' , 'NC_17'  )" )
   @Enumerated(EnumType.STRING)
    private Classification clasification; 

    // crear un set
    @Column(name = "special_details" , columnDefinition = "set('Deleted Scenes' , 'Trailers' , 'Commentaries' , 'Behind the Scenes')")
    private Set<String> details;


    

    


    @Column(name = "ultima_actualizacion" , columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdate;









}
