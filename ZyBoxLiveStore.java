/**
 * Assignment #11:
 * Name: Cameron Brethauer 
 * StudentID: 1224723136
 * Lecture: TThu 10:30AM
 * Description: This class holds all of the methods of functionality, and are later used 
 * in the main class.
 */

public class ZyBoxLiveStore {

	private Node root; // Binary Search Tree root node

	// Constructor
	public ZyBoxLiveStore() {
		this.root = null;
	}

	public Node addGameToStore(Node node, Game gameToAdd) {
		if (node == null) {
			node = new Node(gameToAdd);
		} else if (gameToAdd.getPrice() < node.getGame().getPrice()) {
			node.setLeft(addGameToStore(node.getLeft(), gameToAdd));
		} else if (gameToAdd.getPrice() > node.getGame().getPrice()) {
			node.setRight(addGameToStore(node.getRight(), gameToAdd));
		} else {
			System.out.println("Game at this price is in store inventory already.\n");
		}
		return node;
	}

	// recursive method used to count the number of games that were added to the
	// store
	public int countGamesInStore(Node node) {
		if (node == null) {
			return 0;
		} else {
			int countLeft = countGamesInStore(node.getLeft());
			int countRight = countGamesInStore(node.getRight());
			return countLeft + countRight + 1;
		}
	}

	// method used to list all of the games by price value
	public void listGamesByPrice(Node node) {
		if (node != null) {
			listGamesByPrice(node.getLeft());
			System.out.println(node.getGame());
			listGamesByPrice(node.getRight());
		}
	}

	// * removeGameFromStore(...) METHOD PROVIDED AS PART OF TEMPLATE
	// Removes a game from the BST based on the game's price (the BST key)
	public Node removeGameFromStore(Node node, double price) {
		if (node == null) {
			return null;
		}

		double nodePrice = node.getGame().getPrice();

		if (price < nodePrice) {
			node.setLeft(removeGameFromStore(node.getLeft(), price));
		} else if (price > nodePrice) {
			node.setRight(removeGameFromStore(node.getRight(), price));
		} else {
			// Found the node to be removed
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				// Node has two children, find successor and replace node
				Node successor = findMinNode(node.getRight());
				node.setGame(successor.getGame());
				node.setRight(removeGameFromStore(node.getRight(), successor.getGame().getPrice()));
			}
		}
		return node;
	}

	// method used to search games by price value
	public Game searchByPrice(Node root, double price) {
		if (root == null) {
			return null;
		} else if (root.getGame().getPrice() == price) {
			return root.getGame();
		} else if (price < root.getGame().getPrice()) {
			return searchByPrice(root.getLeft(), price);
		} else {
			return searchByPrice(root.getRight(), price);
		}
	}

	// recursive method that finds the minimum node in the list
	private Node findMinNode(Node node) {
		if (node.getLeft() == null) {
			return node;
		} else {
			return findMinNode(node.getLeft());
		}
	}

	// recursive method that calculates the whole store price value
	public double calculateStoreValue(Node node) {
		if (node == null) {
			return 0;
		} else {
			double countLeft = calculateStoreValue(node.getLeft());
			double countRight = calculateStoreValue(node.getRight());
			return countLeft + countRight + node.getGame().getPrice();
		}
	}

	// recursive method used to find the most popular game in the BST
	public Game searchMostPopularGame(Node node) {
	    if (node == null) {
	        return null;
	    } else {
	        Game mostPop = node.getGame();
	        Game leftPop = searchMostPopularGame(node.getLeft());
	        Game rightPop = searchMostPopularGame(node.getRight());

	        if (leftPop != null && leftPop.getDownloads() > mostPop.getDownloads()) {
	            mostPop = leftPop;
	        }
	        if (rightPop != null && rightPop.getDownloads() > mostPop.getDownloads()) {
	            mostPop = rightPop;
	        }
	        return mostPop;
	    }
	}

	// * searchByName(...) METHOD PROVIDED AS PART OF TEMPLATE
	// Searches for a game (by name) in the store. Returns null if there are no
	// games in the store or the game was not found. Otherwise, returns the Game
	// object with the game's matching name
	public Game searchByName(Node node, String name) {
		if (node == null) {
			return null;
		}
		Game leftResult = searchByName(node.getLeft(), name);
		if (leftResult != null) {
			return leftResult;
		}
		if (node.getGame().getName().equals(name)) {
			return node.getGame();
		}
		Game rightResult = searchByName(node.getRight(), name);
		return rightResult;
	}

	// * get/setRoot(...) METHODS PROVIDED AS PART OF TEMPLATE
	// getters and setters for the BST root
	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

}