import models.Cars;
import models.enums.SortByEnum;

public class Main {
    public static void main(String[] args) {
        Cars cars = new Cars("D:\\Informatyka korepetycje\\Java\\Mikroservices\\Teoria\\01_PRZYKLADOWY_SYSTEM\\CarCollectionManagment\\src\\main\\resources\\jsonCars.txt");
        System.out.println(cars + "\n======================================== COLOR\n");
        cars.sort(SortByEnum.COLOR,false);
        System.out.println(cars + "\n======================================== MODEL\n");
        cars.sort(SortByEnum.MODEL,false);
        System.out.println(cars + "\n======================================== MILEAGE\n");
        cars.sort(SortByEnum.MILEAGE,false);
        System.out.println(cars + "\n======================================== PRICE\n");
        cars.sort(SortByEnum.PRICE,false);
        System.out.println(cars);
    }
}
