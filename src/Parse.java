/** Bst can search, insert, and remove right now. **/
/** Parser for Dictionary ADT **/

import java.util.Scanner;

/**
 * This takes program will parse and exectute commands in the text file.
 * 
 * @author Quinton Miller
 * @version 2-12-2019
 */
public class Parse {
    private Bst<String, Rectangle> parseTree = new Bst<String, Rectangle>();
    /**
     * This will parse the commands and carry out the function on the dictionary
     * 
     * @param sc
     *            scanner created from the command file
     * @return returns true for testing purposes
     */
    public boolean parse(Scanner sc) {
        while (sc.hasNext()) {
            String command = sc.next(); // command read in from file
            switch (command) {
                case "insert":// deal with the insert command
                    String nameInsert = sc.next();
                    handleInsert(nameInsert, parseTree, sc);
                    break;

                case "remove": // deal with the remove command
                    String nameRemove = sc.next();
                    handleRemove(nameRemove, sc, parseTree);
                    break;

                case "dump": // deal with the dump command
                    parseTree.dump();
                    break;

                case "search": // deal with the search command
                    String nameSearch = sc.next();
                    handleSearch(nameSearch, parseTree);
                    break;

                case "regionsearch": // deal with the regionsearch command
                    int xRegion = sc.nextInt();
                    int yRegion = sc.nextInt();
                    int wRegion = sc.nextInt();
                    int hRegion = sc.nextInt();
                    handleRegionSearch(xRegion, yRegion, wRegion, hRegion,
                        parseTree);
                    break;

                case "intersections": // deal with the intersections command
                    handleIntersections(parseTree);
                    break;

                default:
                    System.out.println("Unrecognized input " + command);
            }
        }
        return true;
    }


    /**
     * remove the rectangle at a certain coordinate
     * 
     * @param x
     *            x coordinate to remove
     * @param y
     *            y coordinate to remove
     * @param w
     *            width size to remove
     * @param h
     *            height size to remove
     * @param tree
     *            tree to remove from
     * @return was something removed
     */
    private boolean removeCoordinate(
        int x,
        int y,
        int w,
        int h,
        Bst<String, Rectangle> tree) {
        boolean removedOne = false;
        BstNode<String, Rectangle> curNode = tree.getFirst();
        while (curNode != null) {
            if (curNode.element().isExact(x, y, w, h)) {
                tree.remove(curNode.element().getName(), curNode.element());
                removedOne = true;
                curNode = tree.getNext(curNode);
            }
            else {
                curNode = tree.getNext(curNode);
            }
        }
        return (removedOne);
    }


    /**
     * Checks if the input coordinates are valid
     * 
     * @param x
     *            x coordinate input
     * @param y
     *            y coordinate input
     * @param w
     *            width input length
     * @param h
     *            height input length
     * @return if the inputed coordinates are valid
     */
    private boolean coordinatesCorrect(int x, int y, int w, int h) {
        return (x >= 0 && y >= 0 && w > 0 && h > 0 && w <= 1024 && h <= 1024
            && x + w <= 1024 && y + h <= 1024);
    }


    /**
     * 
     * @param name
     *            name of rectangle to insert
     * @param tree
     *            tree to insert into
     * @param sc
     *            scanner of txt file
     * @return was a rectangle inserted
     */
    public boolean handleInsert(
        String name,
        Bst<String, Rectangle> tree,
        Scanner sc) {
        // Regex to check first letter is alphabet
        // Then checks the rest for alphanumeric and underscore
        if (name.matches("^[a-zA-Z][a-zA-Z0-9_]*$")) { // make sure the name
                                                       // starts with a letter
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            Rectangle rectInsert = new Rectangle(name, x, y, w, h); // Rectangle
            if (coordinatesCorrect(x, y, w, h)) { // make sure the coordinates
                                                  // are valid
                tree.insert(rectInsert.getName(), rectInsert);
                System.out.println("Rectangle accepted: " + rectInsert
                    .toString());
            }
            else {
                System.out.println("Rectangle rejected: " + rectInsert
                    .toString());
                return false;
            }
        }
        else {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            Rectangle rectInsert = new Rectangle(name, x, y, w, h);
            System.out.println("Rectangle rejected: " + rectInsert.toString());
            return false;
        }
        return true;
    }


