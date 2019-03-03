package com.streams;

import java.util.Arrays;
import java.util.List;

/*
 * @authorized by Rameshbabu
 * */

/*
 * Predicate functional interface. It return something. But it expect true/false value
 * Consumer functional interface. It doesn't return anything. The return type is void.
 * filter() we are using condition based
 * forEach() we are using printing based and It is Terminal operation
 * */
public class FilterExamples {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
		
		//Imperative Style
		for (String name : names) {
			if(!name.equals("Sam")){
				System.out.println(name);
			}
		}
		System.out.println(".................");
		System.out.println();
		
		//Functional Style using Streams API
		
		//name is not equals to Greg
		//start function
		names.stream()
			.filter(name -> !name.equals("Greg"))	//Predicate functional interface. 
			.forEach(System.out::println);			//Consumer functional interface. 
		//end function
		
		System.out.println(".................");
		System.out.println();
		
		
		
		//name is not equals to Sam
		//start function
		names.stream()
			//.filter(name -> isNotSam(name))
			.filter(FilterExamples::isNotSam)
			.forEach(System.out::println);
			
		}
		private static boolean isNotSam(String name) {
			return !name.equals("Ryan");
		}
		
		//end function

}
