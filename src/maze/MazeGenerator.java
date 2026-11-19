package maze;

public class MazeGenerator {

	private Grid grid;
	private StackReferenceBased stack;
	
	public void generateMaze() {
		
		Cell[][] cells = grid.getGrid();
		
		int rows = cells.length;
		int cols = cells[0].length;
		
		Cell curr = cells[0][0];
		curr.visited = true;
		stack.push(curr);
		
		while(!stack.isEmpty()) {
			curr = (Cell)stack.peek();
			//add DFS here
		}
	}
	
	private int getUnvisitedNeighbourCells(Cell curr, Cell[] neighbourCells) {
		
		Cell[][] cells = grid.getGrid();
		
		int rows = cells.length;
		int cols = cells[0].length;
		
		int numUnvisitedNeighbours = 0;
		
		int row = curr.row;
		int col = curr.col;
		
		//This one checks up
		if (row > 0 && !cells[row - 1][col].visited) {
			neighbourCells[numUnvisitedNeighbours++] = cells[row - 1][col];
		}
		//This one is down
		if(row < rows - 1 && !cells[row + 1][col].visited) {
			neighbourCells[numUnvisitedNeighbours++] = cells[row + 1][col];
		}
		//This is left
		if(col > 0 && !cells[row][col - 1].visited) {
			neighbourCells[numUnvisitedNeighbours++] = cells[row][col - 1];
		}
		//This one is right
		if(col < cols - 1 && !cells[row][col + 1].visited) {
			neighbourCells[numUnvisitedNeighbours++] = cells[row][col + 1];
		}
		
		return numUnvisitedNeighbours;
	}
}
