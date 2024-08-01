package Frontend.navbar1;

public class Product {
    String name;
    String imagePath;
    String description;
    double price;

    public Product(String name, String imagePath, String description, double price) {
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }

   /* public String getFabric() {
        return fabric;
    }

    public String getColour() {
        return colour;
    }*/

}