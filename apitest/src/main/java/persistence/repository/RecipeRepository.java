package persistence.repository;

public interface RecipeRepository {

		//C
		String createRecipe(String recipe);
		
		//R
		String getAllRecipes();
		
		String getARecipe(Long id);
		
		//U
		String updateRecipes(String recipe, Long id);

		//D
		String deleteRecipe(Long id);
		
		int cycleRecipe(String recipe);


		

}
