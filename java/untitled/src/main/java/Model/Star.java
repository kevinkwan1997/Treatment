package Model;

import java.util.List;

public class Star {

    private int id;
    private String name;
    private int distanceFromEarth;


    public Star(int id, String name, int distanceFromEarth) {
        this.id = id;
        this.name = name;
        this.distanceFromEarth = distanceFromEarth;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public void setDistanceFromEarth(int distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }

}
