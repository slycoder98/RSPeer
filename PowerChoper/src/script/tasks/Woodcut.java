package script.tasks;


import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import script.Main;
import script.data.Context;
import script.data.Location;

public class Woodcut extends Task {
    @Override
    public boolean validate() {
        Log.info("validating woodcut");
        return Context.isInWoodcutLocation() && !Players.getLocal().isAnimating();
    }

    @Override
    public int execute() {
        SceneObject tree = SceneObjects.getNearest(x -> x.getName().equals("Tree"));
        if (Location.woodcutLocation.getArea().contains(tree) && tree.containsAction(Main.WOODCUT_ACTION)){
            tree.interact(Main.WOODCUT_ACTION);
            Time.sleepUntil(() -> !Context.exists(tree), 8000);
        }
        return Random.nextInt(400, 700);
    }

}
