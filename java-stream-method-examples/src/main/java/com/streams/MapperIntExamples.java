package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
 * */

public class MapperIntExamples {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
		
		//Imperative Style
		System.out.println("Imperative Style");
		System.out.println("Name is not equals Sam");
		for (String name : names) {
			if(!name.equals("Sam")){
				User user = new User(name);
				System.out.println(user);
			}
		}
		System.out.println(".................");
		System.out.println();
		
		
		/*
		 * Functional Style using Streams API
		 * name is not equals to Greg
		 * 
		 * */		
		
		System.out.println("Functional Style");					
		//start function
		System.out.println("Name is not equals Greg");
		names.stream()
			.filter(name -> !name.equals("Greg"))	//Check the condition the name is equals to "Greg" or not
			/*.map(new Function<String, User>() {

				@Override
				public User apply(String name) {
					User user = new User(name);
					return user;
				}
			})*/
			
			//.map(name ->  new User(name))
			.map(User::new)							//map() we are using to convert String type Object into User type Object.
			.forEach(System.out::println);			//Print the User object
		//end function
		
		System.out.println(".................");
		System.out.println();
		
		
		
		/*
		 * Functional Style using Streams API
		 * name is not equals to Ryan
		 * 
		 * */
						
		//start function
		System.out.println("Name is not equals Ryan");
		names.stream()
			//.filter(name -> isNotSam(name))
			.filter(MapperIntExamples::isNotSam)		//Check the condition the name is equals to "Ryan" or not
			/*.map(new Function<String, User>() {

				@Override
				public User apply(String name) {
					User user = new User(name);
					return user;
				}
			})*/
			
			//.map(name ->  new User(name))
			.map(User::new)							//map() we are using to convert String type Object into User type Object.
			.forEach(System.out::println);			//Print the User object
			
		
		
		System.out.println();
		System.out.println("Convert String into User object and return that User object into List of User objects");
	 //another stream operation
		List<User> userList =names.stream()
			.filter(MapperIntExamples::isNotSam)		//Check the condition the name is equals to "Ryan" or not
			.map(User::new)							//map() we are using to convert String type Object into User type Object.
			.collect(Collectors.toList());			//It is converting User object into List type and return the User object into List.
		System.out.println(userList);
		
		
		int sum = userList.stream()
			  //.mapToInt(user -> user.getAge())	//is return use age.
				.mapToInt(User::getAge)				//is return use age.
				.sum();								//sum() method sum the all user ages and return the total age
		System.out.println("Sum of the user age "+sum);
	}
	
	
		private static boolean isNotSam(String name) {
			return !name.equals("Ryan");
		}
		
		//end function
		
		
		
		
		
		
	//User Model Object
	static class User{
		
		private String name;
		private Integer age = 10;
		
		
		public User(String name) {
			this.name = name;
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

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}
		
		
	}

}
