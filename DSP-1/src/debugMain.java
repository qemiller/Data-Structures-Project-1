public class debugMain {

	public static void main(String[] args) {
		rectangle rect = new rectangle("lala", 1, 2, 3, 4);
		
		bst<String, rectangle> best = new bst<String, rectangle>();
		
		best.insert(rect.getName(), rect);
	}

}
