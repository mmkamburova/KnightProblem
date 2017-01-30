package test.java;

import org.junit.Test;

public abstract class SolverTest {

    public abstract void testBoard(int x, int y, int expectedMoves);

    @Test
    public void testBoardX0Y0() {
        testBoard(0, 0, 4);
    }

    @Test
    public void testBoardX0Y1() {
        testBoard(0, 1, 1);
    }

    @Test
    public void testBoardX0Y2() {
        testBoard(0, 2, 2);
    }

    @Test
    public void testBoardX1Y0() {
        testBoard(1, 0, 1);
    }

    @Test
    public void testBoardX1Y1() {
        testBoard(1, 1, -1);
    }

    @Test
    public void testBoardX1Y2() {
        testBoard(1, 2, 3);
    }

    @Test
    public void testBoardX2Y0() {
        testBoard(2, 0, 2);
    }

    @Test
    public void testBoardX2Y1() {
        testBoard(2, 1, 3);
    }

    @Test
    public void testBoardX2Y2() {
        testBoard(2, 2, 0);
    }
}
