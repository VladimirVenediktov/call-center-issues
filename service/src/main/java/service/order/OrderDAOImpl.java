package service.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import service.ConnectionPool;

public class OrderDAOImpl implements OrderDAO {
	private Connection connection;
	
	public OrderDAOImpl() throws SQLException {
		this.connection = ConnectionPool.getConnection();
	}
	
	@Override
	public ArrayList<PostponedOrder> getAllPostponedOrders() {
		final String SELECT_ALL_ORDERS = "SELECT * FROM POSTPONED_ORDERS";
		ArrayList<PostponedOrder> postponedOrdersList = new ArrayList<PostponedOrder>();// список отложенных заказов
		
		try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ORDERS); ResultSet rs = ps.executeQuery()){
			postponedOrdersList.clear();
			while (rs.next()) {
				int number = rs.getInt("number");
				String dateTime = rs.getString("datetime");
				postponedOrdersList.add(new PostponedOrder(number, dateTime));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return postponedOrdersList;	
	}

	@Override
	public boolean addPostponedOrder(int number) {
		
		final String ADD_POSTPONED_ORDER = "INSERT INTO POSTPONED_ORDERS (number, datetime) VALUES (?, ?)";
		boolean res = false;
		
		try(PreparedStatement ps = connection.prepareStatement(ADD_POSTPONED_ORDER)){
			ps.setInt(1, number);
			ps.setString(2, (new SimpleDateFormat("dd.MM.yy HH:mm")).format(new Date()));
			res = (ps.executeUpdate() > 0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
