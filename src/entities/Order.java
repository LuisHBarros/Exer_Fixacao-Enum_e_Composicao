package entities;


import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private DateTimeFormatter brasilianDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(){}

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItem() {
        return items;
    }

    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeOrderItem(OrderItem item) {
        this.items.remove(item);
    }

    public Double total(){
        Double price = 0.00;
        for( OrderItem item : items){
            price += item.subTotal();
        }
        return price;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(brasilianDateTime.format(moment));
        sb.append("\nOrder status: ");
        sb.append(status);
        sb.append("\nOrder items:\n");
        for (OrderItem item : items) {
            sb.append(item);
            sb.append("\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
