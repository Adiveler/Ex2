package gui;



public class TestStdDraw {

	public static void main(String[] args) throws InterruptedException {
		StdDraw.setPenRadius(0.05);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.point(0.5, 0.5);
		
		
		
		
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.line(0.2, 0.2, 0.8, 0.2);
		
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.text(0.2, 0.2, "hello");

		char c = 0;
		while (c != 'q') {
			
			if (StdDraw.hasNextKeyTyped()) {
				c = StdDraw.nextKeyTyped();
			} 
			
			switch (c) {
			case 's':
				System.out.println("save");
				break;

			case 'l':
				System.out.println("load");
				break;
				
			case 'q':
				System.out.println("quit");
				break;
				
			default:
				break;
			}
			
			c = 0;
			Thread.sleep(15);
			
		}

	}

}
