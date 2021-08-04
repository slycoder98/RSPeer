package script.tasks;

import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import script.Main;
import script.data.Context;

public class Drop extends Task {

    @Override
    public boolean validate() {
        Log.info("validating Drop");
        return Context.shouldDrop();
    }

    @Override
    public int execute() {

        Log.info("Dropping logs");

        for(Item item : Inventory.getItems(x -> x != null && x.getName().equals("Logs"))){
            item.interact(Main.DROP_ACTION);
            Time.sleep(300, 500);
        }
        return Random.nextInt(600, 1300);
    }
}
