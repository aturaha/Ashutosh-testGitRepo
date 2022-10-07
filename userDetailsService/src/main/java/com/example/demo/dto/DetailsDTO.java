package com.example.demo.dto;

//package com.gymnasticbodies.my.foundcoreservice.dto;

import com.example.demo.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetailsDTO {
    private Integer exerciseId;
    private String name;
    private String imName;
    private String element;
    private String elementFullName;
    private Integer progressionLevel;
    private String imMastery;
    private Integer masterySetId;
    private String notation;
	/*
	 * private Courses courseInfo; private Map<Integer, List<ExercisesFocusPoints>>
	 * exercisesFocusPoints = new LinkedHashMap<>(); private Map<Integer,
	 * List<ExercisesInstructions>> exercisesInstructions = new LinkedHashMap<>();
	 * private Map<Integer, List<ExercisesVideos>> exercisesVideos = new
	 * LinkedHashMap<>(); private Map<Integer, MasterySets> masterySets=new
	 * LinkedHashMap<>();
	 */
	
	
}



