package com.DP03Behavioral.Behavioral09Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构类
 */
public class Home {

    //声明一个集合对象，用来存储元素对象
    private List<Animal> animalList = new ArrayList<>();

    //添加元素
    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void action(Person person) {
        //遍历集合，让访问者访问每一个元素
        for (Animal animal : animalList) {
            animal.accept(person);
        }
    }
}
