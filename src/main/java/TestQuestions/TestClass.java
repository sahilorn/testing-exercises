package TestQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClass {

    public static void main(String[] args) {
        System.out.println(deviceNamesSystem(Arrays.asList("switch", "tv", "switch", "tv", "another")));

    }

    public static List<String> deviceNamesSystem(List<String> deviceNames) {
        List<String> uniqueDeviceNames = new ArrayList<>();
        Map<String, Integer> elementCountMap = new HashMap<>();

        for (String deviceName : deviceNames) {
            if (!elementCountMap.containsKey(deviceName)) {
                elementCountMap.put(deviceName, 1);
                uniqueDeviceNames.add(deviceName);
            } else {
                uniqueDeviceNames.add(deviceName.concat(Integer.toString(elementCountMap.get(deviceName))));
                elementCountMap.put(deviceName, elementCountMap.get(deviceName) + 1);
            }
        }
        return uniqueDeviceNames;
    }
}
