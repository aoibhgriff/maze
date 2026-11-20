package maze;

public class Cell {
	
	boolean visited;
	int row;
	int col;
	boolean left, right, top, bottom;
	boolean solverVisited;
	boolean shortPath;
	
	public Cell(int r, int c) {
		
		visited = false;
		row = r;
		col = c;
		left = right = top = bottom = true; //set wall states to "true" 
		solverVisited = false;
		shortPath = false;
	}
}
