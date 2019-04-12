package persistence.repository;


import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import recipies.apitest.domain.Recipes;
import util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class RecipeDBRepository implements RecipeRepository {


		@PersistenceContext(unitName = "primary")
		private EntityManager manager; 
		
		@Inject
		private JSONUtil util;
		
		public void setManager(EntityManager manger)
		{
			this.manager = manager; 
		}
		
		public void setUtil(JSONUtil util)
		{
			this.util = util; 
		}
		
		public String updateRecipe(String recipe, Long id)
		{
			return null; 
		}

	@Override
	@Transactional(REQUIRED)
	public String createRecipe(String recipes) {
		Recipes aRecipe = util.getObjectForJSON(recipes,Recipes.class);
		manager.persist(aRecipe);
		return "{\"message\": \"recipe has been successfully added\"}";
	}

	@Override
	public String getAllRecipes() {
		Query query = manager.createQuery("Select r FROM Recipes r"); 
		Collection<Recipes> recipes = (Collection<Recipes>
		) query.getResultList();
		
		return util.getJSONForObject(recipes);
	}

	@Override
	public String getARecipe(Long id)
	{
		return util.getJSONForObject(manager.find(Recipes.class, id));
	}

	@Override
	@Transactional(REQUIRED)
	public String updateRecipes(String recipe, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteRecipe(Long id) {
		Recipes recipesInDB = util.getObjectForJSON(getARecipe(id), Recipes.class);
		
		if(manager.contains(manager.find(Recipes.class, id)))
		{
			manager.remove(manager.find(Recipes.class, id));
		}
		return "{\"message\": \"recipe has been removed\"}";
	}

	@Override
	public int cycleRecipe(String recipe) {
		Query query = manager.createQuery("Select a FROM recipe e");
		Collection<Recipes> recipes = (Collection<Recipes>) query.getResultList(); 
		
		List<Recipes> validList = recipes.stream().filter(n -> n.getRecipe().equals(recipe)).collect(Collectors.toList());
		
		return validList.size(); 
	}



}
