package com;

import java.util.*;
import java.util.stream.Collectors;

public class Experiment {
    private static void commonElementsInArrayUsingCollectionsAndSet(int[] intArray)  {
        //Integer[] integers = intArray;
        Set<Integer> intSet = new HashSet<>();
        Set<Integer> commonElementsList = new HashSet<>();
        for (int i = 0; i < intArray.length; i++) {

            if(intSet.add(intArray[i])) {

            }else {
                commonElementsList.add(intArray[i]);
            }
        }
        List<Integer> list = new ArrayList<>(intSet);
        System.out.println("Unique elements before sort: "+list);
        Collections.sort(list);
        System.out.println("Unique elements after sort: "+list);
        System.out.println("Common Elemets are: "+commonElementsList);
    }

    private static void repeatingElementsInArray(int[] array) {
        //Integer[] intArray = array;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<array.length;i++) {
            int count =1;
            if(!list.contains(array[i])) {
                list.add(array[i]);
                for(int j=i+1;j<array.length;j++) {
                    if(array[j] == array[i]) {
                        count++	;
                    }

                }
                System.out.println(array[i]+" is repeated "+count+" times");
            }
        }
    }

    public static void commonElementsInStringAndPrintMaximumOccuredCharacterAskedInGTENTechnologies(String string){
        char[] c = string.replace(" ","").toLowerCase().toCharArray();
        List<Character> list = new ArrayList<>();
        Map<Integer,Character> map = new HashMap<>();
        int count =1;
        for (int i =0; i<c.length;i++){
            if (!list.contains(c[i])){
                list.add(c[i]);
                for(int j=i+1;j<c.length;j++){
                    if (c[i] == c[j]){
                        count++;
                    }
                }
                map.put(count,c[i]);
                System.out.println(c[i]+" repeating "+count+" times");
                count =1;
            }
        }
        int maxvalue =0;
        for (Map.Entry<Integer,Character> entry:map.entrySet()){
            if(entry.getKey()>maxvalue){
                maxvalue = entry.getKey();
            }
        }
        System.out.println("*****************************************************");
        System.out.println(map.get(maxvalue)+" is repeated max no. of times"+" i.e, "+maxvalue);
    }

    private static void maximumOccuringCharaterInString(String string) {
        char[] c = string.toLowerCase().replaceFirst(" ", "").toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : c) {
            int count =1;
            if(!map.containsKey(ch)) {
                map.put(ch, count);
            }else {
                map.put(ch, map.get(ch)+1);
            }
        }
        System.out.println(map);
        int maxCount=0;
        char maxOccuredCharacter = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {

            if(entry.getValue()>maxCount) {
                maxCount = entry.getValue();
                maxOccuredCharacter = entry.getKey();
            }

        }

        System.out.println(maxOccuredCharacter+" is occured maximum number of times");
    }

    private static void commonElementsInStringUsingMap(String string){
        char[] chars = string.replaceAll("\\s","").toLowerCase().toCharArray();
        Map<Character,Integer>  map = new HashMap<>();
        for (char c : chars){
            if (!map.containsKey(c)){
                map.put(c,1);
            }else {
                map.put(c,map.get(c)+1);
            }
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+" is repeated "+entry.getValue()+" times");
        }

    }

    public static void countNumberOfTimesOneIsRepeatedBetween1To9999(){
        int temp, count =0;
        for (int i = 0; i<=9999;i++){
            int temp2 = i;
            while (temp2>0){
                temp = temp2%10;
                if (temp == 1){
                    count++;
                }
                temp2 = temp2 /10;
            }
        }
        System.out.println("One is repeated "+count+" times");
    }

    public static void java_8_features(){
        List<Integer> list = Arrays.asList(11,2,1,4);
        List mappedLList = list.stream().map(n->n*2).collect(Collectors.toList());

        System.out.println(mappedLList);

        List<Integer> filteredList = list.stream().filter(g->g%2==0).collect(Collectors.toList());
        System.out.println(filteredList);

        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        //The collect method is used to return the result of the intermediate operations performed on the stream.
        Set<Integer> set = list.stream().map(n->n-1).collect(Collectors.toSet());

        //The forEach method is used to iterate through every element of the stream.
        list.stream().map(n->n+2).forEach(x-> System.out.println("Value is "+x));

        //The reduce method is used to reduce the elements of a stream to a single value.
        int a = list.stream().filter(v->v%2==0).reduce(56,(kuchBhi,filterKeBaadJoValueAayeArrayKeAnder)->kuchBhi+filterKeBaadJoValueAayeArrayKeAnder);
        // 56 is the initial value of kuchBhi variable
        System.out.println("reduce ke baad ka value is "+a);
    }

    // LEETCODE
    public boolean containsDuplicate(int[] nums) {
        for (int i=0; i< nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicateWithHashSet(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if (integerSet.add(nums[i])){

            }else {
                return true;
            }
        }
        return false;
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int i, j;
        int sum;
        for (i = 0 ; i< nums.length; i++){
            sum =nums[i];
            for (j=i+1; j<nums.length; j++){
               sum += nums[j];
               max = Math.max(sum, max);
            }
        }
        return max;
    }



    public static void main(String[] args) {
        //int[] arr = {23,4,5,7,4,9,23,5,5,5};
        //commonElementsInArrayUsingCollectionsAndSet(arr);
        //repeatingElementsInArray(arr);
       // countNumberOfTimesOneIsRepeatedBetween1To9999();
        //int a = 101/10;
       // System.out.println(a);
       // maximumOccuringCharaterInString("Missippi");
        java_8_features();
       // System.out.println(maxSubArray(new int[]{-2,2,5,-11,6}));




    }
}
