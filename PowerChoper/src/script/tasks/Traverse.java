package script.tasks;

import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import script.data.Context;

public class Traverse extends Task {
    @Override
    public boolean validate() {
        Log.info("validating Traverse");
        return Context.isInWoodcutLocation() && !Players.getLocal().isMoving();
    }

    @Override
    public int execute() {
        Log.info("walking to woodcut location");
        Context.enableRun();
        Context.walkToWoodcutLocation();
        return Random.nextInt(400, 800);
    }
}
