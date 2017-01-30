package test.java;

import static org.junit.Assert.assertEquals;

import main.java.model.BoardDFS;
import main.java.services.DFSSolver;

public class SolverDFSTest extends SolverTest {

    @Override
    public void testBoard(int x, int y, int expectedMoves) {
        BoardDFS b = new BoardDFS(x, y);
        DFSSolver s = new DFSSolver(b);
        int moves = s.solve();
        assertEquals(moves, expectedMoves);
    }
}
