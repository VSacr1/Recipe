package business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import persistence.repository.RecipeRepository;

public class RecipeServiceImpl implements RecipeService {

	@Inject
	private RecipeRepository repo; 
	
	public String getAllRecipes()
	{
		return repo.getAllRecipes();
	}
	
	@Override
	public String addRecipe(String recipe)
	{
		if(recipe.contains("Bacon"))
		{
			return "Can't Add this recipe";
		}
		return repo.createRecipe(recipe);
	}
	
	@Override
	public String deleteRecipe(Long id)
	{
		return repo.deleteRecipe(id);
	}
	
	public void setRepo(RecipeRepository repo)
	{
		this.repo = repo; 
	}
	
	@Override
	public String getARecipe(Long id)
	{
		return repo.getARecipe(id);
	}
	
	@Override 
	public String updateRecipe(String recipe, Long id)
	{
		return repo.updateRecipes(recipe, id);
	}

	@Override
	public int cycleRecipes(String recipe) {
		// TODO Auto-generated method stub
		return repo.cycleRecipe(recipe);
	}
}