    /**
     * handles the remove command
     * 
     * @param name
     *            name of the rectangle to remove
     * @param sc
     *            scanner of the txt file
     * @param tree
     *            tree to remove the rectangle from
     * @return was the remove done
     */
    public boolean handleRemove(
        String name,
        Scanner sc,
        Bst<String, Rectangle> tree) {
        if (name.length() > 0 && Character.isDigit(name.charAt(0)) || name
            .charAt(0) == '-') { // Check to see if the input arguments are
                                 // coordinates.
            int x = Integer.parseInt(name);
            int y = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (!removeCoordinate(x, y, w, h, tree)) {
                System.out.println("Rectangle rejected: (" + x + ", " + y + ", "
                    + w + ", " + h + ")");
                return false;
            }
        }
        else {
            if (tree.remove(name) == null) // If the arguments
            // aren't
            // coordinates,
            // remove by name
            {
                System.out.println("Rectangle rejected: " + name);
                return false;
            }
        }
        return true;
    }


    /**
     * handle the search command through both name and by coordinates.
     * 
     * @param name
     *            name of rectangle to search for
     * @param tree
     *            tree to scan through
     * @return return if the search found something
     */
    public boolean handleSearch(String name, Bst<String, Rectangle> tree) {
        boolean foundOne = false; // Have I found one Rectangle
        // with the given name
        BstNode<String, Rectangle> currNode = tree.getFirst();
        // this
        // function
        // returns
        // the
        // leftmost
        // node
        while (currNode != null) { // if the current node in the search isn't
                                   // the head,
                                   // keep looking
                                   // search through the tree
            if (currNode.element().getName().equals(name)) {

                System.out.println("Rectangle found: " + currNode.element()
                    .toString());
                foundOne = true; // I have found a Rectangle
                                 // while I was searching
            }
            currNode = tree.getNext(currNode);
        }
        
        if (!foundOne) // If I haven't found a Rectangle while I
                       // was searching, throw an error
        {
            System.out.println("Rectangle not found: " + name);
            return false;
        }
        return true;
    }


    /**
     * handle the regionsearch command
     * 
     * @param x
     *            x coordinate of region
     * @param y
     *            y coordinate of region
     * @param w
     *            width size of region
     * @param h
     *            height size of region
     * @param tree
     *            tree to search through
     * @return return if any rectangle was found in the region
     */
    public boolean handleRegionSearch(
        int x,
        int y,
        int w,
        int h,
        Bst<String, Rectangle> tree) {
        BstNode<String, Rectangle> currNodeRegion = tree.getFirst(); // current
                                                                     // node for
        // regionsearch
        if (w > 0 && h > 0) {
            System.out.println("Rectangles intersecting region " + "(" + x
                + ", " + y + ", " + w + ", " + h + "): ");
            while (currNodeRegion != null) {
                // search through the whole tree to see if there are
                // any Rectangles in the region
                if (currNodeRegion.element().isContained(x, y, w, h)) {
                    // Rectangles are stored as elements so check to
                    // see
                    // if it is contained in the region.
                    System.out.println(currNodeRegion.element().toString());
                    currNodeRegion = tree.getNext(currNodeRegion);
                }
                else // find next node in the tree
                {
                    currNodeRegion = tree.getNext(currNodeRegion);
                }
            }
            return true;
        }
        else {
            System.out.println("Rectangle rejected: " + "(" + x + ", " + y
                + ", " + w + ", " + h + ") ");
            return false;
        }
    }


    /**
     * Handles the Intersection command and checks for rectangle intersections
     * in the tree
     * 
     * @param tree
     *            tree to search for intersections in
     * @return were any intersections found
     */
    public boolean handleIntersections(Bst<String, Rectangle> tree) {
        System.out.print("Intersection pairs: \n");
        BstNode<String, Rectangle> storedNode = tree.getFirst();
        if (storedNode == null) {
            return false;
        }
        BstNode<String, Rectangle> interNode = tree.getNext(storedNode);
        for (int i = 0; i < tree.size() - 1; i++) {
            while (interNode != null) {
                // Rectangle values are stored as elements, so
                // grab them, then
                // Rectangle operations can be performed
                if (interNode.element().intersects(storedNode.element())) {
                    System.out.println(interNode.element().toString() + " : "
                        + storedNode.element().toString());
                }
                // Finds next node until null
                interNode = tree.getNext(interNode);
            }
            storedNode = tree.getNext(storedNode);
            interNode = tree.getNext(storedNode);
        }
        return true;
    }
}
