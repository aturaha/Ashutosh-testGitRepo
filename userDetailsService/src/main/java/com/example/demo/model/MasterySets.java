package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
@Table(name="mastery_sets")
public class MasterySets {
    @Id
    private Integer masterySetId;
    private String masteryLevel;
    private BigDecimal weekNum;
    private Byte sets;
    private String repsOrSecs;
    @Column(name = "default")
    @JsonIgnore
    private Byte defaultValue;
}

