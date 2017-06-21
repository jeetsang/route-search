package search;

import java.util.List;

public class Route {

    private int id;
    private List<Integer> stationIds;

    public Route(int id, List<Integer> stationIds) {
        this.id = id;
        this.stationIds = stationIds;
    }

    public boolean direct(int dep, int arr) {
        return stationIds.contains(arr) && stationIds.contains(dep);
    }
}