package com.jtsp.springiocdemo;

public class CoffeeBean {
    private String origin;
    private String roastLevel;
    private Integer quantity;

    public CoffeeBean(String origin, String roastLevel, Integer quantity) {
        this.origin = origin;
        this.roastLevel = roastLevel;
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getRoastLevel() {
        return roastLevel;
    }

    public void setRoastLevel(String roastLevel) {
        this.roastLevel = roastLevel;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CoffeeBean{" +
                "origin='" + origin + '\'' +
                ", roastLevel='" + roastLevel + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
