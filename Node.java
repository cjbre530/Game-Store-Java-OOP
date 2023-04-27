/**
 * Assignment #11:
 * Name: Cameron Brethauer 
 * StudentID: 1224723136
 * Lecture: TThu 10:30AM
 * Description: This class creates the "Node" object to be used in the ZyBoxLiveStore class, and make the
 * program work as intended.
 */

public class Node {
	// Declare instance variables
	private Game game;
	private Node left, right;

	// Define constructor
	public Node(Game game) {
		this.game = game;
		left = null;
		right = null;
	}

	// Define accessors/mutators
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
}