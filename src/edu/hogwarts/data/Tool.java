package edu.hogwarts.data;

import edu.hogwarts.data.TeachingMaterial;

public class Tool extends TeachingMaterial {
    private String name;
    private String description;

    public Tool(String name, boolean onShoppingList, boolean required, boolean provided, String notes,
                String toolName, String description) {
        super(name, onShoppingList, required, provided, notes);
        this.name = toolName;
        this.description = description;
    }

    public Tool(){};

    // Getters and Setters
    public String getToolName() {
        return name;
    }

    public void setToolName(String toolName) {
        this.name = toolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Tool Name: " + getToolName() +
                ", Description: " + getDescription();
    }
}

