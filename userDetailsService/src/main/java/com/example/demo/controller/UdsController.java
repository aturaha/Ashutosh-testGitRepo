package com.example.demo.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DetailsDTO;
import com.example.demo.model.CatalogDetails;
import com.example.demo.service.CoreService;
import com.google.common.base.Objects;

@RestController
@RequestMapping("/details")
public class UdsController {

	 @Autowired
     CoreService coreService;

	
	/*
	 * @GetMapping("/userDetails/all") public Map<Integer, List<DetailsDTO>>
	 * findAllExercises() { return coreService.findAll(); }
	 */
	
	 @GetMapping("/userDetails/all")
     public ResponseEntity findAllExercises() {
             return coreService.findAll();
     }
	 
    /*
     * @RequestMapping("/{userId}")
     * public List<CatalogDetails> getDetails(@PathVariable("userId") String userId)
     * {
     * 
     * return Collections.singletonList(new CatalogDetails("Ashutosh",
     * "user details", 10));
     * 
     * }
     */

}