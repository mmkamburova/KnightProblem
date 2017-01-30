package src.main.java.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import src.main.java.model.BoardDFS;

/**
 * Find a solution to the initial board (using the DFS algorithm)
 */
public class DFSSolver implements ISolver {

    private int moves;
    private Deque<BoardDFS> states;

    /**
     * Class constructor
     * 
     * @param initial
     *            initial board
     */
    public DFSSolver(BoardDFS initial) {
        moves = 0;
        states = new LinkedList<>();
        states.push(initial);
    }

    /**
     * Finds the shortest way to the final position (3x3)
     */
    @Override
    public int solve() {
        while (!states.isEmpty()) {
            BoardDFS board = states.pop();
            if (board.isGoal()) {
                List<String> allMoves = getMoves(board);
                moves = allMoves.size();
                printGoal(allMoves);
                return moves;
            }

            states.addAll(board.neighbors());
        }

        System.out.println(
                "Cannot solve this board. Knight cannot move to end of board.");
        return -1;
    }

    /**
     * Get all moves
     * 
     * @param winningState
     * @return
     */
    private List<String> getMoves(BoardDFS winningState) {
        List<String> allMoves = new ArrayList<>();
        while (winningState != null) {
            if (winningState.getDirection() != null)
                allMoves.add(winningState.getDirection());
            winningState = winningState.getParent();
        }
        Collections.reverse(allMoves);
        return allMoves;
    }

    /**
     * Prints all steps
     */
    private void printGoal(List<String> allMoves) {
        allMoves.forEach(move -> System.out.println(move));
    }

}
