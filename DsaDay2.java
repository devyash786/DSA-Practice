package com.dev.dsa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DsaDay2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("India", 120);
		map.put("China",150);
		map.put("US", 30);
		
		System.out.println(map);
		
		map.put("China", 180);
		
		System.out.println(map);
		
		if(map.containsKey("China")) {
			System.out.println("It has the key and value is:"+map.get("China") );
		}
		else {
			System.out.println("It doesn't");
		}
		System.out.println("Method 1");
		for(Map.Entry<String, Integer> e: map.entrySet()) {
			System.out.println(e.getKey() + " "+ e.getValue());
		}
		System.out.println("Method 2");
		Set<String> key = map.keySet();
		
		for(String keys:key) {
			System.out.println(keys + " "+ map.get(keys));
		}
		
		//delete
		map.remove("China");
		System.out.println(map);

	}

}
