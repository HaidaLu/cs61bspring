

public class Planet {
    /* Its current x position*/
    public double xxPos;
    /* Its current y position*/
    public double yyPos;
    /* Its current velocity in the x direction*/
    public double xxVel;
    /* Its current velocity in the y direction*/
    public double yyVel;
    /* Its mass*/
    public double mass;
    /* The name of the file that corresponds to the image that depicts the planet*/
    public String imgFileName;
    private double G = 6.67e-11;

    /* two Planet constructors that can initialize an instance of the Planet class*/
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        double square_r = dx*dx + dy*dy;
        double r = Math.sqrt(square_r);
        return r;
    }

    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double F = ( G * mass * p.mass)/(r*r);
        return F;
    }

    public double calcForceExertedByX(Planet p){
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double dx = p.xxPos - xxPos;
        double Fx = (F * dx) / r;
        return Fx;
    }

    public double calcForceExertedByY(Planet p){
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double dy = p.yyPos - yyPos;
        double Fy = (F * dy) / r;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double sum = 0;
        for (int i = 0; i<allPlanets.length;i++){
            if(this.equals(allPlanets[i])){
                continue;
            }
            sum += calcForceExertedByX(allPlanets[i]);
        }
        return sum;

    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double sum = 0;
        for (int i = 0; i<allPlanets.length;i++){
            if(this.equals(allPlanets[i])){
                continue;
            }
            sum += calcForceExertedByY(allPlanets[i]);
        }
        return sum;

    }

    public void update(double dt, double fX, double fY){
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+ this.imgFileName);
    }




}
