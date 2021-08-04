package script.data;

import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import script.Main;

public class Context {

    public static int shortSleep(){
        return Random.nextInt(297, 603);
    }

    public static boolean shouldDrop(){
        return Inventory.isFull() && !Players.getLocal().isAnimating();
    }

    public static boolean isInWoodcutLocation(){
        return !Location.woodcutLocation.getArea().contains(Players.getLocal());
    }

    public static void walkToWoodcutLocation(){
        Movement.getDaxWalker().walkTo(Location.woodcutLocation.getArea().getTiles().get(Random.nextInt(0, Location.woodcutLocation.getArea().getTiles().size() - 1)));
    }

    public static void enableRun(){
        if(Movement.getRunEnergy() > Random.nextInt(30, 65) && !Movement.isRunEnabled()){
            Movement.toggleRun(true);
        }
    }

    public static boolean exists(SceneObject object) {
        return SceneObjects.getNearest(t -> t == object) != null;
    }




}
