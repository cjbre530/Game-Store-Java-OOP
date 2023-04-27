/**
 * Assignment #11:
 * Name: Cameron Brethauer 
 * StudentID: 1224723136
 * Lecture: TThu 10:30AM
 * Description: This class creates the "Game" object to be used in the ZyBoxLiveStore class, and make the
 * program work as intended.
 */

public class Game {
	// Declare instance variables
	private String name;
	private String description;
	private double price;
	private int downloads;

	// Define constructor
	public Game(String name, String description, double price, int downloads) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.downloads = downloads;
	}

	// Define accessor methods
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getDownloads() {
		return downloads;
	}

	// Define string representation of Game objects
	@Override
	public String toString() {
		return name + "\n" + description + "\nZyBox Price: $" + String.format("%.2f", price) + "\n" + downloads
				+ " downloads\n";
	}
}