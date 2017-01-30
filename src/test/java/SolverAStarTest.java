package test.java;

import static org.junit.Assert.assertEquals;

import main.java.model.BoardAStar;
import main.java.services.AStarSolver;

public class SolverAStarTest extends SolverTest {

    @Override
    public void testBoard(int x, int y, int expectedMoves) {
        BoardAStar b = new BoardAStar(x, y);
        AStarSolver s = new AStarSolver(b);
        int moves = s.solve();
        assertEquals(moves, expectedMoves);
    }

}
