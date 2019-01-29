/**BST can search, insert, and remove right now.**/ 
/**Parser for Dictionary ADT**/
import java.io.File;
import java.util.Scanner;

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
					tree.remove(name);
					System.out.println(name + " removed from tree! ");
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

}
