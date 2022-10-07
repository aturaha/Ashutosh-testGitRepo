package com.example.demo.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user_details")
public class CatalogDetails {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer detailId;
    private String name;
    private String email;
    private String password;
	
    //private String name;
	//private String desc;
	//private int age;
	//private List<Long> tagIds;
  //  private HttpStatus status;
	
	
	
    /*
     * public CatalogDetails(String name, String desc, int age) {
     * //super();
     * this.name = name;
     * this.desc = desc;
     * this.age = age;
     * // this.tagIds = Collections.emptyList();
     * // this.status = HttpStatus.NOT_FOUND;
     * //this.status = ;
     * }
     */
    /*
     * public String getName() {
     * return name;
     * }
     * public void setName(String name) {
     * this.name = name;
     * }
     * public String getDesc() {
     * return desc;
     * }
     * public void setDesc(String desc) {
     * this.desc = desc;
     * }
     * public int getAge() {
     * return age;
     * }
     * public void setAge(int age) {
     * this.age = age;
     * }
     */
	
	
}
