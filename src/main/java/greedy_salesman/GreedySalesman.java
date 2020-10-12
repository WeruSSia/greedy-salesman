package greedy_salesman;

import java.util.*;

public class GreedySalesman {

    private Set<Path> paths;
    private String originCity;
    private Set<String> visitedCities = new HashSet<>();
    private StringBuilder route;
    private int routeCost;
    private String currentCity;

    public GreedySalesman(Set<Path> paths, String originCity) {
        this.paths = paths;
        this.originCity = originCity;
    }

    public String travel() {
        route = new StringBuilder();
        routeCost = 0;
        currentCity = originCity;
        while (!getPossiblePaths(currentCity).isEmpty()) {
            visit();
        }
        visitedCities.remove(originCity);

        visit();

        route.append(currentCity).append("   ").append(routeCost);

        return route.toString();
    }

    private void visit() {
        Path cheapestPath = getCheapestPath(currentCity);
        visitedCities.add(currentCity);
        route.append(currentCity).append(" - ");
        routeCost += cheapestPath.getCost();
        currentCity = cheapestPath.getDestinationCity(currentCity);
    }

    private Path getCheapestPath(String city) {
        return getPossiblePaths(city).first();
    }

    private TreeSet<Path> getPossiblePaths(String city) {
        TreeSet<Path> possiblePaths = new TreeSet<>();
        for (Path path : paths) {
            if (path.contains(city) && !visitedCities.contains(path.getDestinationCity(city))) {
                possiblePaths.add(path);
            }
        }
        return possiblePaths;
    }

}
