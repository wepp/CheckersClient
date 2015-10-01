package client;

import vo.Field;
import vo.Step;

/**
 * Created by Isaiev on 01.10.2015.
 */
public interface ICheckersBot {
    Step calculateNextStep(Field currentField);
}
