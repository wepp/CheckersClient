package com.checkers.domain.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Isaiev on 24.09.2015.
 */
public class Step implements Serializable{

    public static final long serialVersionUID = 43L;

    private Check check;
    private ArrayList<Position> positionAfteMove;
    private long usedTime;

    public Step(Check check, ArrayList<Position> positionAfteMove) {
        this.check = check;
        this.positionAfteMove = positionAfteMove;
    }
    
    public Step(){};

    public Check getCheck() {
        return check;
    }

    public ArrayList<Position> getPositionAfteMove() {
        return positionAfteMove;
    }

    public void setUsedTime(long usedTime) {
        this.usedTime = usedTime;
    }

    public long getUsedTime() {
        return usedTime;
    }

    @Override
    public String toString() {
        return "Step{" +
                "check=" + check +
                ", positionAfteMove=" + positionAfteMove +
                '}';
    }
}
