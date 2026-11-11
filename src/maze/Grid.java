package maze;
import java.util.Scanner;

public class Grid {

	public static void main(String []args) {
		
		Scanner s = new Scanner(System.in);
		int m = 0;
		int n = 0;
		
		System.out.print("Please enter a value for the grid: ");
		m = s.nextInt();
		n = m;
		
		Cell[][] grid = new Cell[m][n];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				
				grid[i][j] = new Cell(i, j);
			}
		}
	}
}
