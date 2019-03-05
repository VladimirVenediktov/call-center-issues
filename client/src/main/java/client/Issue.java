package client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//класс для создания объекта "задание для call-центра"
//на основе заказа, который курьер не успевает доставить
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    private int number;
    private String dateTime;
   
    public int getNumber() {
        return number;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
    	return "Задание {заказ №"+number+", дата и время доб. задания: "+dateTime+"}";
    }
}
