import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private String orderStatus;
    private int customerID;
    private List<Buket> orderItems;
    private LocalDate ld;

    public Order(int customerID, LocalDate ld) {
        this.customerID = customerID;
        this.orderItems = new ArrayList<>();
        this.ld = ld;
        this.orderStatus = "CREATED";
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void addBuketToOrder(Buket buket) {
        orderItems.add(buket);
    }

    public void setOrderStatus(String status) {
        this.orderStatus=status;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public int getCustomerID() {
        return customerID;
    }

    public List<Buket> getOrderItems() {
        return orderItems;
    }

    public LocalDate getLd() {
        return ld;
    }
}
