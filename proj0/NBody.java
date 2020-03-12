public class NBody {

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int N = in.readInt();
        in.readDouble();

        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.toString(args[0]);
        double dt = Double.toString(args[1]);
        String fliename = args[2];
        double R = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);

    }
}