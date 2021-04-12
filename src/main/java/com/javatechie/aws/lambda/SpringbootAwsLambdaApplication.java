package com.javatechie.aws.lambda;

import com.javatechie.aws.lambda.domain.Order;
import com.javatechie.aws.lambda.respository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootAwsLambdaApplication {


    //first we want to return all the order object
    @Autowired
    private OrderDao orderDao;


    //retun all the data from repository
    //Supplier is dont have any argument and it don't have return type
    @Bean
    public Supplier<List<Order>> orders() {

        //lambda representation of method
        return () -> orderDao.buildOrders();
    }

    //based on the ruturn input it will filter list and it will return the object
    @Bean
    public Function<String, List<Order>> findOrderByName() {
        return (input) -> orderDao.buildOrders().stream().filter(order -> order.getName().equals(input)).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
    }

}
