import java.util.ArrayList;

// Product class
class Product {
    private int id;
    private String name;
    private double price;
    
    // Constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    // Setters
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    
    @Override
    public String toString() {
        return "Product [ID=" + id + ", Name=" + name + ", Price=$" + price + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id;
    }
}

// Generic Cart class
class Cart<T> {
    private ArrayList<T> items;
    
    // Constructor
    public Cart() {
        items = new ArrayList<>();
    }
    
    // Add item to cart
    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item);
    }
    
    // Remove item from cart
    public boolean removeItem(T item) {
        if (items.remove(item)) {
            System.out.println("Removed: " + item);
            return true;
        } else {
            System.out.println("Item not found in cart: " + item);
            return false;
        }
    }
    
    // Display all items
    public void displayItems() {
        System.out.println("\n--- Cart Contents ---");
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
        System.out.println("Total items: " + items.size());
        System.out.println("---------------------\n");
    }
    
    // Get size
    public int getSize() {
        return items.size();
    }
}

// Main class to demonstrate functionality
public class ShoppingCartDemo {
    public static void main(String[] args) {
        // Part 1: ArrayList<Product> operations
        System.out.println("=== ArrayList<Product> Demo ===\n");
        
        ArrayList<Product> productList = new ArrayList<>();
        
        // Create at least 3 products
        Product p1 = new Product(1, "Laptop", 999.99);
        Product p2 = new Product(2, "Smartphone", 699.99);
        Product p3 = new Product(3, "Headphones", 199.99);
        Product p4 = new Product(4, "Tablet", 449.99);
        
        // ADD products
        System.out.println("Adding products to ArrayList:");
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        
        // DISPLAY products
        System.out.println("\nDisplaying all products:");
        for (Product p : productList) {
            System.out.println(p);
        }
        
        // REMOVE a product
        System.out.println("\nRemoving product: " + p2.getName());
        productList.remove(p2);
        
        // DISPLAY after removal
        System.out.println("\nAfter removal:");
        for (Product p : productList) {
            System.out.println(p);
        }
        
        // Part 2: Generic Cart<T> demonstration
        System.out.println("\n\n=== Generic Cart<T> Demo ===\n");
        
        // Create a Cart for Products
        Cart<Product> productCart = new Cart<>();
        
        // ADD items
        System.out.println("Adding items to Cart:");
        productCart.addItem(new Product(101, "Gaming Mouse", 59.99));
        productCart.addItem(new Product(102, "Mechanical Keyboard", 129.99));
        productCart.addItem(new Product(103, "Monitor", 299.99));
        
        // DISPLAY items
        productCart.displayItems();
        
        // REMOVE an item
        Product toRemove = new Product(102, "Mechanical Keyboard", 129.99);
        productCart.removeItem(toRemove);
        
        // DISPLAY after removal
        productCart.displayItems();
        
        // Demonstrate Cart with different type (String)
        System.out.println("=== Cart<String> Demo ===\n");
        Cart<String> stringCart = new Cart<>();
        stringCart.addItem("Apple");
        stringCart.addItem("Banana");
        stringCart.addItem("Orange");
        stringCart.displayItems();
        stringCart.removeItem("Banana");
        stringCart.displayItems();
        
        // Demonstrate Cart with Integer
        System.out.println("=== Cart<Integer> Demo ===\n");
        Cart<Integer> numberCart = new Cart<>();
        numberCart.addItem(100);
        numberCart.addItem(200);
        numberCart.addItem(300);
        numberCart.displayItems();
    }
}