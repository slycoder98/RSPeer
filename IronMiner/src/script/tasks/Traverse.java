package script.tasks;

import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;
import script.data.Context;

public class Traverse extends Task {
    @Override
    public boolean validate() {
        return !Context.isInMiningArea() && !Players.getLocal().isMoving();
    }

    @Override
    public int execute() {
        Context.enableRun();
        Context.walkToMiningArea();
        return Context.shortSleep();
    }
}
