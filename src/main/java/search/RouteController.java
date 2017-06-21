package search;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    @RequestMapping("api/direct")
    public DirectRoute directRoute(
            @RequestParam(value = "dep_sid") int dep_sid,
            @RequestParam(value = "arr_sid") int arr_sid) {
        DirectRouteSearch directRouteSearch = new DirectRouteSearch(RouteSupplier.getInstance());
        return directRouteSearch.directRoot(dep_sid, arr_sid);
    }
}