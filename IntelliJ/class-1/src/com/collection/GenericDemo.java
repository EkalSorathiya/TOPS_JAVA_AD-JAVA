package com.collection;

public class GenericDemo {
    public static <E> void printArray(E[] inputArray){
        for(E e:inputArray)
        {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer intArray[]={1,2,3,4,5};
        Double doublearray[]={1.1,1.2,1.3,1.4,1.5};
        Character charArray[]={'E','K','A','L'};
        String stringArray[]={"Java","Python","C","C++"};
        printArray(intArray);
        printArray(doublearray);
        printArray(charArray);
        printArray(stringArray);
    }
}
