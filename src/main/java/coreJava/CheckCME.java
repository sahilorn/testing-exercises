package coreJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CheckCME {


    public static void main(String[] args) {

        ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>();
        hm.put("a1", "a2");
        hm.put("b1", "b2");

        List<String> iteratedKeys = new ArrayList<>();
//        for(int key : hm.size()){
//            iteratedKeys.add(key);
//            String value = hm.get(key);
//            hm.remove(key);
//            hm.put(value,key);
//
//       }
        for (String key : hm.keySet()) {
            //iteratedKeys.add(key);
            String value = hm.get(key);
            hm.remove(key);
            hm.put(value, key);

        }

//        for(int i=0;i<hm.size();i++){
//                        iteratedKeys.add(hm.);
//            String value = hm.get(key);
//            hm.remove(key);
//            hm.put(value,key);
//        }

        for (String key : hm.keySet()) {
            System.out.println(key + "-->" + hm.get(key));
        }

//        for(String key: iteratedKeys){
//            hm.remove(key);
//        }
//        for(String key : hm.keySet()){
//            System.out.println( key + "-->" + hm.get(key));
//        }

    }


}
