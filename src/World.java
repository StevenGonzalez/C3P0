/*
 * Author: Steven Gonzalez
 * Last modified: 4/2/16
 */

import java.util.Scanner;

public class World {

	public static void main(String args[]) {
		
		int generation = 1;							// To keep track of how many generations the simulation has gone through.
		int numberOfEntities = 0;					// Used to get value from user for how many Entities should be used.
		Scanner input = new Scanner(System.in);		// Scanner object to get input from the user.
		Scanner cont = new Scanner (System.in);		// Separate scanner for allowing user to press enter to continue the simulation.
		Entity entity;								// Entity used to access the next entity in the array.
		int simPlay;								// Checks how user wants to use the simulation.
		
		// Generating all the messages and names from the Entity database.
		EntityDb.generateMessages();
		EntityDb.generateNames();		
		
		// Asks user if they want to use simulation by each generation or run the whole simulation until completion.
		System.out.println("Would you like to view the simulation by generation or run the simulation until it has completed?\n"
				+ "1. By generation\n2. Until completion");
		System.out.print("Choice: ");
		simPlay = input.nextInt();
		
		if (simPlay != 1) {
			simPlay = 2;
		}
		
		//  Get number of Entities the user would like to use.
		System.out.print("Please enter the number of entities you would like to enteract with C3P0 for this simulation: ");
		numberOfEntities = input.nextInt();
		
		// Creating a CircularArray whose size is user defined and then assigning an Entity to each index.
		// Creating C3P0.
		CircularArray circArray = new CircularArray(numberOfEntities);
		C3P0 c3p0 = new C3P0();
		
		//Goes through each index and has C3P0 talk to the entity in that index.
		while (c3p0.getState() > 0 && c3p0.getState() < 100 && generation <= 1000) {
			entity = circArray.next();
			converse(c3p0, entity);
		
			// Once end of array has been reached, allow user to look at information and press enter to continue.
			if (circArray.getIndex() != 0 && circArray.isNextGeneration()) {
				
				if (simPlay == 1) {
					System.out.println("Current generation: " + generation + "\nC3P0's current state: " + c3p0.getState() + "%\n");
					System.out.print("Press enter to continue to the next generation");
					cont.nextLine();
				}
				
				// Add the the generation counter.
				generation++;
				
				// Create a new group of entities for better variety in simulation.
				circArray = new CircularArray(numberOfEntities);
			}
		}
		
		// Output the end results of the simulation including total generations and C3P0's state.
		System.out.println("Simulation made it though " + generation + " generations.");
		
		int temp = c3p0.getState();
		
		if (temp < 0) {
			temp = 0;
		}
		else if (temp > 100) {
			temp = 100;
		}
		
		System.out.println("C3P0's final state was: " + temp + "%");		
		
		// Closing scanner object because it is courteous.
		input.close();
		cont.close();
	}
	
	//This function uses the speak() and listen() function to handle the interactions the two Entities have with each other.
	public static void converse (Entity ent1, Entity ent2) {
		ent1.speak();
		ent2.listen(ent1.getMessageType());
		ent2.speak();
		ent1.listen(ent2.getMessageType());
		System.out.println("----------------------------------------\n");
	}
}
