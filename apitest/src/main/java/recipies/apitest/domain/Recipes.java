package recipies.apitest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Recipes {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id; 
	
	private String recipe; 
	private String ingredients; 
	
	public Recipes()
	{
		
	}
	
	public Recipes(String recipe, String ingredients)
	{
		this.recipe = recipe; 
		this.ingredients = ingredients;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
