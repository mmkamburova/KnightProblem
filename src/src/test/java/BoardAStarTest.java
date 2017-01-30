package src.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.model.BoardAStar;

public class BoardAStarTest {
    @Test
    public void testBoardX0Y0() {
        testManhattan(0, 0, 2);
    }

    @Test
    public void testBoardX0Y1() {
        testManhattan(0, 1, 0);
    }

    @Test
    public void testBoardX0Y2() {
        testManhattan(0, 2, 1);
    }

    @Test
    public void testBoardX1Y0() {
        testManhattan(1, 0, 0);
    }

    @Test
    public void testBoardX1Y1() {
        testManhattan(1, 1, 1);
    }

    @Test
    public void testBoardX1Y2() {
        testManhattan(1, 2, 2);
    }

    @Test
    public void testBoardX2Y0() {
        testManhattan(2, 0, 1);
    }

    @Test
    public void testBoardX2Y1() {
        testManhattan(2, 1, 2);
    }

    @Test
    public void testBoardX2Y2() {
        testManhattan(2, 2, 0);
    }

    public void testManhattan(int x, int y, int expectedDist) {
        BoardAStar b = new BoardAStar(x, y);
        int mDist = b.manhattan();
        assertEquals(mDist, expectedDist);
    }
}
