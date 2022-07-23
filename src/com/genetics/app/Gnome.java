package com.genetics.app;

import java.util.Random;

public class Gnome {

	private char[] genes;
	private char[] pool;
	private char[] target;
	private Random rand= new Random();
	public float fitness;
	
	public Gnome(char[]target,char[]pool) {
		this.genes= new char[target.length];
		this.pool=pool;
		this.target=target;
        initialize();
	}
	
	// in case 2 parents decide to pass their genes to the next generation
	public Gnome(char[]genes,char[]target,char[]pool) {
		this.genes=genes;
		this.pool=pool;
		this.target=target;
	}
	
	private void initialize() {
		for(int i=0;i<genes.length;i++) {
			genes[i]=pool[rand.nextInt(pool.length-1)];
		}
	}
	
	public void calculateFitness() {
		float score=0f;
		for(int i=0;i<genes.length;i++) {
			if(target[i]==genes[i]) {
				score++;
			}
		}
		fitness=score/genes.length;
	}
	
	public void mutate() {
		genes[rand.nextInt(genes.length-1)]=
	               pool[rand.nextInt(pool.length-1)];			
	}
	
	public Gnome crossOver(Gnome waifu) {
		int half=rand.nextInt(genes.length);
		StringBuffer buffer= new StringBuffer();
		for(int i=0;i<genes.length;i++) 
			buffer.append(i<half?genes[i]:waifu.genes[i]);
		return new Gnome(buffer.toString().toCharArray(),target,pool);
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		for(char ch:genes)buffer.append(ch);
		return buffer.toString();
	}
	
	public void print() {
		System.out.println(toString());
		
	}
	
	public boolean equals(char[]object) {
		 boolean safe=true;
		 for(int i=0;i<genes.length;i++) {
			 if(genes[i]!=object[i]) {
				 safe=false;
				 break;
			 }
		 }
		return safe;
		
	}
	
	
}
