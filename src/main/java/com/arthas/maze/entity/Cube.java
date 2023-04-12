package com.arthas.maze.entity;

public class Cube {
    private boolean valid;
    private boolean isBuff;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isBuff() {
        return isBuff;
    }

    public Cube(boolean valid, boolean isBuff) {
        this.valid = valid;
        this.isBuff = isBuff;
    }

    public void setBuff(boolean buff) {
        isBuff = buff;
    }
}
