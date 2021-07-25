package script.data;

import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.ui.Log;
import script.Main;

public class Context {
    public static void enableRun() {
        Log.info("Checking run energy");
        if (Movement.getRunEnergy() > Random.nextInt(25, 55) && !Movement.isRunEnabled()){
            Log.info("Enabling run");
            Movement.toggleRun(true);
        }
    }

    public static boolean isInMiningArea(){
        Log.info("Checking if miningArea contains LocalPlayer");
        return Location.miningArea.getArea().contains(Players.getLocal());
    }

    public static void walkToMiningArea(){
        Log.info("Walking to mining area");
        Movement.getDaxWalker().walkTo(Location.miningArea.getArea().getTiles().get(Random.nextInt(0, Location.miningArea.getArea().getTiles().size() - 1)));
    }

    public static boolean isInBankingArea(){
        Log.info("checking if bank area contains local player");
        return Location.bankingArea.getArea().contains(Players.getLocal());
    }

    public static void walkToBankArea(){
        Log.info("Walking to bank area");
        Movement.getDaxWalker().walkTo(Location.bankingArea.getArea().getTiles().get(Random.nextInt(0, Location.bankingArea.getArea().getTiles().size() - 1)));
    }

    public static boolean shouldBank(){
        Log.info("Validating shouldBank()");
        return Inventory.isFull() || Bank.isOpen();
    }

    public static void depositOre(){
        Bank.depositAllExcept(Main.PICKAXE);
    }

    public static boolean hasPickaxe(){
        Log.info("Checking if inventory has pickaxe");
        return Inventory.contains(Main.PICKAXE);
    }

    public static boolean bankHasPickaxe(){
        Log.info("Checking if bank has pickaxe");
        return Bank.contains(Main.PICKAXE);
    }

    public static void withdrawPickaxe(){
        Bank.withdraw(Main.PICKAXE, 1);
    }

    public static int shortSleep(){
        return Random.nextInt(300, 500);
    }


}
