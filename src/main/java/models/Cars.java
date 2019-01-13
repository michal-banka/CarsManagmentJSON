package models;


import models.enums.SortByEnum;
import models.validators.CarValidators;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.lang.model.type.ArrayType;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class Cars extends Car{

    private List<Car> cars;

    //====================Constructors
    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String filename) {
        cars = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(filename);
            JSONArray carsArray = (JSONArray) jsonParser.parse(reader);
            carsArray.forEach(car -> cars.add(parseJSONObjectCar((JSONObject) car)));
        } catch (IOException | ParseException e) {
            System.out.println("READ FROM JSON FILE EXCEPTION");
            e.printStackTrace();
        }
    }

    //====================GETTERS AND SETTERS
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    //===================FUNCTIONS
    private static Car parseJSONObjectCar(JSONObject car)
    {
        Car carClassObject = new Car();
        JSONObject carJSONObject = (JSONObject)car.get("car");

        carClassObject.setModel(new CarValidators().modelValidator((String)carJSONObject.get("model")));
        carClassObject.setPrice(new CarValidators().priceValidator(new BigDecimal((String)carJSONObject.get("price"))));
        carClassObject.setMileage(new CarValidators().mileageValidator(new Integer((String)carJSONObject.get("mileage"))));
        carClassObject.setColor(new CarValidators().getEnumByString((String)carJSONObject.get("color")));
        JSONArray jsonArray = (JSONArray) carJSONObject.get("components");
        for (Object object : jsonArray) {
            carClassObject.components.add((String) object);
        }
        return carClassObject;
    }

    public void sort() {
        Scanner scanner = new Scanner(System.in);

    }

    public void sort(SortByEnum sortBy, boolean descending){
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                switch(sortBy)
                {
                    case PRICE:
                        if (!descending) return o1.price.compareTo(o2.price);
                        else return o2.price.compareTo(o1.price);

                    case MODEL:
                        if (!descending) return o1.model.compareTo(o2.model);
                        else return o2.model.compareTo(o1.model);
                    case MILEAGE:
                        if (!descending) return o1.mileage.compareTo(o2.mileage);
                        else return o2.mileage.compareTo(o1.mileage);
                    case COLOR:
                        if (!descending) return o1.color.name().compareTo(o2.color.name());
                        else return o2.color.name().compareTo(o1.color.name());
                }
                return 0;
            }
        });
    }

    ////====================OVERRIDE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cars);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("======== ALL CARS =======\n");
        for (Car car: cars) {
            str.append(car.toString());
        }
        return str.toString();
    }
}
