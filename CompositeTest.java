package Section_10;

import java.util.*;

// Component interface
abstract class Shape {
    public abstract void draw();
}

// Leaf: Circle
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
    }
}

// Leaf: Rectangle
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
    }
}

// Composite: ShapeGroup
class ShapeGroup extends Shape {
    private List<Shape> children;
    private String name;
    
    public ShapeGroup(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    
    public void add(Shape shape) {
        children.add(shape);
    }
    
    public void remove(Shape shape) {
        children.remove(shape);
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing group: " + name);
        for (Shape child : children) {
            child.draw();
        }
    }
}

// Usage
class CompositeTest {
    public static void main(String[] args) {
        // Create individual shapes
        Circle circle1 = new Circle(50, 50, 25);
        Circle circle2 = new Circle(100, 50, 25);
        Rectangle rect1 = new Rectangle(200, 100, 100, 50);
        
        // Create a group of shapes (e.g., a smiley face)
        ShapeGroup smileyFace = new ShapeGroup("Smiley Face");
        smileyFace.add(new Circle(100, 100, 50));  // face
        smileyFace.add(new Circle(85, 90, 5));     // left eye
        smileyFace.add(new Circle(115, 90, 5));    // right eye
        
        // Create another group (e.g., a house)
        ShapeGroup house = new ShapeGroup("House");
        house.add(new Rectangle(150, 150, 100, 80));  // walls
        house.add(new Rectangle(180, 180, 40, 50));   // door
        
        // Create a top-level group containing everything
        ShapeGroup scene = new ShapeGroup("Complete Scene");
        scene.add(circle1);
        scene.add(smileyFace);
        scene.add(house);
        scene.add(rect1);
        
        // Draw the entire scene - treats groups and individual shapes uniformly
        System.out.println("Drawing Complete Scene:");
        scene.draw();
        
        System.out.println("\nDrawing Just the House:");
        house.draw();
    }
}