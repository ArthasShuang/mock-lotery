package com.arthas.maze.action;

import com.arthas.maze.entity.*;
import com.arthas.maze.util.Rule;

public class Main {

    public static void main(String[] args) {
        final Cube[][] maze= MazeConfig.getMaze();
        Cat catA = new Cat(2, new State(Direction.Up, 0, 2), true);
        Cat catB = new Cat(2, new State(Direction.Up,5, 2), false);
        Cat catC = new Cat(2, new State(Direction.Up,7, 6), true);
        for(int i=0; i < 100; i++){
            catA.action(true);
            catB.action(true);
            catC.action(true);
            Rule.catching(catA, catB);
            Rule.catching(catB, catC);
            Rule.catching(catC, catA);
            System.out.println("A:"+catA.toString());
            System.out.println("B:"+catB.toString());
            System.out.println("C:"+catC.toString());
        }
    }
}
