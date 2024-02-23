package org.automation.testdata;

import java.util.Objects;

public class Product {
    private String title;
    private String description;
    private String price;

    public Product(String title, String description, String price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
    }

}
