/*Compiler: jdk 1.8.0_201
 *Operating System: Windows 10
 *Date Completed:
 *
 *This program takes in a set of commands from a txt file that will store and query rectangles.
 *The data structure used to store the rectangles is a Binary Search Tree. The commands that are
 *implemented in this program are:
 *insert, which inserts rectangles into the tree
 *remove by both coordinate and name, which will remove the given rectangle by name or coordinate
 *regionsearch, which will output any rectangle in the given region
 *search by name, which will search the tree for rectngle with the given name
 *dump, which will dump the rectangles in the binary tree to the console
 **/

public class Rectangle1{
	public static void main(String[] args)
	{
		String fileName = args[0];
		parse Rectangle1 = new parse();
		Rectangle1.parseFile(fileName);
	}

}