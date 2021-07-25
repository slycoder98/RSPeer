package script.tasks;

import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import script.data.Context;

public class Banking extends Task {
    @Override
    public boolean validate() {
        return Context.shouldBank() || !Context.hasPickaxe();
    }

    @Override
    public int execute() {
        Log.info("checking if in bank area");
        if (!Context.isInBankingArea()){
            Context.enableRun();
            Log.info("walking to bank area");
            Context.walkToBankArea();
            Time.sleepUntil(() -> Context.isInBankingArea(), 10000);
        }
        if (!Bank.isOpen()){
            Log.info("Opening bank");
            Bank.open();
            Context.shortSleep();
        }
        if (Bank.isOpen()){
            Log.info("depositing ore");
            Context.depositOre();
            if (!Context.hasPickaxe() && Context.bankHasPickaxe()){
                Context.withdrawPickaxe();
            }
            Context.shortSleep();
        }
        Log.info("already had axe, ore deposited, closing bank");
        Bank.close();
        return Context.shortSleep();
    }
}
