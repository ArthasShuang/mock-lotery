package com.arthas.maze.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Direction {
    Up(0),
    Down(2),
    Left(3),
    Right(1);

    public static HashMap<Integer, Direction> NUM_2_DIRECTION = new HashMap<>();

    static{
        NUM_2_DIRECTION.put(0, Up);
        NUM_2_DIRECTION.put(1, Right);
        NUM_2_DIRECTION.put(2, Down);
        NUM_2_DIRECTION.put(3, Left);
    }//turn right is plus 1 then mod 4, turn left is plus 3 then mod 4, turn opposite is plus 2 then mod 4

    private int num;

    Direction(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
