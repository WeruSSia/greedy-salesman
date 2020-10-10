import greedy_salesman.GreedySalesman;
import greedy_salesman.Path;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Path> paths = new HashSet<>();
        paths.add(new Path("A", "B", 1));
        paths.add(new Path("B", "C", 5));
        paths.add(new Path("A","C",4));
        paths.add(new Path("B","D",2));
        paths.add(new Path("A","D",3));
        paths.add(new Path("D","C",6));

        new GreedySalesman().visitAllCities(paths,"A");
    }
}
