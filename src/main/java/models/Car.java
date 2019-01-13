package models;

import models.enums.ColorEnum;
import models.validators.CarValidators;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Car {
    protected String model;
    protected BigDecimal price;
    protected ColorEnum color;
    protected Integer mileage;
    protected Set<String> components;

    public Car() {
        components = new LinkedHashSet<>();
        /*String str;
        Integer integer;
        BigDecimal bigDecimal;

        Scanner scanner = new Scanner(System.in);

        do
        {
            System.out.print("Insert model: ");
            str = scanner.nextLine();
        }while(!new CarValidators().modelValidator(str));

        do
        {
            System.out.print("Insert price: ");
            str = scanner.nextLine();
        }while(!new CarValidators().priceValidator(new BigDecimal(str)));

        do
        {
            System.out.print("Insert mileage: ");
            str = scanner.nextLine();
        }while(!new CarValidators().mileageValidator(new Integer(str)));

        do {
            System.out.print("Insert component, write 'finish' to quit: ");
            str = scanner.nextLine();
            if (new CarValidators().componentValidator(str) && str != null){
                components.add(str);
            }
            else{
                System.out.println("Wrong validation - component");
            }
        }while (!str.equals("finish"));

        this.color = ColorEnum.WHITE;*/
    }

    public Car(String model, BigDecimal price, ColorEnum color, Integer mileage, Set<String> components) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.mileage = mileage;
        this.components = components;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Set<String> getComponents() {
        return components;
    }

    public void setComponents(Set<String> components) {
        this.components = components;
    }

    public void addComponent(String component){
        if (component != null) {
            components.add(component);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) &&
                Objects.equals(price, car.price) &&
                color == car.color &&
                Objects.equals(mileage, car.mileage) &&
                Objects.equals(components, car.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, color, mileage, components);
    }

    @Override
    public String toString() {
        return "==== Car ====" +
                "\nModel: " + model +
                "\nPrice: " + price +
                "\nColor: " + color.toString() +
                "\nMileage: " + mileage +
                "\nComponents: " + components.toString() +
                "\n=============\n";
    }
}
