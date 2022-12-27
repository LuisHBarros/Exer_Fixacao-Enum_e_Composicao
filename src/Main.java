import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter brasilianDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate clientBirthDate = LocalDate.parse(sc.next(), brasilianDateTime);
        Client client = new Client(clientName, clientEmail, clientBirthDate);


        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(LocalDateTime.now(), status, client);

        System.out.print("How many  item to this order? ");
        int count = sc.nextInt();
        for (int i = 1; i <= count; i++){
            System.out.println("Enter #"+ "i" + "item data:");

            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            Product p = new Product(productName, productPrice);
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            OrderItem newOrder = new OrderItem(productQuantity, p);
            order.addOrderItem(newOrder);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
        sc.close();
    }
}