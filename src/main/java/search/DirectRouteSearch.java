package search;

import java.util.stream.Stream;

public class DirectRouteSearch {
    private final RouteSupplier routeSearchProvider;

    public DirectRouteSearch(RouteSupplier routeSearchProvider) {
        this.routeSearchProvider = routeSearchProvider;
    }

    public DirectRoute directRoot(int dep_sid, int arr_sid) {
        Stream<Route> routes = routeSearchProvider.routes().stream();
        return new DirectRoute(dep_sid, arr_sid, routes.anyMatch(route -> route.direct(dep_sid, arr_sid)));
    }
}
