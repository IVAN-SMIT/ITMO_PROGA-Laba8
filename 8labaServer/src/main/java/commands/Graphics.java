package commands;

import City.City;

import java.util.Iterator;
import java.util.Stack;

public class Graphics {
    public String run(String argument, Stack<City> cityCollection) throws Exception {
    try {

        if (cityCollection.size() == 0 | cityCollection == null) {
            return "В коллекции отсутствуют элементы!\n";
        }

        Iterator<City> iterator = cityCollection.iterator();

        String result ="";

        while (iterator.hasNext()) {
            City element = iterator.next();
            result = result + element.getCoordinates() + " "+ element.getArea()+"/";
        }
        return result;
    }catch (Exception e){
        System.out.println(e.getClass().getName() + e);
        System.out.println("Ошибка!");
    }
        return argument;
}

}
