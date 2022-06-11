package commands;

import City.City;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


public class findLikeThese {
    public String run(String word, Stack<City> cityCollection){
        List<String> similarWordList = new ArrayList<>();
        List<String> allWords = new ArrayList<>();
        Iterator<City> iterator = cityCollection.iterator();
        for (City element : cityCollection) {
            allWords.add(element.getName());
        }
        for(String currentWord : allWords){
            City element = iterator.next();
            if(currentWord.contains(word)){
                similarWordList.add(String.valueOf(element));
            }
        }
        return similarWordList.toString();
    }
}

