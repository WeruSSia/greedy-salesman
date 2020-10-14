import greedy_salesman.GreedySalesman;
import greedy_salesman.Path;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader file = getInputFile();

        String originCity = file.readLine();
        Set<Path> paths = getPaths(file);
        if (isGraphValid(paths)) {
            System.out.print(new GreedySalesman(paths, originCity).travel());
        } else {
            System.out.println("The graph is not valid!");
        }
    }

    private static BufferedReader getInputFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input file:");
        String fileName = scanner.next();
        return new BufferedReader(new FileReader(fileName));
    }

    private static Set<Path> getPaths(BufferedReader file) throws IOException {
        Set<Path> paths = new HashSet<>();
        String line = file.readLine();
        while (line != null) {
            String[] path = line.split(",");
            paths.add(new Path(path[0], path[1], Integer.valueOf(path[2])));
            line = file.readLine();
        }
        return paths;
    }

    private static Boolean isGraphValid(Set<Path> paths) {
        Map<String, Integer> validatorMap = new HashMap<>();

        Set<String> cities = new HashSet<>();
        paths.forEach(path -> {
                    cities.add(path.getCityA());
                    cities.add(path.getCityB());
                }
        );

        cities.forEach(city -> validatorMap.put(city, 0));

        paths.forEach(path -> {
                    validatorMap.put(path.getCityA(), validatorMap.get(path.getCityA() + 1));
                    validatorMap.put(path.getCityB(), validatorMap.get(path.getCityB() + 1));
                }
        );

        for (Integer value : validatorMap.values()) {
            if (value != cities.size() - 1) {
                return false;
            }
        }

        return true;
    }
}
