package script.data;

import org.rspeer.runetek.api.movement.position.Area;

public enum Location {

    M_AREA(Area.rectangular(3282, 3370, 3289, 3361)),
    B_AREA(Area.rectangular(3251, 3421, 3255, 3420));

    private final Area AREA;

    Location (Area AREA){
        this.AREA = AREA;
    }

    public Area getArea(){
        return AREA;
    }

    public static Location miningArea = Location.M_AREA;

    public static Location bankingArea = Location.B_AREA;

}
