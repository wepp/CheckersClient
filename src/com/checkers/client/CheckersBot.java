package com.checkers.client;

import com.checkers.domain.vo.Field;
import com.checkers.domain.vo.Step;

/**
 * Created by Isaiev on 01.10.2015.
 */
public class CheckersBot extends CheckersAbstractBot {

    public CheckersBot() {
    }

    @Override
    public Step calculateNextStep(Field currentField) {
        return new Step();
    }
}
