package script;

import org.rspeer.script.ScriptCategory;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.Task;
import org.rspeer.script.task.TaskScript;
import script.data.Rock;
import script.data.RockHandler;
import script.tasks.Banking;
import script.tasks.Mine;
import script.tasks.Traverse;

@ScriptMeta(name = "Sly Iron Miner", desc = "mines and banks iron in E Varrock", developer = "SlyCoder", version = 1.0, category = ScriptCategory.MINING)

public class Main extends TaskScript {

    /*

            **** TO CHANGE SCRIPT TO DIFFERENT PICKAXE, CHANGE THE INDEX IN BANKING & MINE'S VALIDATE & BANKING EXECUTE *****

     */

    public static final String PICKAXE = "Iron pickaxe";
    public static final String MINING_ACTION = "Mine";

    private static final Task[] TASKS = new Task[] {new Banking(), new Mine(), new Traverse()};

    @Override
    public void onStart() {
        RockHandler.ROCK = Rock.IRON;
        this.submit(TASKS);
    }

    @Override
    public void onStop(){

    }
}
