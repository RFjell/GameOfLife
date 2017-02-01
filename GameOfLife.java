/**
 * Conway's Game of Life
 * Takes 3 integers as arguments and an optional list of coordinates that are zero-based.
 * The first 3 arguments are the number of ticks, the width and the height.
 * 
 * Example input: 
 * 		2 5 5 2,1 1,2 2,2 3,2 1,3 3,3 2,4
 * 
 * Example output:
 *	 	..X..
 *		.X.X.
 *		XX.XX
 *		.X.X.
 *		..X..
 * 
 */
public class GameOfLife {

	public static void main(String[] args) {
		if( args.length < 3 ) {
			System.out.println("To few arguments.\n"+
								"Usage: \n"+
								"\tjava GameOfLife ticks width height [x,y ...]");
			return;
		}

		// Parse ticks, width and height arguments
		int ticks, width, height;
		try {
			ticks = Integer.parseInt(args[0]);
			width = Integer.parseInt(args[1]);
			height = Integer.parseInt(args[2]);
		} catch( NumberFormatException nfe ){
			System.out.println("Ticks, width and height has to be integers.");
			return;
		}

		Board board = new Board(width, height);

		// Parse list of coordinates of living cells
		try {
			for( int i = 3; i < args.length; i++ ) {
				String[] tmp = args[i].split(",");
				int x = Integer.parseInt(tmp[0]);
				int y = Integer.parseInt(tmp[1]);
				board.setPosition(x, y, true);
			}
		} catch( ArrayIndexOutOfBoundsException aiobe ) {
			System.out.println("List of coordinates is badly formated or a given coordinate is outside the board.");
			return;
		} catch( NumberFormatException nfe ) {
			System.out.println("List of coordinates is badly formated.");
			return;
		}

		// Start ticking
		board.tick(ticks);

		// Print result
		board.print();
	}
}
