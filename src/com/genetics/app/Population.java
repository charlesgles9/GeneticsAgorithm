package com.genetics.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Population implements Comparator<Gnome>{

	
	private char[]target;
	private int max;
	private char[]pool;
	private Gnome[]array;
	private Random rand= new Random();
	private float mutationRate;
	public int generations=0;
	public int averageFitness=0;
	
	public Population(char[]target,int max,char[]pool,float mutationRate) {
		this.target=target;
		this.max=max;
		this.pool=pool;
		this.array=new Gnome[max];
		this.mutationRate=mutationRate;
		initialize();
	}

	@Override
	public int compare(Gnome a, Gnome b) {
		if(a.fitness>b.fitness)
			return 1;
		else if(a.fitness<b.fitness)
			return -1;
		return 0;
	}
	
	public void sort() {
		Arrays.sort(array,this);
	}
	
	public boolean run() {
		for(Gnome gnome:array)gnome.calculateFitness();
		//spreads our data evenly for fair results
		// takes a lot of time(infinity) to compute for non-sorted population
		sort();
		ArrayList<Gnome>new_population=new ArrayList<>();
		// breed 50% of the population at random
		for(int i=0;i<max/2;i++) {
			Gnome husband=array[rand.nextInt(max-1)];
			Gnome waifu=array[rand.nextInt(max-1)];
			Gnome child=husband.crossOver(waifu);
			new_population.add(child);
			// apply mutation to this kid hopefully he/she will
			// become better than dumb parent
			// this is why in breeding is discouraged 
			if(rand.nextDouble()<=mutationRate) {
				child.mutate();
			}
		}
		//replace 50% of the old population with the new breed
		//also check if we found our target gene
		boolean found=false;
		//helps us get he average fitness
		// it enables to gauge how well the algorithm works
		float sum=0f;
		 for(int i=0;i<new_population.size();i++) {
			 Gnome child=new_population.get(i);
			  array[i]=child;    
			  found=child.equals(target);
			  child.calculateFitness();
			  sum+=child.fitness;
		 }
		 
		 averageFitness=(int)(sum/new_population.size()*100);
		 generations++;
		 return found;
	}
	
	private void initialize() {
		for(int i=0;i<max;i++) {
			array[i]=new Gnome(target,pool);
		}
	}
	
	public void print() {
		int index=0;
		for(Gnome gnome:array) {
			System.out.print(index+" fitness: "+gnome.fitness+" ");
			gnome.print();
			System.out.println();
			index++;
			
		}
	}
}
