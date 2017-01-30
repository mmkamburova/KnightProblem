package main.java.model;

import java.util.Stack;

public class BoardDFS extends Board<BoardDFS> {

    private BoardDFS parent;

    /**
     * Class constructor. Creates new board and specifies the coordinates of the
     * knight
     * 
     * @param x
     *            x coordinate
     * @param y
     *            y coordinateS
     */
    public BoardDFS(int x, int y) {
        super(x, y);
    }

    /**
     * Class constructor
     * 
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @param parent
     *            parent of the current node in graph
     */
    public BoardDFS(int x, int y, BoardDFS parent) {
        this(x, y);
        this.parent = parent;
    }

    /**
     * Swaps 2 elements of the board and returns new one
     * 
     * @param i
     *            current x
     * @param j
     *            current y
     * @param otherI
     *            other x
     * @param otherJ
     *            other y
     * @return swapped board
     */
    @Override
    public BoardDFS swap(int i, int j, int otherI, int otherJ) {
        BoardDFS b = new BoardDFS(otherI, otherJ, this);
        b.setDirection(String.format("From (%d , %d) to (%d , %d)!", i, j,
                otherI, otherJ));
        return b;
    }

    /**
     * Adds neighbors to the stack
     * 
     * @return stack with neighbors
     */
    public Stack<BoardDFS> neighbors() {
        Stack<BoardDFS> stack = new Stack<BoardDFS>();
        addNeighbors(stack);
        return stack;
    }

    public BoardDFS getParent() {
        return parent;
    }

}
