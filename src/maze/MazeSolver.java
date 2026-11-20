package maze;
import javax.swing.Timer;

public class MazeSolver {
	private Cell[][] grid;
	private Cell[][] prev;
	private QueueArrayBased queue;
	private Timer timer;
	private MazeCanvas canvas;
	
	public MazeSolver(Cell[][] grid, MazeCanvas canvas) {
		this.grid = grid;
		this.canvas = canvas;
		queue = new QueueArrayBased();
		
		prev = new Cell[grid.length][grid[0].length];
		timer = new Timer(300, e -> solveStep());
	}
	
	public void solveMaze() {
		Cell start = grid[0][0];
		
		start.solverVisited = true;
		queue.enqueue(start);
		
		timer.start();
	}
	
	private void solveStep() {
		int rows = grid.length;
	    int cols = grid[0].length;

	    if (queue.isEmpty()) {
	        timer.stop();
	        return;
	    }

	    Cell curr = (Cell) queue.dequeue();

	    if (curr.row == rows - 1 &&
	        curr.col == cols - 1) {

	        timer.stop();
	        findShortestPath();
	        canvas.repaint();
	        return;
	    }

	    int r = curr.row;
	    int c = curr.col;

	    if (!curr.top && r > 0 && !grid[r - 1][c].solverVisited) {

	        visitNeighbour(curr, grid[r - 1][c]);
	    }

	    if (!curr.bottom && r < rows - 1 && !grid[r + 1][c].solverVisited) {

	        visitNeighbour(curr, grid[r + 1][c]);
	    }

	    if (!curr.left && c > 0 && !grid[r][c - 1].solverVisited) {

	        visitNeighbour(curr, grid[r][c - 1]);
	    }

	    if (!curr.right && c < cols - 1 && !grid[r][c + 1].solverVisited) {

	        visitNeighbour(curr, grid[r][c + 1]);
	    }

	    canvas.repaint();
	}
	
	private void visitNeighbour(Cell curr, Cell neighbour) {
		
		neighbour.solverVisited = true;
		prev[neighbour.row][neighbour.col] = curr;
		queue.enqueue(neighbour);
	}
	private void findShortestPath() {
		int finalRow = grid.length - 1;
		int finalCol = grid[0].length - 1;
		
		Cell curr = grid[finalRow][finalCol];
		
		while (curr != null) {
			curr.shortPath = true;
			
			if (curr.row == 0 && curr.col == 0) {
				;
			}
			
			curr = prev[curr.row][curr.col];
		}
		
	}
}
