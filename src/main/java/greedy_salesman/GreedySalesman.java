package greedy_salesman;

import java.util.*;

public class GreedySalesman {

    private Set<Path> paths = new HashSet<>();
    private String originCity;
    private Set<String> visitedCities = new HashSet<>();

    public String visitAllCities(Set<Path> paths, String originCity) {
        this.paths = paths;
        this.originCity = originCity;

        StringBuilder route = new StringBuilder();

        System.out.println(print(paths));

        travel();

        return route.toString();
    }

    private void travel() {
        String currentCity = originCity;
        TreeSet<Path> possiblePaths = getPossiblePaths(currentCity);
        System.out.println(print(possiblePaths));
        Path cheapestPath = findCheapestPath(possiblePaths);
        System.out.println(print(cheapestPath));
    }

    private String print(Path path) {
        return "(" + path.getCityA() + ", " + path.getCityB() + ", " + path.getCost() + ")";
    }

    private String print(Set<Path> set) {
        StringBuilder builder = new StringBuilder();
        for (Path path : set) {
            builder.append("(");
            builder.append(path.getCityA());
            builder.append(", ");
            builder.append(path.getCityB());
            builder.append(", ");
            builder.append(path.getCost());
            builder.append("), ");
        }
        return builder.toString();
    }

    private Path findCheapestPath(TreeSet<Path> paths) {
        return paths.first();
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
