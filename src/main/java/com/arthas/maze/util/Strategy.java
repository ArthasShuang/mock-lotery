package com.arthas.maze.util;

import java.util.Random;

public class Strategy {
    public static boolean turnLeft(){
        return new Random().nextBoolean();
    }

    public static int buff(int speed) {
        int curSpeed = new Random().nextBoolean()?speed*2:speed/2;
        return curSpeed < 1? 1 : (curSpeed>4? 4 : curSpeed);
    }
}
