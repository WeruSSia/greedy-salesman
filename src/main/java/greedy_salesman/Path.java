package greedy_salesman;

public class Path implements Comparable<Path> {

    private String cityA;
    private String cityB;
    private Integer cost;

    public Path(String cityA, String cityB, Integer cost) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public String getCityA() {
        return cityA;
    }

    public String getCityB() {
        return cityB;
    }

    Boolean contains(String city) {
        return city.equals(cityA) || city.equals(cityB);
    }

    String getDestinationCity(String sourceCity) {
        if (sourceCity.equals(cityA)) {
            return cityB;
        } else if (sourceCity.equals(cityB)) {
            return cityA;
        }
        return null;
    }

    @Override
    public int compareTo(Path path) {
        return Integer.compare(cost, path.getCost());
    }
}
