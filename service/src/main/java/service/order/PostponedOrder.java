package service.order;

//класс для создания объекта заказа, который курьер не успевает доставить
public class PostponedOrder {

    private final int number;
    private final String dateTime;

    public PostponedOrder(int number, String dateTime) {
        this.number = number;
        this.dateTime = dateTime;
    }

    public int getNumber() {
        return number;
    }

    public String getDateTime() {
        return dateTime;
    }
}