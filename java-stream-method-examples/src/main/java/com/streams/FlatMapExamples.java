package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * @authorized by Rameshbabu
 * */

/*
 * Predicate functional interface. It return something. But it expect true/false value
 * Consumer functional interface. It doesn't return anything. The return type is void.
 * filter() we are using condition based
 * map() we are using to convert one type Object to another type Object or Same type Object.
 * forEach() we are using printing based and it is Terminal operation. It is stop the flow of stream.
 * collect() It return some other Object or some thing and is also another Terminal operation. It is stop the flow of stream.
 * 			 is have some default methods based on method is return that particular object
 * 			 like toList() method it return List object.
 *
 * Collectors  is library in java and is having some free defined methods.
 * sum() we are using counting purpose and is also one Terminal operation and is return some integer value.
 * mapToInt() is return always integer type.
 * findAny() is finding any value based on the above condition then stop the stream and return type is Optional.
 * flatMap() we are using this to convert one type stream to another type stream and is return type always is stream. 
 * Optional is a wrapper class is using to avoid the "NULL POINTER EXCEPTIONS"(runtime exception).
 * */

public class FlatMapExamples {

	public static void main(String[] args) {

		List<User> users = Arrays.asList(
				new User("Peter", 20, Arrays.asList("1", "2")),
				new User("Sam", 30, Arrays.asList("4", "2")),
				new User("Ryan", 25, Arrays.asList("6", "8")),
				new User("Adam", 23, Arrays.asList("8", "20"))				
				);
		
		/*
		 * Functional Style using Streams API
		 *  
		 * */
		
		/*System.out.println("Functional Style");	
		Optional<String> stringOptional= users.stream()
			.map(new Function<User, Object>(){

				@Override
				public Object apply(User user) {
					return user.getPhoneNumbers();
				}
				
			})
			.map(user -> user.getPhoneNumbers().stream())	//here inside user object having another list of phone numbers that the reason we called inside another stream
			.flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("5")))
			.findAny();									//if we find any value is 5 based on the above condition or the above condition is true than stop the Stream. 
		
		stringOptional.ifPresent(phno -> System.out.println(phno));	*/
		
		
		
		
		System.out.println("Functional Style");	
		Optional<String> stringOptional= users.stream()
			.map(user -> user.getPhoneNumbers().stream())	//here inside user object having another list of phone numbers that the reason we called inside another stream
			.flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("2")))	//is convert user object stream to phone number stream and filter and check the condition than return into stream
			.findAny();									//if we find any value is 5 based on the above condition or the above condition is true than stop the Stream. 
		
		//stringOptional.ifPresent(phno -> System.out.println(phno));		//the value is present than print the value(phone number).
		stringOptional.ifPresent(System.out::println);
		
		
		
					
	}	
	
	
//User Model Object
 static class User{
	
	private String name;
	private Integer age;
	private List<String> phoneNumbers;
	public User(String name, Integer age, List<String> phoneNumbers) {
		this.name = name;
		this.age = age;
		this.phoneNumbers = phoneNumbers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumbers=" + phoneNumbers + "]";
	}
		
	
}

}
