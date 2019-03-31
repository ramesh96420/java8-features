package com.java.techie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachAndFilterMethods {

	public static void main(String args[]) {

		/* List object printing in displaying using stream methods */
		List<String> listOfStringValues = new ArrayList<>();
		listOfStringValues.add("Ramesh");
		listOfStringValues.add("Sam");
		listOfStringValues.add("Jam");
		listOfStringValues.add("Jim");

		/* Using normal for method */
		for (String list : listOfStringValues) {
			System.out.println(list);
		}
		System.out.println();
		listOfStringValues.stream().forEach(list -> System.out.println(list));
		System.out.println();

		/* Using filter method who name is Ramesh */
		listOfStringValues.stream().filter(l -> l.equals("Ramesh"))
				.forEach(x -> System.out.println("The name is " + "" + x));
		System.out.println();

		/* Who name is start with J later */
		listOfStringValues.stream().filter(l -> l.startsWith("J"))
				.forEach(x -> System.out.println("Who name start with J letter " + x));
		System.out.println();

		/* Which name contains "am" charectors that names is printing */
		listOfStringValues.stream().filter(l -> l.contains("am"))
				.forEach(x -> System.out.println("Who is contains am charectors " + x));
		System.out.println();

		/* Map object printing in displaying using stream methods */
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");

		/* Using normal methods */
		System.out.println("Normal method");
		map.forEach((key, value) -> System.out.println(key + ":" + value));

		/* Using stream forEach method */
		System.out.println("stream methods");
		map.entrySet().stream().forEach(obj -> System.out.println(obj));
	}

}
