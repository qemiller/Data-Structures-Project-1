/*Compiler: jdk 1.8.0_201
 *Operating System: Windows 10
 *Date Completed:
 *
 *This program takes in a set of commands from a txt file
 * that will store and query rectangles.
 *The data structure used to store the rectangles is
 * a Binary Search Tree. The commands that are
 *implemented in this program are:
 *insert, which inserts rectangles into the tree
 *remove by both coordinate and name,
 *which will remove the given rectangle by name or coordinate
 *regionsearch, which will output any rectangle in the given region
 *search by name, which will search the tree for rectngle with the given name
 *dump, which will dump the rectangles in the binary tree to the console
 **/

//  On my honor: 
//
//  - I have not used source code obtained from another student,
//  or any other unauthorized source, either modified or
//  unmodified. 
//
//  - All source code and documentation used in my program is
//  either my original work, or was derived by me from the
//  source code published in the textbook for this course. 
//
//  - I have not discussed coding details about this project with
//  anyone other than my partner (in the case of a joint
//  submission), instructor, ACM/UPE tutors or the TAs assigned
//  to this course. I understand that I may discuss the concepts
//  of this program with other students, and that another student
//  may help me debug my program so long as neither of us writes
//  anything during the discussion or modifies any computer file
//  during the discussion. I have violated neither the spirit nor
//  letter of this restriction.
public class Rectangle1
{	
	public static void main(String[] args)
	{
		String fileName = args[0];
		parse Rectangle1 = new parse();
		Rectangle1.parseFile(fileName);
	}

}