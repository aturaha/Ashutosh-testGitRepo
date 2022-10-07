package com.example.demo.service;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.example.demo.model.CatalogDetails;
//import com.example.demo.model.Details;
import com.example.demo.repositry.DetailsRepository;
import com.example.demo.repositry.MasterySetsRepository;
import com.example.demo.dto.DetailsDTO;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
//@XRayEnabled
public class CoreService {
    @Autowired
    DetailsRepository detailsRepository;
    @Autowired
    DetailsService detailsService;

    @Autowired
    MasterySetsRepository masterySetsRepository;

    @Value("${INFUSION_SOFT_CLIENT_ID}")
    private String client_id;
           public ResponseEntity findAll() {
            
        List<DetailsDTO> exercisesDTOList = new LinkedList<>();

        String access_token = "hmpP6UKe2AEDLB2UOIJGAN5CLVk1";
        // Sets up the java client, including the api url
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        CatalogDetails catalogDetails1 = null;
        try {
            config.setServerURL(
                    new URL("https://api.infusionsoft.com/crm/xmlrpc/v1?access_token=" + access_token.trim()));
        } catch (MalformedURLException e) {
            // log.info(" MalformedURLException ");
            e.printStackTrace();
        }
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        // The secure encryption key
        String key = client_id;
        String userEmail = "v.nirmal@gymfit.tv";
        List parameters = new ArrayList();
        List fields = new ArrayList();
        fields.add("Id");
        fields.add("FirstName");
        fields.add("LastName");
        fields.add("Password");
        parameters.add(key.trim()); // The secure key
        parameters.add(userEmail.trim()); // The table we will be adding to
        parameters.add(fields); // The data to be added

        // Make the call
        Object[] contacts = new Object[0];
        try {
            contacts = (Object[]) client.execute("ContactService.findByEmail", parameters);
        } catch (XmlRpcException e) {
            System.out.println(" XML RPC EXCEPTION ");
            e.printStackTrace();
        }

        CatalogDetails catalogDetails = new CatalogDetails();

        if (!contacts.equals(null)) {

            // Loop through results
            for (int i = 0; i < contacts.length; i++) {
                // Each ite m in the array is a struct
                Map contact = (Map) contacts[i];
                catalogDetails.setDetailId((Integer) contact.get("Id"));
               // catalogDetails.setDetailId(1);

                catalogDetails.setName(contact.get("FirstName") == null ? "" : contact.get("FirstName").toString());
                catalogDetails.setEmail(contact.get("LastName") == null ? "" : contact.get("LastName").toString());

                // log.info("USERS PASSWORD *****"+contact.get("Password"));
                if (contact.get("Password") != null)
                    catalogDetails.setPassword(contact.get("Password").toString());
                else
                    catalogDetails.setPassword(null);

                    catalogDetails1 = detailsService.saveUserDetails(catalogDetails);

               return ResponseEntity.ok().body(catalogDetails1);
               }
            return null;

        }

               return ResponseEntity.ok().body(catalogDetails1);
        }

    
}
