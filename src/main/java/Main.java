import greedy_salesman.GreedySalesman;
import greedy_salesman.Path;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader file = getInputFile();

        String originCity = file.readLine();
        Set<Path> paths = getPaths(file);

        System.out.print(new GreedySalesman(paths, originCity).travel());
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
}
