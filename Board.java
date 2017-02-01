/**
 * Conway's Game of Life
 * The board for the game of life
 */
public class Board {

	private boolean[][] grid;

	/** 
	 * @param columns	The number of columns
	 * @param rows		The number of rows
	 */
	public Board(int columns, int rows) {
		grid = new boolean[columns][rows];
	}

	/**
	 * Returns the number of neighbors at position x,y on the current board.
	 * 
	 * @param x	The x coordinate
	 * @param y The y coordinate
	 * @return The number of alive neighbors at position x,y
	 */
	private int getNumNeighbors(int x, int y) {
		int res = 0;
		int minX = x > 0 ? x - 1 : 0;
		int maxX = x+1 < grid.length ? x + 1 : grid.length - 1;

		int minY = y > 0 ? y - 1 : 0;
		int maxY = y+1 < grid[0].length ? y + 1 : grid[0].length -1;

		for( int i = minX; i <= maxX; i++ ) {
			for( int j = minY; j <= maxY; j++ ) {
				if( grid[i][j] ) {
					res += 1;
				}
			}
		}

		// don't count the current cell
		if( grid[x][y] ) {
			res--;
		}

		return res;
	}

	/**
	 * Advance n generations
	 * @param n 	The number of generations to advance
	 */
	public void tick(int n) {
		for( int i = 0; i < n; i++ ) {
			tick();
		}
	}

	/**
	 * Advance one generation
	 */
	public void tick() {
		boolean[][] newGrid = new boolean[grid.length][grid[0].length];

		for( int y = 0; y < grid[0].length; y++ ) {
			for(int x = 0; x < grid.length; x++ ) {
				int n = getNumNeighbors(x, y);
				if( n == 2) {
					newGrid[x][y] = grid[x][y];
				} else if( n == 3) {
					newGrid[x][y] = true;
				}
			}
		}
		this.grid = newGrid;
	}

	/**
	 * Print the board to stdout
	 */
	public void print() {
		StringBuilder sb = new StringBuilder( grid.length * (grid[0].length + 1) );
		for( int y = 0; y < grid[0].length; y++) {
			for(int x = 0; x < grid.length; x++) {
				if( grid[x][y] ) {
					sb.append('X');
				} else {
					sb.append('.');
				}
			}
			sb.append('\n');
		}
		System.out.println( sb );
		
	}

	/**
	 * Set a cell to alive or dead
	 * @param x		The x coordinate of the cell
	 * @param y		The y coordinate of the cell
	 * @param alive	Do you want the cell to be alive or dead
	 */
	public void setPosition(int x, int y, boolean alive) {
		grid[x][y] = alive;
	}
}
