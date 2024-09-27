package com.collection;

import javax.imageio.ImageTranscoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap hm=new HashMap();
        hm.put(109,"Pratham");
        hm.put(459,"Ekal");
        hm.put(134,"Mihir");
        hm.put(908,"Chirag");

        System.out.println(hm);
        System.out.println(hm.get(459));
        System.out.println(hm.keySet());
        System.out.println(hm.values());
        System.out.println(hm.entrySet());


        Set set=hm.entrySet();
        Iterator itr=set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
