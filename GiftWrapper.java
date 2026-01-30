package Section_10;

// Base item interface
interface Item {
    double getPrice();
    String getDescription();
}

interface UnwrappableItem extends Item {
}

interface WrappedItem extends Item {
}

// Concrete unwrapped item
class Book implements UnwrappableItem {
    private String title;
    private double price;
    
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String getDescription() {
        return "Book: " + title;
    }
}

// Gift wrap decorator
class GiftWrap implements WrappedItem {
    private UnwrappableItem item;  // Only accepts UnwrappableItem
    private double wrappingCost = 2.50;
    
    public GiftWrap(UnwrappableItem item) {  // Compile-time constraint
        this.item = item;
    }
    
    @Override
    public double getPrice() {
        return item.getPrice() + wrappingCost;
    }
    
    @Override
    public String getDescription() {
        return item.getDescription() + " (gift wrapped)";
    }
}

// Usage
public class GiftWrapper {
    public static void main(String[] args) {
        UnwrappableItem book = new Book("The Holy Bible", 67.67);
        WrappedItem wrapped = new GiftWrap(book); 
        
        // This line won't compile - wrapped is WrappedItem, not UnwrappableItem
        // WrappedItem doubleWrapped = new GiftWrap(wrapped);
        
        System.out.println(wrapped.getDescription());
    }
}