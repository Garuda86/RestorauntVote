package ru.garuda86.graduation.to;

import ru.garuda86.graduation.model.Dish;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
public class DishTo extends BaseTo implements Serializable {

    @NotBlank
    @Size(min = 10, max = 100)
    private String name;

    @NotNull
    private BigDecimal price;

    public DishTo(Dish dish) {
        this.name = dish.getName();
        this.price = dish.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
