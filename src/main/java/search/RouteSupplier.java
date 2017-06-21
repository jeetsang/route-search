package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class RouteSupplier {
    private static RouteSupplier routeSupplier = null;
    private static List<Route> routes = new ArrayList<>();

    private RouteSupplier(String file) {
        buildRoutes(file);
    }

    public static RouteSupplier getInstance() {
        if (routeSupplier == null) {
            synchronized (RouteSupplier.class) {
                if (routeSupplier == null) {
                    routeSupplier = new RouteSupplier(System.getProperty("file"));
                }
            }
        }

        return routeSupplier;
    }

    private void buildRoutes(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int numberOfRoutes = Integer.parseInt(br.readLine());
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                String[] split = line.split(" ");
                int routeId = Integer.parseInt(split[0]);
                List<Integer> stations = Arrays.stream(split).skip(1).map(Integer::parseInt).collect(Collectors.toList());
                Route route = new Route(routeId, stations);
                routes.add(route);
            }

            if (count != numberOfRoutes) throw new InvalidFileContentException();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFileContentException e) {
            e.printStackTrace();
        }

    }

    public List<Route> routes() {
        return routes;
    }
}
