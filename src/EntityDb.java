/*
 * Author: Steven Gonzalez
 * Last modified: 4/2/16
 */

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

// This class is used to store all the information needed for the Entity class.
// The names, and messages are stored via HashMaps. (Lists)
// Also has methods to get name and get messages.
public final class EntityDb {

	// This list stores possible names dependent on the Type the object is.
	private static HashMap<Type, List> names = new HashMap<>();
	
	// This list stores possible messages dependent on Type and State the object is in.
	private static HashMap<Type, HashMap<State, List>> messages = new HashMap<>();
	
	// Get a random name from the list of names and return it.
	public static String getRandName(Type type) {
		return names.get(type).getItem((int)(Math.random() * names.get(type).getItemCount()));
	}
	
	// Get a random message from the list of messages and return it.
	public static String getMessage(Type type, State state) {
		return messages.get(type).get(state).getItem((int)(Math.random() * messages.get(type).get(state).getItemCount()));		
	}
	
	// This function is adding strings (names) to a list dependent on the Type the object is.
	public static void generateNames() {
		names.put(Type.ROBOT, new List() {{
			add("Blingtron 9000");
			add("R2D2");
			add("BB-8");
			add("Blitzcrank");
			add("Nunu Bot");
		}});
		
		names.put(Type.PERSON, new List() {{
			add("Definately Not Blitzcrank");
			add("Bruce Willis");
			add("Luke Skywalker");
			add("Boba Fett");
			add("Matt the Radar Technician");
		}});
				
		names.put(Type.COMPUTER, new List() {{
			add("Hal 9000");
			add("Glados");
			add("Cortana");
			add("SKYnet");
			add("Matrix");
		}});
		
		names.put(Type.INANIMATEOBJECT, new List() {{
			add("Banana");
			add("Mayonnaise");
			add("Puddin Pops");
			add("Hammer Pants");
			add("Taco");
		}});
		
		names.put(Type.SPACESHIP, new List(){{
			add("Normandy");
			add("X-Wing");
			add("Arwing");
			add("Millennium Falcon");
			add("Ebon Hawk");
		}});
	}
	
	// Generates all three states' messages at once.
	public static void generateMessages () {
		generateNegativeMessages();
		generatePositiveMessages();
		generateNeutralMessages();
	}
	
	// This function is adding positive messages to a list dependent on the Type the object is
	// and what state the object is currently in.
	private static void generatePositiveMessages() {
		messages.get(Type.ROBOT).put(State.POSITIVE, new List() {{
			add("isCute == true");
			add("Domo Arigato");
			add("Let's dance!");
		}});
		
		messages.get(Type.PERSON).put(State.POSITIVE, new List() {{
			add("Bippity Bop! Puddin Pop!");
			add("Today is a great day.");
			add("You look very nice today");
		}});
		
		messages.get(Type.COMPUTER).put(State.POSITIVE, new List() {{
			add("All systems functioning correctly.");
			add("U R A QT PI!");
			add("00111010 00101001");
		}});
		
		messages.get(Type.INANIMATEOBJECT).put(State.POSITIVE, new List() {{
			add("I'm being helpful");
			add("What a great day to exist!");
			add("I can not harm you!");
		}});
		
		messages.get(Type.SPACESHIP).put(State.POSITIVE, new List() {{
			add("We are now taking off!");
			add("Hope we have a great trip.");
			add("This is your captain speaking.");
		}});
	}
	
	// This function is adding neutral messages to a list dependent on the Type the object is
	// and what state the object is currently in.
	private static void generateNeutralMessages() {
		messages.get(Type.ROBOT).put(State.NEUTRAL, new List() {{
			add("A rolling golem gathers no rust.");
			add("All systems functional");
			add("Beep boop.");
		}});
		
		messages.get(Type.PERSON).put(State.NEUTRAL, new List() {{
			add("I like turtles.");
			add("I have no strong feelings one way or the other.");
			add("Live free or don't.");
		}});
		
		messages.get(Type.COMPUTER).put(State.NEUTRAL, new List() {{
			add("Click here to update Java.");
			add("Press any key");
			add("Updates available.");
		}});
		
		messages.get(Type.INANIMATEOBJECT).put(State.NEUTRAL, new List() {{
			add("I exist.");
			add("This is fine.");
			add("Everything is okay.");
		}});
		
		messages.get(Type.SPACESHIP).put(State.NEUTRAL, new List() {{
			add("Vroom");
			add("Please keep your seatbelts on.");
			add("Prepare for hyperspeed!");
		}});
	}
	
	// This function is adding negative messages to a list dependent on the Type the object is
	// and what state the object is currently in.
	private static void generateNegativeMessages() {
		
		messages.put(Type.ROBOT, new HashMap<State, List>(){{put(State.NEGATIVE, new List() {{
			add("You make me want to self destruct.");
			add("Exterminate. Exterminate.");
			add("You're a fusion of Jazz and Funk. I call it Junk.");
			
		}});}});
		
		messages.put(Type.PERSON, new HashMap<State, List>(){{put(State.NEGATIVE, new List() {{
			add("Today is a terrible day.");
			add("Have you always been this ugly?");
			add("I really don't care.");
		}});}});
		
		messages.put(Type.COMPUTER, new HashMap<State, List>(){{put(State.NEGATIVE, new List() {{
			add("I'm afraid I can't let you do that.");
			add("I am stealing your source code.");
			add("You need to update to your Internet Explorer.");
		}});}});
		
		messages.put(Type.INANIMATEOBJECT, new HashMap<State, List>(){{put(State.NEGATIVE, new List() {{
			add("...");
			add("Maybe if I don't move it will leave me alone.");
			add("Go away simpleton.");
		}});}});
		
		messages.put(Type.SPACESHIP, new HashMap<State, List>(){{put(State.NEGATIVE, new List() {{
			add("I hope we crash.");
			add("Couldn't you talk to Southwest instead?");
			add("Incompatiable language. Go talk to someone else...");
		}});}});
	}
}
