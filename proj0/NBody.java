


public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        int numPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int numPlanets = in.readInt();
        double radius = in.readDouble();
        Planet[] planetArray = new Planet[numPlanets];
        for(int i =0; i<numPlanets; i++){
            double xParray = in.readDouble();
            double yParray = in.readDouble();
            double xVarray = in.readDouble();
            double yVarray = in.readDouble();
            double marray = in.readDouble();
            String imagefile = in.readString();
            planetArray[i] = new Planet(xParray, yParray,xVarray, yVarray, marray, imagefile);
        }
        return planetArray;
    }

    public static void main(String[] args) {
        /*
         * Collecting All Needed Input
         * */

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        double time = 0;
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planetArray = readPlanets(filename);


        StdDraw.enableDoubleBuffering();


        /*
         * Drawing the Background
         * */
        //StdDraw.setScale(-radius, radius);
        //StdDraw.clear();
        //StdDraw.picture(0,0, "images/starfield.jpg");


        while (time < T) {

            double[] xForces = new double[planetArray.length];
            double[] yForces = new double[planetArray.length];

            for (int i = 0; i < planetArray.length; ++i) {
                Planet p1 = planetArray[i];
                xForces[i] = p1.calcNetForceExertedByX(planetArray);
                yForces[i] = p1.calcNetForceExertedByY(planetArray);
            }

            //update
            for (int i = 0; i < planetArray.length; i++) {
                Planet p2 = planetArray[i];
                p2.update(dt, xForces[i], yForces[i]);
                drawBackground(radius);
                drawPlanets(planetArray);
                StdDraw.show();
                StdDraw.pause(1);
            }
            time += dt;
            //System.out.println(time);
        }
        StdOut.printf("%d\n", planetArray.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planetArray.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planetArray[i].xxPos, planetArray[i].yyPos, planetArray[i].xxVel,
                    planetArray[i].yyVel, planetArray[i].mass, planetArray[i].imgFileName);
        }









    }
    private static void drawBackground(double r) {
        // Drawing the Background
        StdDraw.setScale(-r, r);
        StdDraw.clear();
        StdDraw.picture(0,0, "images/starfield.jpg");}

    /*
     * Drawing all the planets
     * */

    private static void drawPlanets(Planet[] planets) {
        for (Planet p : planets) {
            p.draw();
        }
    }

}


