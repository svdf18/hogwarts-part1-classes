package edu.hogwarts;

public class Ingredient extends TeachingMaterial {
    private String name;
    private double amount;
    private String unit;

    public Ingredient(String name, boolean onShoppingList, boolean required, boolean provided, String notes,
                      String ingredientName, double amount, String unit) {
        super(name, onShoppingList, required, provided, notes);
        this.name = ingredientName;
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient(){};

    // Getters and Setters for Ingredient-specific properties
    public String getIngredientName() {
        return name;
    }

    public void setIngredientName(String ingredientName) {
        this.name = ingredientName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Ingredient Name: " + getIngredientName() +
                ", Amount: " + getAmount() +
                ", Unit: " + getUnit();
    }

}

