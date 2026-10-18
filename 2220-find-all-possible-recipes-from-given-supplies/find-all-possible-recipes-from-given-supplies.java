class Solution {
    public Set<String> availableSupplies;
    public Map<String, List<String>> recipeToIngredients;
    public Map<String, Integer> vis;
    public List<String> res;

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        availableSupplies = new HashSet<>(Arrays.asList(supplies));
        recipeToIngredients = new HashMap<>();
        vis = new HashMap<>();
        res = new ArrayList<>();

        for(int i = 0; i < recipes.length; i++) recipeToIngredients.put(recipes[i], ingredients.get(i));
        for (String recipe : recipes) canMake(recipe);

        return res;
    }

    private boolean canMake(String recipe) {
        if(vis.containsKey(recipe)) return vis.get(recipe) == 1;
        if(availableSupplies.contains(recipe)) return true;
        if(!recipeToIngredients.containsKey(recipe)) return false;
        vis.put(recipe, 0);

        for(String ingredient : recipeToIngredients.get(recipe)){
            if(!canMake(ingredient)){
                vis.put(recipe, -1);
                return false;
            }
        }
        vis.put(recipe, 1);
        res.add(recipe);
        return true;
    }
}