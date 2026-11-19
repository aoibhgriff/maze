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
			
			Cell[] neighbourCells = new Cell[4];
			int count = getUnvisitedNeighbourCells(curr, neighbourCells);
			
			if(count > 0) {
				
				int selectRandom = (int)(Math.random() * count);
				
				Cell next = neighbourCells[selectRandom];
				
				removeWall(curr, next);
				next.visited = true;
				stack.push(next);
				
			}
			else {
				stack.pop();
			}
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
	
	private void removeWall(Cell curr, Cell next) {
		
		int rowDiff = next.row - curr.row;
		int colDiff = next.col - curr.col;
		
		//up
		if (rowDiff == -1) {
			curr.top = false;
			next.bottom = false;
		}
		//down
		else if (rowDiff == 1) {
			curr.bottom = false;
			next.top = false;
		}
		//left
		else if (colDiff == -1) {
			curr.left = false;
			next.right = false;
		}
		//right
		else if (colDiff == 1) {
			curr.right = false;
			next.left = false;
		}
	}
}
