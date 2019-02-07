/**BST can search, insert, and remove right now.**/ 
/**Parser for Dictionary ADT**/

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class parse {
	public void parseFile(String fileName) {
		try
		{
			Scanner sc = new Scanner(new File(fileName));
			bst<String, rectangle> tree = new bst<String, rectangle>();
			while (sc.hasNextLine()) {
				String command = sc.next();
				String name;
				int x;
				int y;
				int w;
				int h;
				switch (command) {
				
				case "insert":
					name = sc.next();
					x = sc.nextInt();
					y = sc.nextInt();
					w = sc.nextInt();
					h = sc.nextInt();
					rectangle rect = new rectangle(name, x, y, w, h);
					tree.insert(rect.getName(), rect);
					System.out.println(rect.getName() + " inserted into tree! ");
					break;
				
				case "remove":
					name = sc.next();
					if(containsNumber(name))
					{	
						x = Integer.parseInt(name);
						y = sc.nextInt();
						w = sc.nextInt();
						h = sc.nextInt();
						removeCoordinate(x,y,w,h,tree);
						System.out.println("rectangle at " + x + ", " + y + ", " + w + ", "+ h + " removed!");
					}
					else
					{
						if(tree.remove(name) == null)
							System.out.println("No rectangle named "+ name +" in tree." );
						else
							System.out.println(name + " removed from tree");
					}
					break;
					
				case "dump":
					tree.dump();
					break;
					
				case "search":
					name = sc.next();
					rectangle searchRect = tree.search(name);
					if(searchRect!=null)
					{
						System.out.println(searchRect.toString());
					}
					
					else
						System.out.println(name + " could not be found.");
					break;
	
				default:
					System.out.println("Unrecognized input " + command);
				}
			}
			sc.close();
		}
		catch(Exception FileNotFoundException)
		{}
	}
	private boolean containsNumber(String s)
	{
		return Pattern.compile("[0-9]").matcher(s).find();
	}
	
	private void removeCoordinate(int x, int y, int w, int h, bst<String,rectangle> tree)
	{
		bstNode<String, rectangle> curNode = tree.getFirst();
		while(curNode != null)
		{
			if(curNode.element().isExact(x, y, w, h))
				tree.remove(curNode.element().getName());
			else
				curNode=tree.getNext(curNode);
		}
	}
}


