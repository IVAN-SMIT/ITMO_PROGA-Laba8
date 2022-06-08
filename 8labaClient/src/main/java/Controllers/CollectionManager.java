package Controllers;

import auxillary.City;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Преобразует вот тот здоровенный текст с сервера в элементы коллекции
 * @author IVAN SMIT
 */

public class CollectionManager {



    public Stack<City> setCityCollection(String answer){

        Stack<City> cityCollection = new Stack<>();

        if (answer != null){
        String[] element = answer.split(" // ");

        int count = 0;

        while (count <element.length-1) {

            String[] fields = element[count].split(" / ");

            count = count+1;

            System.out.println(Arrays.toString(fields));
            Long id = Long.valueOf(fields[0].trim());
            String name = fields[1];
            Integer x = Integer.valueOf(fields[2].split(" ")[0]);
            Integer y = Integer.valueOf(fields[2].split(" ")[1]);
            String coord =x +" " +y;
            String localDate = fields[3];
            Long area = Long.valueOf(fields[4]);
            Long population = Long.valueOf(fields[5]);
            Long metersAboveSeaLevel = Long.valueOf(fields[6]);
            long carCode = Long.parseLong(fields[7].trim());
            String climate = fields[8];
            String standardOfLiving = fields[9].trim();
            float governor = Float.parseFloat(fields[10]);
            String username = fields[11];

            cityCollection.add(new City(id, name, coord, localDate, area, population, metersAboveSeaLevel, carCode, climate, standardOfLiving, governor, username));
        }

        return cityCollection;
    }
        return null;
    }

}
