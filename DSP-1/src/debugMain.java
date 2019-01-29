public class debugMain {

	public static void main(String[] args) {
		
		rectangle rect = new rectangle("lala", 1, 2, 3, 4);
		rectangle rect2 = new rectangle("ala", 1, 2, 3, 4);
		rectangle rect3 = new rectangle("pala", 1, 2, 3, 4);
		rectangle rect4 = new rectangle("sala", 1, 2, 3, 4);
		rectangle rect5 = new rectangle("eala", 1, 2, 3, 4);
		rectangle rect6 = new rectangle("fala", 1, 2, 3, 4);
		
		bst<String, rectangle> best = new bst<String, rectangle>();
		
		best.dump();
		
		best.insert(rect.getName(), rect);
		best.insert(rect2.getName(), rect2);
		best.insert(rect3.getName(), rect3);
		best.insert(rect4.getName(), rect4);
		best.insert(rect5.getName(), rect5);
		best.insert(rect6.getName(), rect6);
		
		best.dump();
		
		best.remove("ala");
		
		best.dump();
	}

}
