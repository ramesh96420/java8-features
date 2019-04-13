package com.optionals;

import java.util.Optional;

public class OptionalExample1 {

	public static void main(String[] args) {
		/* Optional use cases. */
		/* Create the Optional Object. */
		Optional<String> optionalString = Optional.empty();
		System.out.println("Optional Object " + optionalString);

		/* Normal way to check the null values */
		String book = null;
		if (book != null) {
			System.out.println("book object " + optionalString);
		} else {
			book = "Java";
			System.out.println(book.toUpperCase());
		}

		/* Using Optional to check the null values */
		String book2 = "java";
		optionalString = Optional.ofNullable(book2);
		System.out.println(optionalString.get().toUpperCase());

		/* Using Optional to check the null values with orElse() method using */
		String book1 = null;
		optionalString = Optional.ofNullable(book1);
		System.out.println(optionalString.orElse("ramesh").toUpperCase());
	}
}
