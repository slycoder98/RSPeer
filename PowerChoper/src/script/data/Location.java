package script.data;

import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.movement.position.Position;

public enum Location {
    w_area(Area.rectangular(3185, 3254, 3205, 3238), "Tree");

    Location(Area area, String... trees){
        this.area = area;
        this.trees = trees;
    }
    private final String[] trees;
    private final Area area;

    public String[] getTrees(){
        return trees;
    }

    public Area getArea(){
        return area;
    }

    public static Location woodcutLocation = Location.w_area;
}
