package maze;
import javax.swing.*;

public class MazeFrame extends JFrame {
	int M = 10;
	int N = 10;
	
	Cell[][] grid = new Cell[M][N];
	
	public MazeFrame() {
		setTitle("My Perfect Maze");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialiseGrid();
		add(new MazeCanvas(grid));
	}
	
	private void generateMaze() {
		
	}
	
	
	private void initialiseGrid() {
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				
				grid[i][j] = new Cell(i, j);
			}
		}
	}
	
	public static void main(String[] args) {
		new MazeFrame().setVisible(true);

	}

}
