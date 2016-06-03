package com.quitevis.algorithms.knapsack;

public class Item {
    private final int value;
    private final int weight;
    private final int id;

    public Item(int id, int value, int weight) {
        this.id = id;
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("id: %d, value: %d, weight: %d", id, value, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (value != item.value) return false;
        if (weight != item.weight) return false;
        return id == item.id;

    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + weight;
        result = 31 * result + id;
        return result;
    }
}
