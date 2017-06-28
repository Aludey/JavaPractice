public class Arrow {

    Line axis;
    Line leftWing;
    Line rightWing;

    public Arrow(){
        axis = new Line();
        leftWing = new Line();
        rightWing = new Line();
    }

    public Arrow(double x1, double y1, double x2, double y2){
        axis = new Line(x1, y1, x2, y2);
        leftWing = new Line(x1, y1, x1+(y1-y2)/6, y1-(y1-y2)/3);
        rightWing = new Line(x1, y1, x1-(y1-y2)/6, y1-(y1-y2)/3);
    }

    public double getHeadX(){
        return axis.getX1();
    }

    public double getHeadY(){
        return axis.getY1();
    }

    public double getTailX(){
        return axis.getX2();
    }

    public double getTailY(){
        return axis.getY2();
    }

    public void setArrow(double x1, double y1, double x2, double y2){
        axis.setLine(x1, y1, x2, y2);
        leftWing.setLine(x1, y1, x1+(y1-y2)/6, y1-(y1-y2)/3);
        rightWing.setLine(x1, y1, x1-(y1-y2)/6, y1-(y1-y2)/3);
    }
}
