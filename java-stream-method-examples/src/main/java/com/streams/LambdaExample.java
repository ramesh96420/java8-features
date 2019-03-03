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
* forEach() we are using printing based and It is Terminal operation
* findFirst() when ever the filter() condition is true than the stream operations is stopped and it is a Terminal operation
* */
public class LambdaExample {

	public static void main(String[] args) {
		
		/**
		 * With out Using Lambda expression
		 * Imperative Style
		 * */
		System.out.println("Imperative Style with out using Lambda expression");
		Game footBall = new Game(){
			public void play(){
				
			}

			@Override
			public void paly() {

				System.out.println("play foot ball game");
			}
		};
		
		footBall.paly();
		Game cricket = new Game(){
			public void play(){
				
			}

			@Override
			public void paly() {

				System.out.println("play cricket game");
			}
		};
		cricket.paly();
		System.out.println();
		
		
		
		/**
		 * Using Lambda expression
		 * Functional Style 
		 * */
		System.out.println("Functional Style  using Lambda expression");
		Game footballLambda = () -> System.out.println("play foot ball game");
		footballLambda.paly();
		
		Game cricketLambda = () -> System.out.println("play cricket game");
		cricketLambda.paly();
		
		Series odiSeries = (type) -> System.out.println("It is a " + type +" ODI Series");
		odiSeries.play("Hoky");
		
		System.out.println();
		
		
		/*
		 * Sample code using streams and lambda expression
		 * */
		
		
		List<String> players = Arrays.asList("Sam", "Mani", "Sachin", "Nimmi","Ram","Laxmi");
		
		//Imperative Style
		boolean sachinFlag = false;
		for (String player : players) {
			if(player.equals("Sachin")){
				System.out.println("Yes, Sachin is in the this Game");
				sachinFlag = true;
			}
		}
		if(sachinFlag){
			System.out.println("Yes");
		}
		
		
		//Sample code using streams and lambda expression
		System.out.println("Stream and Lambda Expression");
		players.stream()
			.filter(player -> player.equals("Sachin"))		//Check the condition Sachiin is available are not
		  //.forEach(player -> System.out.println("Yes, Sachin is in the this Game"));			//print the Sachin name
		    .forEach(System.out::println);				//print the Sachin name
		
		
		
		Optional<String> optional = players.stream()
			.filter(player -> player.equals("Sachin"))
			.findFirst();
		if(optional.isPresent()){
			System.out.println("Yes");
		}
	}

	interface Game{
		void paly();
	}
	
	interface Series{
		void play(String type);
	}
}
