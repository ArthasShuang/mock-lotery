package com.arthas.maze.util;

import com.arthas.maze.entity.Cat;
import com.arthas.maze.entity.Direction;
import com.arthas.maze.entity.State;

import java.util.*;
import java.util.stream.Collectors;

public class Rule {
    private static final State illegalState = new State(Direction.Up, -1, -1);
    public static void catching(Cat cat1, Cat cat2){
        Cat catchedCat = cat1.isHunter()? (cat2.isHunter()? null:cat2):cat1;
        Cat hunterCat = Objects.equals(cat1, catchedCat)? cat2:cat1;
        if(catchedCat != null) {
            List<State> traceList1 = expandTrace(catchedCat.getTraceList());
            List<State> traceList2 = expandTrace(hunterCat.getTraceList());
            int catchStep = compareTrace(traceList1, traceList2);
            if(catchStep>0) {
                boolean isMeeting = !Objects.equals(traceList1.get(catchStep), traceList2.get(catchStep));
                if (isMeeting) {
                    turnOpposite(catchedCat, traceList1, catchStep);
                    turnOpposite(hunterCat, traceList2, catchStep);
                } else {
                    turnOpposite(catchedCat, traceList1, catchStep);
                    hunterCat.setTraceList(hunterCat.getTraceList().subList(0, catchStep));
                    hunterCat.setTraceList(hunterCat.getTraceList().stream().filter(state -> !Objects.equals(state, illegalState)).collect(Collectors.toList()));
                    hunterCat.setState(traceList2.get(catchStep));
                }
                catchedCat.action(false);
                hunterCat.action(false);
            }
        }
    }

    private static void turnOpposite(Cat cat, List<State> traceList, int catchStep) {
        cat.setTraceList(traceList.subList(0, catchStep));
        traceList.get(catchStep).setDirection(Direction.NUM_2_DIRECTION.get((traceList.get(catchStep).getDirection().getNum()+2)%4));
        cat.setTraceList(cat.getTraceList().stream().filter(state -> !Objects.equals(state, illegalState)).collect(Collectors.toList()));
        cat.setState(traceList.get(catchStep));
        cat.setHunter(!cat.isHunter());
    }

    private static int compareTrace(List<State> traceList1, List<State> traceList2) {

        for(int i = 0; i< traceList1.size(); i++){
            if(!Objects.equals(traceList1.get(i), illegalState) && Objects.equals(traceList1.get(i).getRowNo(), traceList2.get(i).getRowNo())){
                return i;
            }
        }
        return 0;
    }

    private static List<State> expandTrace(List<State> traceList) {

        if(traceList.size()==2){
            traceList = Arrays.asList(traceList.get(0), illegalState, illegalState, illegalState, traceList.get(1));
        }else if(traceList.size()==3){
            traceList = Arrays.asList(traceList.get(0), illegalState, traceList.get(1), illegalState, traceList.get(2));
        }else if(traceList.size()==5){
            return traceList;
        }else {
            traceList = Arrays.asList(illegalState, illegalState, illegalState, illegalState, illegalState);
        }
        return traceList;
    }
}
