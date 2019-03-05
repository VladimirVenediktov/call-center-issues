package service;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.order.OrderDAOImpl;
import service.order.PostponedOrder;

@RestController
public class MainController {


    @RequestMapping("/postponed")
    public ArrayList<PostponedOrder> getAllPostponedOrders() throws SQLException {
        
    	return new OrderDAOImpl().getAllPostponedOrders();
    }
    
    @RequestMapping("/add")
    public boolean addPostponedOrder(@RequestParam(value="number", required=true) int number) throws SQLException {
        
    	return new OrderDAOImpl().addPostponedOrder(number);
    }
}
