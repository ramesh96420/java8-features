package com.optionals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Optional use cases or Advantages:
 * 1.Better way of handling null check 
 * 2.Avoid potential NullPointerException 
 * 3.Avoid boilerplate coding 
 * 4.Clean Code & Easy to read and understand
 */
public class OptionalExamples {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		/* Normal Printing interger values in list */
		System.out.println(list.stream().filter(e -> e > 5).findFirst());

		System.out.println();
		/*
		 * Useing Optional classes for printing the integer values based on
		 * conditions
		 */
		Optional<Integer> optional = list.stream().filter(e -> e > 5).findFirst();

		if (optional.isPresent()) {
			System.out.println("Integer value " + optional.get());
		} else {
			System.out.println("Number grater than five does not exists");
		}

	}
}
