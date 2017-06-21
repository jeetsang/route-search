package search;

public class DirectRoute {
    private int dep_sid;
    private int arr_sid;
    private boolean direct_bus_route;

    public DirectRoute(int dep_sid, int arr_sid, boolean direct_bus_route) {
        this.dep_sid = dep_sid;
        this.arr_sid = arr_sid;
        this.direct_bus_route = direct_bus_route;
    }

    public int getArr_sid() {
        return arr_sid;
    }

    public boolean isDirect_bus_route() {
        return direct_bus_route;
    }

    public int getDep_sid() {
        return dep_sid;
    }
}
