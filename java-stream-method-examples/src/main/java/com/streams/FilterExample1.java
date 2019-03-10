package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class FilterExample1 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Java", "Stream", null, "Filter", null);
		
		List<String> result = list.stream().filter(str -> str!=null).collect(Collectors.toList());
		
		result.forEach(System.out::println);
		
		
		List<User> users = Arrays.asList(
				new User("Peter", 20, "ra@gmail.com","Cyient" ,Arrays.asList("1", "2")),
				new User("Sam", 30,  "ma@gmail.com","HSBC" ,Arrays.asList("4", "2")),
				new User(null, 25, "za@gmail.com","Cyient" , Arrays.asList("6", "8")),
				new User("Adam", 23,  "ra@gmail.com","Cyient" ,Arrays.asList("8", "20")),
				new User("Manasa", 31,  "mana@gmail.com","Cyient" ,Arrays.asList("5", "70")),
				new User("Manasa", 33,  "ma14@gmail.com","HSBC" ,Arrays.asList("50", "70"))
				);
		
		
		
		List<Address> address = Arrays.asList(
				new Address("Kapra", 500062),
				new Address("ECIL", 500052),
				new Address("LB Nagar", 500078)
				);
		
		
		//creating two streams from the two lists and concatenating them into one
		Stream<Object> opstream = Stream.concat(users.stream(), address.stream());
		
		//displaying the elements of the concatenated stream
		opstream.forEach(System.out::println);
		
		
		
			
		
		/*
		 * Employee List by EmpName is Null
		 *  
		 * */
		
		
		List<Employee> employeeListByEmpNameNull = users.stream()
				.filter(user -> user.getName()==null)
				.map(u -> new Employee(u.getName(),
									   u.getAge(),
									   u.getEmail(),
									   u.getCompany(),
									   u.getPhoneNumbers()))
				.collect(Collectors.toList());
		
		System.out.println("Employee List by EmpName is Null: "+employeeListByEmpNameNull);
		
		/*
		 * Employee List by EmpName is NotNull
		 *  
		 * */
		List<Employee> employeeListByEmpNameNotNull = users.stream()
				.filter(user -> user.getName()!=null)
				.map(u -> new Employee(u.getName(),
									   u.getAge(),
								       u.getEmail(),
								       u.getCompany(),
								       u.getPhoneNumbers()))
				.collect(Collectors.toList());
		
		System.out.println("Employee List by EmpName is NotNull: "+employeeListByEmpNameNotNull);
		
		/*
		 * Employee information by EmpName is NotNull and Company name is Cyient
		 *  
		 * */
		
		Optional<Employee> optionalEmpInfo = users.stream()
				.filter(user -> user.getName()!=null && user.getCompany()=="Cyient")
				.map(u -> new Employee(u.getName(),
								       u.getAge(),
								       u.getEmail(),
									   u.getCompany(),
									   u.getPhoneNumbers()))
				.findAny();
		System.out.println("Employee information by EmpName is NotNull and Company name is Cyient : "+optionalEmpInfo);
		
		/*
		 * List of Employees information by EmpName is NotNull and Company name is Cyient
		 *  
		 * */
		List<Employee> listOfEmployees = users.stream()
				.filter(user -> user.getName()!=null && user.getCompany()=="Cyient")
				.map(u -> new Employee(u.getName(),
									   u.getAge(),
									   u.getEmail(),
									   u.getCompany(),
									   u.getPhoneNumbers()))
				.collect(Collectors.toList());
		System.out.println("List of Employees information by EmpName is NotNull and Company name is Cyient : "+listOfEmployees);
							
	}	
	
	
	
	
	
	//Address Model Object
	static class Address{
		
		private String areaName;
		private int pincode;
		public Address(String areaName, int pincode) {
			this.areaName = areaName;
			this.pincode = pincode;
		}
		public String getAreaName() {
			return areaName;
		}
		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		@Override
		public String toString() {
			return "Address [areaName=" + areaName + ", pincode=" + pincode + "]";
		}
		
				
	}
	
	
//User Model Object
 static class User{
	
	private String name;
	private Integer age;
	private String email;
	private String company;
	private List<String> phoneNumbers;
	
	public User(String name, Integer age, String email, String company, List<String> phoneNumbers) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.company = company;
		this.phoneNumbers = phoneNumbers;
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
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
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", company=" + company + ", phoneNumbers="
				+ phoneNumbers + "]";
	}
	
		
	
}
 
//Employee Model Object
 static class Employee{
		
	private String name;
	private Integer age;
	private String email;
	private String company;
	private List<String> phoneNumbers;
	
	public Employee(String name, Integer age, String email, String company, List<String> phoneNumbers) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.company = company;
		this.phoneNumbers = phoneNumbers;
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
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
		return "Employee [name=" + name + ", age=" + age + ", email=" + email + ", company=" + company
				+ ", phoneNumbers=" + phoneNumbers + "]";
	}
		
		
	}
}
