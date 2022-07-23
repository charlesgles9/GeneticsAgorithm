package com.genetics.app;

public class Main {

	public static void main(String[] args) {
	
		//generate gene pool
		StringBuffer buffer=new StringBuffer();
		buffer.append("abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.?&@%*+-");
		
		Population population=new Population("I Love Computer Science and Algorithms.".toCharArray(),
				   200,buffer.toString().toCharArray(),0.5f);
		boolean run=true;
		while(run) {
			population.print();
			run=!population.run();
		}
		
		System.out.println("Generations: "+population.generations);
		System.out.println("Average Fitness: "+population.averageFitness+"%");
	}

}
