package models.validators;

import models.enums.ColorEnum;

import java.math.BigDecimal;
import java.util.Set;

import static models.enums.ColorEnum.BLACK;

public class CarValidators {

    public String modelValidator(String model){
        return model.matches("[A-Z]+(\\s?[A-Z]+)*") ? model : "Bad_validation_model";
    }

    public Integer mileageValidator(Integer mileage){
        return mileage >= 0 ? mileage : 0;
    }

    public BigDecimal priceValidator(BigDecimal price){
        return price.compareTo(new BigDecimal(0.0)) >= 0 ? price : new BigDecimal(0.0);
    }

    public String componentValidator(String component){

        return component.matches("[A-Z]+(\\s?[A-Z]+)*") ? component : "Bad_validation_component";
    }

    public Boolean componentsValidator(Set<String> components){
        for (String str: components ) {
            if (!str.matches("[A-Z]+(\\s?[A-Z]+)*")){
                return false;
            }
        }
        return true;
    }

    public ColorEnum getEnumByString(String str){
        for (ColorEnum color: ColorEnum.values()) {
            if (color.name().equals(str)){
                return color;
            }
        }
        return BLACK;
    }
}
