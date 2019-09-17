package Business.CustomerAccount;
import Business.Cart.CartDirectory;
import Business.Customer.Customer;
import Business.Order.OrderDirectory;
import Business.Review.ReviewDirectory;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

public class CustomerAccount {
    private String username;
    private String password;
    private Customer customer;
    private Role role;
    private WorkQueue workQueue;
    private CartDirectory cartDirectory;
    private OrderDirectory orderDirectory;
    private ReviewDirectory reviewDirectory;

    

    public CartDirectory getCartDirectory() {
        return cartDirectory;
    }

    public void setCartDirectory(CartDirectory cartDirectory) {
        this.cartDirectory = cartDirectory;
    }

    public CustomerAccount() {
        workQueue = new WorkQueue();
        cartDirectory = new CartDirectory();
        orderDirectory = new OrderDirectory();
        reviewDirectory = new ReviewDirectory();
    }

    public ReviewDirectory getReviewDirectory() {
        return reviewDirectory;
    }

    public void setReviewDirectory(ReviewDirectory reviewDirectory) {
        this.reviewDirectory = reviewDirectory;
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Role getRole() {
        return role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    @Override
    public String toString() {
        return  username ;
    } 
    
     
}
