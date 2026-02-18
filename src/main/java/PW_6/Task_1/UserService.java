package PW_6.Task_1;

class UserService { public void registerUser(String email) {} }


class ProductService { public void addProduct(String name, double price) {} }


class OrderService {
    public void createOrder(String userEmail, String productName) {}
    public void payOrder(long orderId) {}
}

class EmailService { public void sendEmail(String email, String message) {} }


class ReportService { public void exportReport(String fromDate, String toDate) {} }