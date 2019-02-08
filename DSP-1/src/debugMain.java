public class debugMain {

	public static void main(String[] args) {
		
		rectangle rect = new rectangle("lala", 2, 2, 8, 8);
		rectangle rect2 = new rectangle("wawa", 3, 3, 3, 3);
		rectangle rect3 = new rectangle("rara", 5, 5, 2, 2);
		rectangle rect4 = new rectangle("sasa", 3, 4, 3, 3);
		rectangle rect5 = new rectangle("ala", 1, 2, 3, 4);
		rectangle rect6 = new rectangle("fala", 1, 1, 2, 2);
		
		bst<String, rectangle> best = new bst<String, rectangle>();
		
		best.dump();
		
		best.insert(rect.getName(), rect);
		best.insert(rect2.getName(), rect2);
		best.insert(rect3.getName(), rect3);
		best.insert(rect4.getName(), rect4);
		best.insert(rect5.getName(), rect5);
		best.insert(rect6.getName(), rect6);
		
		//dump
		
		best.dump();
		
		//remove by name
		
		best.remove("ala");
		
		//improved search
		
		String searchQuery = "lala";
		System.out.print("Searching for: " + searchQuery + '\n');
		bstNode<String, rectangle> searchNode = best.getFirst();
		//Then we iterate through every value in the tree
		while(searchNode != null) {
			//	Rectangle values are stored as elements, so grab them, then
			//	rectangle operations can be performed
			if(searchNode.element().getName() == searchQuery) {
				System.out.print(searchNode.element().toString() + '\n');
			}
			//Finds next node until null
			searchNode = best.getNext(searchNode);
		}
		
		//remove by loc and regionsearch
		
		//This function returns the leftmost node
		bstNode<String, rectangle> currNode = best.getFirst();
		//Then we iterate through every value in the tree
		while(currNode != null) {
			//	Rectangle values are stored as elements, so grab them, then
			//	rectangle operations can be performed
			currNode.element().isContained(5, 7, 3, 3);
			//Finds next node until null
			currNode = best.getNext(currNode);
		}
		
		//intersections
		
		System.out.print("Intersecting Rectangles:\n");
		bstNode<String, rectangle> storedNode = best.getFirst();
		bstNode<String, rectangle> interNode = best.getNext(storedNode);
		for(int i = 0; i < best.size() - 1; i++) {
			while(interNode != null) {
				//	Rectangle values are stored as elements, so grab them, then
				//	rectangle operations can be performed
				if(interNode.element().intersects(storedNode.element())) {
					System.out.print(interNode.element().toString() + " : " + 
						storedNode.element().toString() + '\n');
				}
				//Finds next node until null
				interNode = best.getNext(interNode);
			}
			storedNode = best.getNext(storedNode);
			interNode = best.getNext(storedNode);
		}
		
		best.dump();
	}

}
