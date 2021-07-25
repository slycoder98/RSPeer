package script.tasks;

import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import script.Main;
import script.data.Context;
import script.data.Location;
import script.data.RockHandler;

public class Mine extends Task {

    public static boolean isMining;

    public static boolean isMining() {
        return isMining;
    }

    public static void setMining(boolean mining) {
        isMining = mining;
    }

    @Override
    public boolean validate() {
        return Context.isInMiningArea() && Context.hasPickaxe() && !Players.getLocal().isAnimating();
    }

    @Override
    public int execute() {
        SceneObject rock = RockHandler.getValidRock();
        if(rock != null && Location.miningArea.getArea().contains(rock)){
            Log.info("validating rock");
            rock.interact(Main.MINING_ACTION);
            setMining(true);
            Log.info("mining rock");
        }
        Time.sleepUntil(() -> !isMining(), 2500 );
        return Context.shortSleep();
    }
}
