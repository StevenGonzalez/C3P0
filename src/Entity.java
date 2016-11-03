/*
 * Author: Steven Gonzalez
 * Last modified: 4/2/16
 */

import java.util.concurrent.ThreadLocalRandom;

public class Entity {
	private int idNum;			// An ID number for each Entity.
	private int state;			// Int whose value 0 - 100 is used as percentage for current state of an Entity.
	private State messageType; 	// Used to check if the message will be positive, negative or neutral.
	private Type type;			// Type the Entity can be.
	private String name;		// The Entities name.
	private int override;		// Used to keep track if Entity is in positive or negative override.
	
	// Constructor for default entities.
	// Sets their state to a random number between1 0 and 1.	
	public Entity (int i) {
		state = randomWithRange(10, 90);
		type = Type.values()[(int)(Math.random() * 5)];
		name = EntityDb.getRandName(type);
		idNum = i;
		override = 0;
		setMessageType(state);
	}
	
	// Constructor for C3P0.
	// Sets it's state to 0.18, type to ROBOT, and name to C3P0. 
	public Entity (int s, Type t, String n, int i) {
		state = s;
		type = t;
		name = n;
		idNum = i;
		override = 0;
		setMessageType(state);
	}
	
	// Getters
	public int getIdNum() { return this.idNum; }
	
	public int getState () {return state;}
	
	public String getName () {return name;}
	
	public State getMessageType () {return messageType;}
	
	// This function will grab the entity's name, a random message depending on the Entities
	// current mood, ID number and then output that message.
	public State speak() {		
		
		System.out.println("Hello, I am " + this.getName() + ", my ID number is " + this.getIdNum() + ".\nMy current state is " 
		+ this.getState() + "%\n" + EntityDb.getMessage(type, messageType) + "\n");
		return messageType;
	}
	
	// This function first evaluates if the message that was said to the Entity is positive, negative, or neutral.
	// If it was positive, add or subtract a random value from 0.03 (3%) up to 0.05 (5%) to the Entities mood respectively.
	// If it was neutral, and or subtract a random value from 0.01 (1%) up to 0.03 (3%) to the Entities mood respectively.
	// Also if Entity is 80% or higher, ignore first 5 negative messages. If state is 30% or lower, ignore first 5 positive messages.
	public void listen(State mt) {
		int mood = 0;
		State previousMood = messageType;
		
		switch (mt) {
			case POSITIVE:
				if (messageType == State.NEGATIVE) {
					override++;
					
					if (override > 3) {
						mood = ThreadLocalRandom.current().nextInt(1, 5);
					}
				}
				else {
					mood = ThreadLocalRandom.current().nextInt(1, 5);
				}				

				break;
				
			case NEUTRAL:
				// Create random negative or positive value to give the game more possible endings.
				int randNum = ThreadLocalRandom.current().nextInt(0, 1);
				
				if (randNum == 0) {
					mood = ThreadLocalRandom.current().nextInt(0, 1);
				}
				else {
					mood = ThreadLocalRandom.current().nextInt(0, 1) * -1;
				}
				
				break;
				
			case NEGATIVE:
				if (messageType == State.POSITIVE) {
					override++;
					
					if (override > 3) {
						mood = ThreadLocalRandom.current().nextInt(1, 5) * -1;
					}
				}
				else {
					mood = ThreadLocalRandom.current().nextInt(1, 5) * -1;
				}
	
				break;
		}
		
		// Entities state gets the value of mood from the case statement.
		state += mood;
		setMessageType(state);
		
		// If Entity enters a different state then set override back to 0.
		if (messageType != previousMood) {
			override = 0;
		}
	}
	
	// Setting messageType to Positive, Negative, or Neutral respectively.
	private void setMessageType(int s) {
		if (s >= 70) {
			messageType = State.POSITIVE;
		}
		else if (s <= 30) {
			messageType = State.NEGATIVE;
		}
		else {
			messageType = State.NEUTRAL;
		}
	}
	
	// This function gets a random number between the min and max number.
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
}
