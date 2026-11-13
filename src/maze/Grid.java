package maze;

public class Grid {
	private Cell[][] grid;
	
	public Grid(int rows, int cols) {
		
		grid = new Cell[rows][cols];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				
				grid[i][j] = new Cell(i, j);
			}
		}
	}
	
	public Cell[][] getGrid(){
		return grid;
	}

}
