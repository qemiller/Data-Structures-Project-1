/**Parser for Dictionary ADT**/

import java.io.File;
import java.util.Scanner;

public static void parse(String fileName)
{
	try {
		Scanner sc = new Scanner(new File(fileName));
		bst<String, rectangle> tree = new bst<String, rectangle>
		while(sc.hasNext)
		{
			String command = sc.next();
			String name; double x; double y; double w; double h;
			switch(command)
			{
			case "insert":
				name = sc.next();
				x = sc.nextDouble();
				y = sc.nextDouble();
				w = sc.nextDouble();
				h = sc.nextDouble();
				rectangle rect = new rectangle(name,x,y,w,h);
				tree.insert(rect.getName,rect);
				System.out.println(rect.getName()+ "inserted into tree! ");
			break;
			
			default:
				System.out.println("Unrecognized input " +cmd);
			} 
		}
	}
	
}
