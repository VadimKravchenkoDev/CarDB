package com.example.cardb;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import Data.DatabaseHandler;
import Model.Car;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        Log.d("carsCount", String.valueOf(databaseHandler.getCarsCount()));
   /*     databaseHandler.addCar(new Car("Toyota", "30000"));
        databaseHandler.addCar(new Car("Opel", "20000"));
        databaseHandler.addCar(new Car("BMW", "50000"));
        databaseHandler.addCar(new Car("Mercedes", "50000"));
        databaseHandler.addCar(new Car("Hyundai", "50000"));*/
        List<Car> carList = databaseHandler.getAllCars();


        /*Car deletingCar = databaseHandler.getCar(7);
        databaseHandler.deleteCar(deletingCar);*/
        for (Car car : carList) {
            Log.d("Car Info", "ID " + car.getId() + " name " + car.getName() +
                    ", price" + car.getPrice());
        }
       /* Car car = databaseHandler.getCar(1);

        car.setName("Tesla");
        car.setPrice("55000");
        int updateCarId = databaseHandler.updateCar(car);

        Log.d("Car Info", "ID " + car.getId() + ", name " + car.getName() +
                ", price " + car.getPrice() + " updateCarId " + updateCarId);*/


    }
}