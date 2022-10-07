package com.example.demo.repositry;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MasterySets;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterySetsRepository extends CrudRepository<MasterySets, Integer> {

    List<MasterySets> findByMasteryLevelAndDefaultValue(String masteryLevel, Byte defaultVal);

    Optional<MasterySets> findOneByMasterySetId(Integer masterySetId);
}

