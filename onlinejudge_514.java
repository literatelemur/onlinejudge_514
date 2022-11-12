import java.util.*;

public class onlinejudge_514 {
	public static void main(String[] args) {
		// Collecting input.
		Scanner input = new Scanner(System.in);
		int blockNumLines = Integer.parseInt(input.nextLine());
		
		// Different arrangement of reading input when first time.
		boolean first = true;
		// Entering block.
		while (blockNumLines != 0) {
			// Number of "numbers" (priority) in a single line.
			int numNums = -1;
			
			// Further input formatting.
			if (first) {numNums = blockNumLines;}
			else {numNums = input.nextInt();}
			
			// Entering line.
			String line = input.nextLine();
			while (numNums != 0) {
				// Integer arraylist for storing order of priority.
				ArrayList<Integer> order = new ArrayList<>();
				
				// Read the line by parsing numbers from index 0 and removing indices.
				while (line.length() > 0) {
					order.add(Integer.parseInt(line.substring(0, 1)));
					if (line.length() > 1) {line = line.substring(2, line.length());} 
					else {line = "";}
				}
				
				// Checking validity of order by seeing if the ordering is either low-to-high or high-to-low.
				if (check(order, "up") || check(order, "down")){System.out.println("Yes");}
				else {System.out.println("No");}
				// Updating line and numNums for next line.
				line = input.nextLine();
				numNums = Integer.parseInt(line.substring(0, 1));
			}
			blockNumLines = Integer.parseInt(input.nextLine());
			if (blockNumLines != 0) {System.out.println("");}
		}
		input.close();
	}
	
	// Method to compare enumerating values to priorities and therefore see if an ordering is valid.
	public static boolean check(ArrayList<Integer> order, String dir){
		// Count to enumerate either as 1, 2, ..., n or n, n-1, ..., 1.
		int count = 0;
		if (dir == "up"){count = 1;}
		else if(dir == "down") {count = order.size();}
		
		// Run through order and return false if a priority in order is not matched with a corresponding ordered count.
		for (int i = 0; i < order.size(); i++) {
			if (order.get(i) != count) {return false;}
			if (dir == "up") {count++;}
			else if (dir == "down") {count--;}
		}
		// Exiting the order enumeration without returning false guarantees that the ordering is fine. 
		return true;
	}
}
