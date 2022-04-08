package com;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.*;

public class Automate_Template {
    public static final String HUB_URL = "https://hub-cloud.browserstack.com/wd/hub";
    private WebDriver driver;

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Test
    public void test(){
        Integer[]  arr = new Integer[] {1,2,5,7,8,1,4,5,8,5};
        int count=1;
        List<Integer> repeatingNumbers = new ArrayList<>();
        List<Integer> nonRepeatingNumbers = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            //System.out.println("K:V :: "+entry.getKey()+":"+entry.getValue());
            if (entry.getValue()>1){
                repeatingNumbers.add(entry.getKey());
            }else {
                nonRepeatingNumbers.add(entry.getKey());
            }
        }
        System.out.println("Repeating integers in the array :: "+repeatingNumbers);
        System.out.println("Non Repeating Integers "+nonRepeatingNumbers);

    }

}
