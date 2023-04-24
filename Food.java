// A class to represent a food object with calories, fat, carbohydrates, and sodium
class Food {
    private String name;
    private double calories;
    private double fat;
    private double carbohydrates;
    private double sodium;

    // A constructor that takes the name and the nutrient values
    public Food(String name, double calories, double fat, double carbohydrates, double sodium) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.sodium = sodium;
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    // A toString method to display the food object
    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", sodium=" + sodium +
                '}';
    }
}
