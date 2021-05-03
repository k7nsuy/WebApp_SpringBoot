package org.fkpk.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Recipe {
	private Integer recipeId;
	private String recipeName;
	private String recipeIngredient;
	private String recipeCookingorder;
	private MultipartFile uploadFile;
	private String recipeImg;

}
