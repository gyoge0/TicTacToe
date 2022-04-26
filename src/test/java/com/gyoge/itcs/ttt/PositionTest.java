package com.gyoge.itcs.ttt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class PositionTest {

    @Test
    void testToString() {
        Position position = new Position();
        assertEquals("000\n000\n000\n", position.toString());
    }

    @Test
    void testNew() {
        Position position;

        position = new Position();
        assertEquals(1, position.getTurn());
        assertEquals("000\n000\n000\n", position.toString());

        position = new Position(-1);
        assertEquals(-1, position.getTurn());
        assertEquals("000\n000\n000\n", position.toString());

        position = new Position(1, new int[][]{{0, -1, 1}, {1, 0, -1}, {-1, 1, 0}});
        assertEquals(1, position.getTurn());
        assertEquals("0-11\n10-1\n-110\n", position.toString());
    }


    @Test
    void testMove() {
        Position position = new Position().move(new Integer[]{0, 0});

        assertEquals(-1, position.getTurn());
        assertEquals("100\n000\n000\n", position.toString());
    }

    @Test
    void testPossibleMoves() {
        Position position = new Position()
            .move(new Integer[]{0, 0})
            .move(new Integer[]{0, 1})
            .move(new Integer[]{0, 2});
        assertArrayEquals(new Integer[][]{
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
        }, position.possibleMoves());

        position = new Position();
        assertArrayEquals(new Integer[][]{
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
        }, position.possibleMoves());

    }

    @Test
    void testIsWin() {
        assertTrue(new Position(1, new int[][]{
            {1, 1, 1},
            {0, 0, 0},
            {0, 0, 0}}).isWin(1));
        assertTrue(new Position(-1, new int[][]{
            {-1, -1, -1},
            {0, 0, 0},
            {0, 0, 0}}).isWin(-1));
        assertTrue(new Position(1, new int[][]{
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0}}).isWin(1));
        assertTrue(new Position(1, new int[][]{
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}}).isWin(1));
        assertTrue(new Position(1, new int[][]{
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0}}).isWin(1));
    }

    @Test
    void testMiniMax() {
        assertEquals(100, new Position(1, new int[][]{
            {1, 1, 1},
            {0, 0, 0},
            {0, 0, 0}
        }).miniMax(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(99, new Position(1, new int[][]{
            {1, 0, 1},
            {0, 0, 0},
            {0, 0, 0}
        }).miniMax(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(-100, new Position(1, new int[][]{
            {-1, -1, -1},
            {0, 0, 0},
            {0, 0, 0}
        }).miniMax(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(-99, new Position(-1, new int[][]{
            {0, -1, -1},
            {0, 0, 0},
            {0, 0, 0}
        }).miniMax(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(0, new Position(1, new int[][]{
            {1, -1, 1},
            {1, -1, 1},
            {-1, 1, -1}
        }).miniMax(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void testBestMove() {
        assertArrayEquals(new Integer[]{0, 1}, new Position(1, new int[][]{
            {1, 0, 1},
            {0, 0, 0},
            {0, 0, 0}
        }).bestMove());
        assertArrayEquals(new Integer[]{0, 1}, new Position(-1, new int[][]{
            {1, 0, 1},
            {0, 0, 0},
            {0, 0, 0}
        }).bestMove());
        assertArrayEquals(new Integer[]{1, 1}, new Position(1, new int[][]{
{0, 0, 0},
{1, 0, 1},
{0, 0, 0}
        }).bestMove());

    }
}
