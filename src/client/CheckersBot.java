package client;

import vo.Field;
import vo.Step;

/**
 * Created by Isaiev on 01.10.2015.
 */
public class CheckersBot implements ICheckersBot {

    @Override
    public Step calculateNextStep(Field currentField) {
        return new Step();
    }
}
