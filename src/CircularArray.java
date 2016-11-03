/*
 * Author: Steven Gonzalez
 * Last modified: 4/2/16
 */

// This class replicates the behavior of a circular array.
// It can go through each index of the array and then if it reaches the end,
// it's index will restart at the beginning.
public class CircularArray {
	
	private Entity arr[];			// Entity array used to store 'arrSize' number of Entities.
	private int index;				// Keep track of the current index in the array.
	private static int id = 1001;	// Insure each entity gets a unique ID.
	
	// CircularArray constructor that initializes size to user defined size.
	public CircularArray(int arrSize) {
		arr = new Entity[arrSize];
		assignEntityToIndex();
		index = -1;
	}
	
	// This function goes through each index of the Entity array and assigns an Entity.
	private void assignEntityToIndex() {
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Entity(id);
			id++;
		}
	}
	
	// Go to the next entity in the array.
	public Entity next() {
		index++;
		return arr[index % arr.length];
	}
	
	// Check if we have gone through the entire array, if so return true.
	public boolean isNextGeneration() {
		return ((index + 1) % arr.length == 0);
	}
	
	// Getters
	public int getIndex() {return index;}
	
	public int getSize() {return arr.length;}
}
