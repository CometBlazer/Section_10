package Section_10;

import java.util.*;

// Abstract Shape class
abstract class Shape {
    public abstract void draw();
}

// Concrete shapes
class Circle extends Shape {
    private int x, y, radius;
    
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing circle at (" + x + "," + y + ") with radius " + radius);
        // graphics.drawCircle(x, y, radius); NOT IMPLEMENTED
    }
}

class Rectangle extends Shape {
    private int x, y, width, height;
    
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing rectangle at (" + x + "," + y + ") with size " + width + "x" + height);
        // graphics.drawRectangle(x, y, width, height); NOT IMPLEMENTED
    }
}

// Main drawing application
class DrawingProgram {
    private List<Shape> shapes;
    
    public DrawingProgram() {
        shapes = new ArrayList<>();
    }
    
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    
    // Method called on each screen refresh
    public void refreshScreen() {
        for (Shape shape : shapes) {
            shape.draw();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        DrawingProgram program = new DrawingProgram();
        
        program.addShape(new Circle(100, 100, 50));
        program.addShape(new Rectangle(200, 150, 80, 60));
        program.addShape(new Circle(300, 200, 30));
        
        program.refreshScreen();
    }
}