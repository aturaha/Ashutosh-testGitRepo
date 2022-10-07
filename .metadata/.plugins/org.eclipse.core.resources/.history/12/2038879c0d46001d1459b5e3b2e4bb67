package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.example.demo.model.CatalogDetails;
import com.example.demo.repositry.DetailsRepository;

@Service
@XRayEnabled
public class DetailsService {

    @Autowired
    DetailsRepository detailsRepository;

    
    public CatalogDetails saveUserDetails(CatalogDetails catalogDetails) {
        return detailsRepository.save(catalogDetails);

    }
    
}
