package com.arthas.maze.entity;

import com.arthas.maze.util.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cat {
    private int speed;
    private State state;
    private boolean isHunter;
    private List<State> traceList = new ArrayList<>();

    public Cat(int speed, State state, boolean isHunter) {
        this.speed = speed;
        this.state = state;
        this.isHunter = isHunter;
    }

    public void action(boolean newFlag) {
        if(newFlag) {
            traceList.clear();
            traceList.add(new State(getState().getDirection(), getState().getRowNo(), getState().getColumnNo()));
        }
        int step = this.speed  - traceList.size();
        for (; step >= 0; ) {
            if (this.move()) {
                step--;
                traceList.add(new State(getState().getDirection() ,getState().getRowNo(), getState().getColumnNo()));
            } else {
                if (Strategy.turnLeft()) this.turnLeft();
                else this.turnRight();
            }
        }
        if(traceList.stream().anyMatch(state1 -> MazeConfig.getMaze()[state1.getRowNo()][state1.getColumnNo()].isBuff())){
            setSpeed(Strategy.buff(getSpeed()));
        }
    }

    public void turnLeft() {
        getState().setDirection(Direction.NUM_2_DIRECTION.get((getState().getDirection().getNum()+3)%4));
    }

    public void turnRight() {
        getState().setDirection(Direction.NUM_2_DIRECTION.get((getState().getDirection().getNum()+1)%4));
    }

    public boolean move() {
        switch (getState().getDirection()) {
            case Up:
                if(getState().getRowNo()==0) return false;
                getState().setRowNo(getState().getRowNo()-1);
                break;
            case Down:
                if(getState().getRowNo() >= MazeConfig.ROW_MAX) return false;
                getState().setRowNo(getState().getRowNo()+1);
                break;
            case Left:
                if(getState().getColumnNo() <= 0) return false;
                getState().setColumnNo(getState().getColumnNo()-1);
                break;
            case Right:
                if(getState().getColumnNo() >= MazeConfig.COLUMN_MAX) return false;
                getState().setColumnNo(getState().getColumnNo()+1);
                break;
        }
        return MazeConfig.getMaze()[getState().getRowNo()][getState().getColumnNo()].isValid();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isHunter() {
        return isHunter;
    }

    public void setHunter(boolean hunter) {
        isHunter = hunter;
    }

    public List<State> getTraceList() {
        return traceList;
    }

    public void setTraceList(List<State> traceList) {
        this.traceList = traceList;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "speed=" + speed +
                ", state=" + state +
                ", isHunter=" + isHunter +
                ", traceList=" + traceList +
                '}';
    }
}
