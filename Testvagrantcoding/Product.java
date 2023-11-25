import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double unitPrice;
    int quantity;
    int gstPercentage;

    public Product(String name, double unitPrice, int quantity, int gstPercentage) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.gstPercentage = gstPercentage;
    }

     double calculateGST(){
        if(gstPercentage>0){
            return unitPrice * quantity * gstPercentage;
        }
        else{
            return 0;
        }
    }

    double calculateDiscountedPrice() {
        
        if (unitPrice >= 500) {
            return unitPrice * quantity * 0.95;
        } else {
            return unitPrice * quantity;
        }
    }



    public static void main(String[] args) {
        List<Product> basket = new ArrayList<>();

        
        basket.add(new Product("Leather wallet", 1100, 1, 18));
        basket.add(new Product("Umbrella", 900, 4, 12));
        basket.add(new Product("Cigarette", 200, 3, 28)); 
        basket.add(new Product("Honey", 100, 2, 0)); // Assuming no GST for honey

        // 1. Identify the product for which we paid maximum GST amount
        double maxGST = 0;
        Product maxGSTProduct = null;

        for (Product product : basket) {
            double gstAmount = product.calculateGST();
            if (gstAmount > maxGST) {
                maxGST = gstAmount;
                maxGSTProduct = product;
            }
        }

        System.out.println("Product with maximum GST: " + maxGSTProduct.name);

       
        double totalAmount = 0;

        for (Product product : basket) {
            totalAmount += product.calculateDiscountedPrice();
        }

        System.out.println("Total amount to be paid: Rs. " + totalAmount);
    }
}