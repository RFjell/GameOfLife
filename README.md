# Conway's Game Of Life

## Background
Conway’s Game of Life is a gaming algorithm invented by British mathematician John Horton Conway in 1970.

In Game of Life you have a game board with X number of columns and Y number of rows. Each cell in the grid can either be alive (normally illustrated by a black square, but I'll use an uppercase X) or dead (white square, or .). Each cell (except those on the edge of the game board) has eight neighbors (above, below, to the left, to the right and diagonally).

For each generation (tick) a cell can either be born, die or remain (dead or alive). What happens to the cell depends on the number of living neighbors, if there are too few neighbors it will die of loneliness and if there are too many it will die of starvation. The following table describes what happens to a cell under different conditions:

| Number of living neighbors | Living cell | Dead cell    |
|----------------------------|-------------|--------------|
| Less than 2                | Dies        | Remains dead |
| 2                          | Stays alive | Remains dead |
| 3                          | Stays alive | Is born      |
| Greater than 3             | Dies        | Remains dead |

This means that if a living cell has two or three living neighbors it stays alive, otherwise it dies. If a dead cell has three living neighbors it is born (or reborn).

All events that takes place during one tick are mountainous. This means that you cannot start by looking at the top left cell and conclude that it should be born, and then count that cell as alive; this cell should be regarded as dead throughout this generation (tick) even if it is born.

## Example
This is an example of a start position and the evolution during three generations:

|Generation 0|Generation 1|Generation 2|
|:-----:|:-----:|:-----:|
|` . . . . . `|` . . . . . `|` . . X . . `|
|` . . X . . `|` . X X X . `|` . X . X . `|
|` . X X X . `|` . X . X . `|` X X . X X `|
|` . X . X . `|` . X . X . `|` . X . X . `|
|` . . X . . `|` . . X . . `|` . . X . . `|

## Compilation
Run `javac GameOfLife.java`

## Execution
Runs from the command line with

`java GameOfLife ticks width height [x,y ...]`

|Argument|Description|
|--------|-----------|
|ticks   |An integer that describes the number of generations to simulate (giving the argument 0 here will yield the input data unaltered) |
|width   |Number of columns of game board 
|height  |Number of rows of game board
|x,y     |Coordinates of all the living cells (the coordinates are 0-indexed from the upper left corner, x to the right and y downwards)

####Example:

`java GameOfLife 2 5 5 2,1 1,2 2,2 3,2 1,3 3,3 2,4`

This line should execute the example above and tick it two generations, thus yielding the result on the last column in that example.

