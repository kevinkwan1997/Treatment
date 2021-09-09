import Model.Star;

import java.lang.reflect.Array;
import java.util.*;

public class App {
    public static void main(String[] args){

        List<Star> allStars = new ArrayList<>();

        Star mercury = new Star(1, "mercury", 4214124);
        Star pluto = new Star(4, "pluto", 863267373);
        Star jupiter = new Star(2, "jupiter", 42145326);
        Star saturn = new Star(3, "saturn", 624742724);

        allStars.add(mercury);
        allStars.add(jupiter);
        allStars.add(saturn);
        allStars.add(pluto);

        System.out.println(getNearestStar(4, allStars));
    }

    public static String getNearestStar(int K, List<Star> list){

        //Can't sort a list of objects, so I use a Comparator to sort by each object's distanceFromEarth.
        Collections.sort(list, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {
                return o1.getDistanceFromEarth() - o2.getDistanceFromEarth();
            }
        });
        String str = "";
        for(int i = 0; i < K; i++){
            Star star = list.get(i);
            str += star.getName() + ", distance: " + star.getDistanceFromEarth() + "\n";

        }
        return str;



    }
}
