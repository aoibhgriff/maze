package maze;
import java.awt.Canvas;
import java.awt.Graphics;

public class MazeCanvas extends Canvas {
	Cell[][] grid;
	
	
	public MazeCanvas(Cell[][] grid_arg) {
		grid = grid_arg;
	}
	private void drawCell(Graphics g, Cell c, int top, int left, int cell_dim) {
		top = top+1;
		if(c.top) {
			g.drawLine(left, top, left+cell_dim, top); //top
		}
		if(c.left) {
			g.drawLine(left, top, left, top+cell_dim); //left
		}
		if(c.bottom) {
			g.drawLine(left, top+cell_dim, left+cell_dim, top+cell_dim); //bottom
		}
		if(c.right) {
			g.drawLine(left+cell_dim, top, left+cell_dim, top+cell_dim); //right
		}
	}
	@Override
	public void paint(Graphics g) {
		
		int w = getWidth();
		int h = getHeight();
		
		int cell_dim;
		if( w < h) {
			cell_dim = w/grid.length;
		}
		else {
			cell_dim = h/grid.length;
		}
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if (grid[i][j].shortPath) {
				    g.setColor(java.awt.Color.GREEN);
				    g.fillRect(j * cell_dim, i * cell_dim, cell_dim, cell_dim);
				}
				else if (grid[i][j].solverVisited) {
				    g.setColor(java.awt.Color.PINK);
				    g.fillRect(j * cell_dim, i * cell_dim, cell_dim, cell_dim);
				}
				g.setColor(java.awt.Color.BLACK);
				
				drawCell(g, grid[i][j], i*cell_dim, j*cell_dim, cell_dim);
			}
		}
	}
}
