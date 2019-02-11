/**BST can search, insert, and remove right now.**/
/**Parser for Dictionary ADT**/

import java.io.File;
import java.util.Scanner;

/*
 This function parses the file and executes the given commands
 @param fileName is name of file to be parsed
 */
public class Parse {
public void parseFile(String fileName)
{
		try 
		{
			Scanner sc = new Scanner(new File(fileName));
			bst<String, Rectangle> tree = new bst<String, Rectangle>();
			while (sc.hasNextLine())
			{
				String command = sc.next(); //command read in from file
				String name; //name of Rectangle
				int x; //x-coordinate of Rectangle
				int y; //y-coordinate of Rectangle
				int w; //width of Rectangle
				int h; //height of Rectangle
				switch (command)
				{
					case "insert"://deal with the insert command
						name = sc.next();
						x = sc.nextInt();
						y = sc.nextInt();
						w = sc.nextInt();
						h = sc.nextInt();
						Rectangle rectInsert = new Rectangle(name, x, y, w, h); //Rectangle to be inserted
						if (Character.isLetter(name.charAt(0))) 
						{ //make sure the name starts with a letter
							if (coordinatesCorrect(x, y, w, h)) 
							{ //make sure the coordinates are valid
								tree.insert(rectInsert.getName(), rectInsert);
								System.out.println("Rectangle accepted: " + rectInsert.toString());
							} 
							else 	
							{
								System.out.println("Rectangle rejected: " + rectInsert.toString());
							} 
						}
						else 
						{
							System.out.println("Rectangle rejected: " + rectInsert.toString());
						}
						break;

					case "remove": //deal with the remove command
						name = sc.next();
						if (Character.isDigit(name.charAt(0)))
						{ //Check to see if the input arguments are coordinates.
							x = Integer.parseInt(name);
							y = sc.nextInt();
							w = sc.nextInt();
							h = sc.nextInt();
							if (removeCoordinate(x, y, w, h, tree))
							{ 
								//If a Rectangle is removed, do nothing 
							}
							else //else, print rejection
							{
								System.out.println("Rectangle rejected (" + x +
										"," + y + "," + w + "," + h + ")");
							}
						}
						else
						{
							if (tree.remove(name) == null) //If the arguments aren't coordinates, remove by name 
							{
								System.out.println("Rectangle rejected " + name);
							}
						}
						break;
	
					case "dump": //deal with the dump command
						tree.dump();
						break;
	
					case "search": //deal with the search command
						name = sc.next();
						boolean foundOne = false; //Have I found one Rectangle with the given name
						bstNode<String, Rectangle> currNode = tree.getFirst(); //this function returns the leftmost node
						while (currNode != null)
						{ //if the current node in the search isn't the head, keep looking
							//search through the tree 
							if (currNode.element().getName() == name)
							{
								//b/c the Rectangles are stored as elements in the
								//tree, get it and check if its the right name. If
								//correct, output the Rectangle. If not, keep searching.
								System.out.println("Rectangle Found:" + currNode.element().toString());
								currNode = tree.getNext(currNode);
								foundOne = true; //I have found a Rectangle while I was searching
							} 
							else
							{
								currNode = tree.getNext(currNode);
							}
						}
						if (!foundOne) //If I haven't found a Rectangle while I was searching, throw an error
						{
							System.out.println("Rectangle not found:" + name);
						}
						break;
	
					case "regionsearch": //deal with the regionsearch command
						x = sc.nextInt();
						y = sc.nextInt();
						w = sc.nextInt();
						h = sc.nextInt();
						bstNode<String, Rectangle> currNodeRegion = 
								tree.getFirst(); //current node for regionsearch
						System.out.println("Rectanagles intersecting region  "
								+ "(" + x + "," + +y + "," + w + "," + h + "):");
						while (currNodeRegion != null)
						{
							//search through the whole tree to see if there are
							//any Rectangles in the region
							if (currNodeRegion.element().isContained(x, y, w, h)) 
							{
								//Rectangles are stored as elements so check to see 
								// if it is contained in the region.
								System.out.println(currNodeRegion.element().toString() + "\n");
								currNodeRegion = tree.getNext(currNodeRegion);
							} 
							else //find next node in the tree
							{
								currNodeRegion = tree.getNext(currNodeRegion);
							}
						}
						break;
	
					case "intersections": //deal with the intersections command
						System.out.print("Intersecting Rectangles:\n");
						bstNode<String, Rectangle> storedNode = tree.getFirst();
						if(storedNode==null)
							continue;
						bstNode<String, Rectangle> interNode = tree.getNext(storedNode);
						for (int i = 0; i < tree.size() - 1; i++) {
							while (interNode != null)
							{
								//	Rectangle values are stored as elements, so grab them, then
								//	Rectangle operations can be performed
								if (interNode.element().intersects(storedNode.element()))
								{
									System.out.print(interNode.element().toString() + " : " + 
										storedNode.element().toString() + '\n');
								}
								//Finds next node until null
								interNode = tree.getNext(interNode);
							}
							storedNode = tree.getNext(storedNode);
							interNode = tree.getNext(storedNode);
						}
						break;
						
					default:
						System.out.println("Unrecognized input " + command);
					}
			}
			sc.close();
		} 
		catch (Exception FileNotFoundException)
		{
			//Throw this if I can't find the file
		}
	}

	/*
	 * will remove a Rectangle by coordinate from the tree
	 * 
	 * @param x is x coordinate of Rectangle
	 * 
	 * @param y is y coordinate of Rectangle
	 * 
	 * @param w is width of Rectangle
	 * 
	 * @param h is height of Rectangle
	 * 
	 * @param is the tree to search for the given Rectangle
	 * 
	 * @return if there was something removed from the tree
	 */
	private boolean removeCoordinate(int x, int y, int w, int h, bst<String, Rectangle> tree)
	{
		boolean removedOne = false;
		bstNode<String, Rectangle> curNode = tree.getFirst();
		while (curNode != null)
		{
			if (curNode.element().isExact(x, y, w, h))
			{
				tree.remove(curNode.element().getName());
				removedOne = true;
				break;
			} 
			else
			{
				curNode = tree.getNext(curNode);
			}
		}
		if (!removedOne)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/*
	 * Checks to make sure the given coordinates are within the world box and width
	 * and height are greater than zero.
	 * 
	 * @param x is x coordinate of Rectangle
	 * 
	 * @param y is y coordinate of Rectangle
	 * 
	 * @param w is width of Rectangle
	 * 
	 * @param h is height of Rectangle
	 * 
	 * @return if the coordinates are correct
	 */
	private boolean coordinatesCorrect(int x, int y, int w, int h) {
		if (x + w <= 1024 && x >= 0 && y + h <= 1024
				&& y >= 0 && w > 0 && h > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
