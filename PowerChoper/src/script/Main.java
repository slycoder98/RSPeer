package script;

import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.ScriptCategory;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.TaskScript;
import script.tasks.Drop;
import script.tasks.Traverse;
import script.tasks.Woodcut;

@ScriptMeta(name = "Sly Power Chopper", desc = "power chops normal trees in lumb", developer = "SlyCoder", version = 1.0, category = ScriptCategory.WOODCUTTING)

public class Main extends TaskScript {

    public static final String TREE = "Tree";
    public static final String AXE = "Bronze axe";
    public static final String WOODCUT_ACTION = "Chop down";
    public static final String DROP_ACTION = "Drop";
    public static final Player LOCAL_PLAYER = Players.getLocal();

    @Override
    public void onStart() {
        submit(
                new Drop(),
                new Woodcut(),
                new Traverse()
        );
    }

    @Override
    public void onStop(){

    }
}
