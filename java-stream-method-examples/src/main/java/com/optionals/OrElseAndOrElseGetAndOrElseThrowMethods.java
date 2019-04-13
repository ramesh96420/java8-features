package com.optionals;

import java.util.Optional;

/**
 * orElse -> Returns value when optional has no values in it orElseGet ->
 * Invockes the supplier when optional has no value in it orElseThrow -> Throws
 * the exception when optional has no value in it Optional object creating 3
 * ways using empty(), of(), ofNallable() methods
 */
public class OrElseAndOrElseGetAndOrElseThrowMethods {

	public static void main(String[] args) {
		/* Creating Optional object */
		Optional<String> optional = Optional.empty();
		System.out.println(optional);

		String name = "Oracle";
		/* Using orElse() method */
		System.out.println(optional.orElse("Java"));

		/* Using orElseGet() method */
		System.out.println(optional.orElseGet(() -> "Spring Tutorial"));

		/* Using orElseThrow() method */
		System.out.println(optional.orElseThrow(IllegalArgumentException::new));
	}

}

interface MyBookService {
	public String getBook();
}
