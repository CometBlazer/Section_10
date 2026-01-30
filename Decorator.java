package Section_10;
import java.util.*;

// Component
abstract class Shape {
    public abstract void draw();
}

// Concrete Components
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

// Decorator base class
abstract class ShapeDecorator extends Shape {
    protected Shape decoratedShape;
    
    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
    
    @Override
    public void draw() {
        decoratedShape.draw();
    }
}

// Concrete Decorator: Frame
class FramedShape extends ShapeDecorator {
    private String frameStyle;
    
    public FramedShape(Shape decoratedShape, String frameStyle) {
        super(decoratedShape);
        this.frameStyle = frameStyle;
    }
    
    @Override
    public void draw() {
        decoratedShape.draw();
        drawFrame();
    }
    
    private void drawFrame() {
        System.out.println("Drawing " + frameStyle + " frame around shape");
    }
}

// Usage
public class Decorator {
    public static void main(String[] args) {
        Shape circle = new Circle(100, 100, 50);
        Shape rectangle = new Rectangle(200, 150, 80, 60);
        
        Shape framedCircle = new FramedShape(circle, "solid");
        Shape framedRectangle = new FramedShape(rectangle, "dashed");
        
        Shape doubleFramedCircle = new FramedShape(framedCircle, "thick");
        
        System.out.println("Circle:");
        circle.draw();
        
        System.out.println("\nFramed Circle:");
        framedCircle.draw();
        
        System.out.println("\nDouble Framed Circle:");
        doubleFramedCircle.draw();
        
        System.out.println("\nFramed Rectangle:");
        framedRectangle.draw();
    }
}
