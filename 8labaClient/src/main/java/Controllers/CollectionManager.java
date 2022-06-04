package Controllers;

import auxillary.City;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Stack;

public class CollectionManager {
    public Stack<City> setCityCollection(String answer){

        Stack<City> cityCollection = new Stack<>();

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
            String localDate = fields[3];
            int area = Integer.parseInt(fields[4]);
            Long population = Long.valueOf(fields[5]);
            Long metersAboveSeaLevel = Long.valueOf(fields[6]);
            long carCode = Long.parseLong(fields[7].trim());
            String climate = fields[8];
            String standardOfLiving = fields[9].trim();
            float governor = Float.parseFloat(fields[10]);
            String username = fields[11];

            cityCollection.add(new City(id, name, x, y, localDate, area, population, metersAboveSeaLevel, carCode, climate, standardOfLiving, governor, username));
        }

        return cityCollection;
    }
}
