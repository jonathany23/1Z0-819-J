package com.java.course.section4.class_objects.data;

import java.math.BigDecimal;

import static com.java.course.section4.class_objects.data.Rating.*;
import static java.math.RoundingMode.HALF_UP;

public class Product {

    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private int id;
    private String name;
    private BigDecimal price;

    private Rating rating;

    public Product() {
        this(0, "no name", BigDecimal.ZERO);
    }

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, NO_RATED);
    }

    public int getId() {
        return id;
    }

    /*public void setId(final int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    /*public void setName(final String name) {
        this.name = name;
    }*/

    public BigDecimal getPrice() {
        return price;
    }

    /*public void setPrice(final BigDecimal price) {
        //price = BigDecimal.ONE; //Error ya que el parametro es de  tipo final y no se puede reasignar
        this.price = price;
    }*/

    public BigDecimal getDiscount(){
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    public Product applyRating(Rating newRating){
        return new Product(this.id, this.name, this.price, newRating);
    }
}
