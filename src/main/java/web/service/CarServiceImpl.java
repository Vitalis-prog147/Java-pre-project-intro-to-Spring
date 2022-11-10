package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

private List<Car> cars;

    {
        cars = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String brand = "Brand" + i ;
            String model = "Model" + i ;
            String color = "Color" + i ;
            cars.add(new Car(brand,model,color));
        }
    }

    public List<Car> index() {
        return cars;
    }

    @Override
    public List<Car> index(int number) {
        return cars.stream().limit(number).toList();
    }
}
