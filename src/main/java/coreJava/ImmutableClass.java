package coreJava;

import java.util.HashMap;

public final class ImmutableClass {

    public String getName() {
        return name;
    }

    private final int id;
    private final String name;
    private final HashMap<String, String> testMap;

    //this way we are doing shallow cloning
    public ImmutableClass(int id, String name, HashMap<String, String> testMap) {
        this.id = id;
        this.name = name;
        this.testMap = testMap;
    }
    //to do deep cloning
//    public ImmutableClass(int i,String value1, HashMap<String, String> hm) {
//        this.id = i;
//        this.value1 = value1;
//        HashMap<String,String> hmClone = new HashMap<>();
//        for(String key : hm.keySet()){
//            hmClone.put(key,hm.get(key));
//        }
//        this.hm = hmClone;
//
//    }

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String, String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i = 10;

        ImmutableClass ce = new ImmutableClass(i, s, h1);

        //Lets see whether its copy by field or reference
        System.out.println(s == ce.getName());
        System.out.println(h1 == ce.getTestMap());
        //print the ce values
        System.out.println("ce id:" + ce.getId());
        System.out.println("ce name:" + ce.getName());
        System.out.println("ce testMap:" + ce.getTestMap());
        //change the local variable values
        i = 20;
        s = "modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:" + ce.getId());
        System.out.println("ce name after local variable change:" + ce.getName());
        System.out.println("ce testMap after local variable change:" + ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:" + ce.getTestMap());

    }

    public int getId() {
        return id;
    }

    public HashMap<String, String> getTestMap() {
        return testMap;
    }
}
