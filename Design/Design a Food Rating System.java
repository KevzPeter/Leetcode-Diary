class FoodRatings {
    private class FoodRating{
        String food;
        int rating;
        FoodRating(String f, int r){
            food = f;
            rating = r;
        }
    }
    private class CustomComparator implements Comparator<FoodRating>{
        @Override
        public int compare(FoodRating a, FoodRating b){
            return a.rating == b.rating ? a.food.compareTo(b.food) : b.rating - a.rating;
        }
    }
    String[] foods;
    String[] cuisines;
    int[] ratings;
    HashMap<String, PriorityQueue<FoodRating>> cuisineMap;
    HashMap<String, Pair<String, Integer>> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        cuisineMap = new HashMap<>();
        foodMap = new HashMap<>();
        for(int i = 0; i < foods.length; i++){
            String cuisine = cuisines[i];
            String food = foods[i];
            int rating = ratings[i];
            if(!cuisineMap.containsKey(cuisine)){
                cuisineMap.put(cuisine, new PriorityQueue<>(new CustomComparator()));
            }
            foodMap.put(food, new Pair(cuisine, rating));
            cuisineMap.get(cuisine).offer(new FoodRating(food, rating));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodMap.get(food).getKey();
        foodMap.put(food, new Pair(cuisine, newRating));
        cuisineMap.get(cuisine).offer(new FoodRating(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        if(cuisineMap.get(cuisine).size() == 0) return "";
        FoodRating obj = cuisineMap.get(cuisine).peek();
        int currentRating = foodMap.get(obj.food).getValue();
        if(currentRating == obj.rating){
            return obj.food;
        }
        else{
            cuisineMap.get(cuisine).poll();
            return highestRated(cuisine);
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */