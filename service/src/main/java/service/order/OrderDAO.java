package service.order;

import java.util.ArrayList;

public interface OrderDAO {

	//метод для получения списка заказов, которые не успевает доставить курьер (отложенные)
	ArrayList<PostponedOrder> getAllPostponedOrders();
	
	//метод для добавления заказа в список отложенных
	boolean addPostponedOrder(int number);

}