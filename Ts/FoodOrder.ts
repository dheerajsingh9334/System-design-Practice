console.log("FILE LOADED");
class FoodOrder {
  private orderId: string;
  private customerName: string;
  private itmes: string[];
  private totalAmount: number;
  private isPlaced: boolean;

  constructor(orderId: string, customerName: string) {
    this.orderId = orderId;
    this.customerName = customerName;
    this.itmes = [];
    this.totalAmount = 0;
    this.isPlaced = false;
  }

  addItem(name: string, price: number): void {
    if (this.isPlaced) {
      console.log("cammpt modify a placed order");
      return;
    }
    this.itmes.push(name);
    this.totalAmount += price;
  }

  placeOrder(): boolean {
    if (this.isPlaced || this.itmes.length === 0) {
      return false;
    }
    this.isPlaced = true;
    return true;
  }
  getItemCount(): number {
    return this.itmes.length;
  }
  displayOrder(): void {
    const status = this.isPlaced ? "Placed" : "pending";
    console.log(`Order ${this.orderId} (${this.customerName} - ${status})`);
    for (const itme of this.itmes) {
      console.log(`- ${itme}`);
    }
    console.log(`total: ${this.totalAmount.toFixed(2)}`);
  }
}

const order1 = new FoodOrder("ORD-101", "Alice");
order1.addItem("Pizza", 12.99);
order1.addItem("Garlic Bread", 4.99);
order1.addItem("Coke", 2.49);
order1.placeOrder();

const order2 = new FoodOrder("ORD-102", "Bob");
order2.addItem("Burger", 9.99);
order2.addItem("Fries", 3.99);

order1.displayOrder();
console.log();
order2.displayOrder();
