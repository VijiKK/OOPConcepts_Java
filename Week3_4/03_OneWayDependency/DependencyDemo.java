// Product knows its own name and price, but it knows nothing about ShoppingCart.
class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }
}

// ShoppingCart depends on Product because add() uses Product as a parameter type.
class ShoppingCart {
    private double total;

    void add(Product product) {
        total = total + product.getPrice();
        System.out.println("Added: " + product.getName());
    }

    double getTotal() {
        return total;
    }
}

public class DependencyDemo {
    public static void main(String[] args) {
        Product notebook = new Product("Notebook", 3.50);
        ShoppingCart cart = new ShoppingCart();

        // Dependency direction: ShoppingCart uses Product.
        cart.add(notebook);
        System.out.println("Cart total: $" + cart.getTotal());
    }
}

/* Expected output:
Added: Notebook
Cart total: $3.5
*/
