public class Planet {
    
    private static final double G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;



    public Planet(double xP, double yP,
    double xV, double yV, double m, String img) {
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
    
    public double calcDistance (Planet p) {
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        return r;
    }
    
    public double calcForceExertedBy (Planet p) {
        double dis = this.calcDistance (p);
        double F = G * this.mass * p.mass / ( dis * dis );
        return F;
        
    }
    
    public double calcForceExertedByX (Planet p) {
        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
        
    }

    public double calcForceExertedByY (Planet p) {
        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double sum = 0;
        for (int i = 0; i < planets.length; ++i) {
            Planet p = planets[i];
          /* don't calc the forces exerted by itself */
            if (this.equals(p)) {
                continue;
            }
            sum += this.calcForceExertedByX(p);
            }
            return sum;
        }
    
    public double calcNetForceExertedByY(Planet[] planets) {
        double sum = 0;
        for (Planet p: planets) {
            /* don't calc the forces exerted by itself */
            if (this.equals(p)) {
                continue;
            }
            sum += this.calcForceExertedByY(p);
        }
        return sum;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;

        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;


    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
        
    }

}