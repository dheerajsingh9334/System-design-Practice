import java.util.ArrayList;
import java.util.List;

class FoodOrder{
    private String orderId;
    private String customerName;
    private  List<String> items;
   private double  totalAmount;
   private boolean isPlaced;


   public FoodOrder(String orderId,String customerName){
    this.orderId = orderId;
    this.customerName = customerName;
    this.items = new ArrayList<>();
    this.totalAmount = 0;
    this.isPlaced = false;
   }

public void addItems(String name, double price){
    if(isPlaced){
        System.out.println("Cannot modify a placed order");
        return;
    }
    items.add(name);
    totalAmount += price;
}

public boolean PlaceOrder(){
    if(isPlaced || items.isEmpty()){
        return false;
    }
    isPlaced = true;
    return  true;
}
public int getItemCount(){
    return items.size();
}

public void displayOrder(){
    String status = isPlaced ? "Placed":"Pending";
     System.out.println("Order " + orderId + " (" + customerName + ") - " + status);
        for (String item : items) {
            System.out.println("  - " + item);
        }
        System.out.printf("  Total: $%.2f%n", totalAmount);
}
}
public class FoodApp {
    public static void main(String[] args) {
        FoodOrder order1 = new FoodOrder("ORD-101", "Alice");
        order1.addItems("Pizza", 12.99);
        order1.addItems("Garlic Bread", 4.99);
        order1.addItems("Coke", 2.49);
        order1.PlaceOrder();

        FoodOrder order2 = new FoodOrder("ORD-102", "Bob");
        order2.addItems("Burger", 9.99);
        order2.addItems("Fries", 3.99);
        // Bob hasn't placed his order yet

        order1.displayOrder();
        System.out.println();
        order2.displayOrder();
    }
}