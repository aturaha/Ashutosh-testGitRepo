package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CatalogDetails;

public interface DetailsRepository extends JpaRepository<CatalogDetails, Integer> {

    CatalogDetails save(CatalogDetails catalogDetails);
    

}
