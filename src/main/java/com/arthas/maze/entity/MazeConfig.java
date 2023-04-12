package com.arthas.maze.entity;

public class MazeConfig {
    public static final int ROW_MAX = 7;
    public static final int COLUMN_MAX = 7;
    public static Cube[][] getMaze(){
        final Cube[][] maze= {
                {new Cube(true, false), new Cube(true, false), new Cube(true, false), new Cube(true, false),new Cube(true, false),new Cube(true, false),new Cube(true, false), new Cube(true, false)},
                {new Cube(true, false), new Cube(false, false), new Cube(false, false), new Cube(true, false),new Cube(false, false),new Cube(false, false),new Cube(false, false), new Cube(true, false)},
                {new Cube(true, false), new Cube(false, false), new Cube(true, false), new Cube(true, false),new Cube(true, false),new Cube(true, false),new Cube(false, false), new Cube(true, false)},
                {new Cube(true, false), new Cube(false, false), new Cube(true, false), new Cube(false, false),new Cube(false, false),new Cube(true, false),new Cube(true, false), new Cube(true, false)},
                {new Cube(true, false), new Cube(true, false), new Cube(true, false), new Cube(false, false),new Cube(false, false),new Cube(true, true),new Cube(false, false), new Cube(true, false)},
                {new Cube(true, false), new Cube(false, false), new Cube(true, false), new Cube(true, false),new Cube(true, false),new Cube(true, false),new Cube(false, false), new Cube(true, false)},
                {new Cube(true, false), new Cube(false, false), new Cube(false, false), new Cube(false, false),new Cube(true, false),new Cube(false, false),new Cube(false, false), new Cube(true, false)},
                {new Cube(true, false), new Cube(true, false), new Cube(true, false), new Cube(true, false),new Cube(true, false),new Cube(true, false),new Cube(true, false), new Cube(true, false)},
        };
        return maze;
    }
}
