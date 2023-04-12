package com.studyDesignPattern02Factory;

/**
 * 创建一个工厂类
 */
public class ShapeFactory {
    public static Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    static class FactoryDemo{
        public static void main(String[] args) {
            ShapeFactory.getShape("CIRCLE").draw();
            ShapeFactory.getShape("RECTANGLE").draw();
            ShapeFactory.getShape("SQUARE").draw();
        }
    }
}
