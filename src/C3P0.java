/*
 * Author: Steven Gonzalez
 * Last modified: 4/2/16
 */

// Class C3P0 uses all the same values and methods that the Entity class does.
// C3P0 needs to start with different values as he is the protagonist of this program.
// See Entity class for more information.
public class C3P0 extends Entity {
	
	// Sets C3P0's state to 0.18, it's type to ROBOT, and it's name to C3P0.
	public C3P0() {
		super(18, Type.ROBOT,"C3P0", 1000);
	}
}
