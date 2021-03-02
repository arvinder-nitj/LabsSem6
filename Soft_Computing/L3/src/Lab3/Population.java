package Lab3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Population {
	private Individual population[];
	private double populationFitness = -1;

	public Population(int populationSize) {
		this.population = new Individual[populationSize];
	}

	public Population(int populationSize, int chromosomeLength) {
		this.population = new Individual[populationSize];

		// Create each individual in populaton
		for (int individualCount = 0; individualCount < populationSize; individualCount++) {
			Individual individual = new Individual(chromosomeLength);
			this.population[individualCount] = individual;
		}
	}

	public Individual[] getIndividuals() {
		return this.population;
	}

	/**
	 * Find an individual in the population by its fitness
	 * 
	 * @param offset
	 *            The offset of the individual you want, sorted by fitness. 
     *            0 is the strongest, 
     *            population.length - 1 is the weakest.
	 * @return individual Individual at offset
	 */
	public Individual getFittest(int offset) {
		// Order population by fitness
		Arrays.sort(this.population, new Comparator<Individual>() {
			@Override
			public int compare(Individual o1, Individual o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});

		return this.population[offset];
	}


	public void setPopulationFitness(double fitness) {
		this.populationFitness = fitness;
	}
	public double getPopulationFitness() {
		return this.populationFitness;
	}
	public int size() {
		return this.population.length;
	}

    public Individual setIndividual(int offset, Individual individual) {
		return population[offset] = individual;
	}

	public Individual getIndividual(int offset) {
		return population[offset];
	}
	
	/**
	 * Shuffles the population in-place
	 * 
	 * @param void
	 * @return void
	 */
	public void shuffle() {
		Random rnd = new Random();
		for (int i = population.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Individual a = population[index];
			population[index] = population[i];
			population[i] = a;
		}
	}
}