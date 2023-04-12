package com.arthas.maze.entity;

public class State {
    private Direction direction;
    private int rowNo;
    private int columnNo;
    public State(Direction direction, int rowNo, int columnNo){
        this.direction = direction;
        this.rowNo = rowNo;
        this.columnNo = columnNo;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }

    @Override
    public String toString() {
        return "State{" +
                "direction=" + direction +
                ", rowNo=" + rowNo +
                ", columnNo=" + columnNo +
                '}';
    }
}
