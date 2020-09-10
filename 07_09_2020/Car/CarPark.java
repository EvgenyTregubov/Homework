import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class CarPark {
    public static void main(String[] args) {

        System.out.println("It works!");




        Stream<Car> carStream = Stream.of(
                new Car("BMW", "sedan"),
                new Car("Audi", "universal"),
                new Car("Lada", "sedan"),
                new Car("BMW", "universal"),
                new Car("Toyota", "hatchback"),
                new Car("Lada", "hatchback"),
                new Car("BMW", "sedan"),
                new Car("Audi", "hatchback"),
                new Car("Lada", "hatchback"),
                new Car("Mazda", "universal"));

        Map<String, List<Car>> carList = carStream.collect(
                Collectors.groupingBy(Car::getType));

        for (Map.Entry<String, List<Car>> item : carList.entrySet()) {

            System.out.println(item.getKey());
            for (Car car : item.getValue()) {

                System.out.println(car.getModel());
            }
            System.out.println();
        }
    }
}

class Car{
    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }
    private String model;
    private String type;

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }
}