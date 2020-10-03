
public class Planet {

	private double x;
	private double y;
	private long mass;
	private double xVel = 0;
	private double yVel = 0;
	public final double G = 1;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Planet(int x, int y, long m, double v) {

		this.x = x;
		this.y = y;
		this.xVel = v;
		mass = m;

	}

	public void updateV(Planet p2) {

		if (this == p2)
			return;

		double dx = p2.x - x; // distance on the x axis
		double dy = p2.y - y; // distance on the y axis
		double d = Math.sqrt(dy * dy + dx * dx);
		double directionX = dx != 0?dx/Math.abs(dx):1;
		double directionY = dy != 0?dy/Math.abs(dy):1;

		if (d >= 10) {
			double F = (G * mass * p2.mass) / (d * d);

			double angle = Math.atan(dy / dx);

			double Fx = F * Math.cos(angle);
			double Fy = F * Math.sin(angle);

			double ax = directionX*Math.abs(Fx) / mass;
			double ay = directionY*Math.abs(Fy) / mass;

			yVel += ay;
			xVel += ax;

		}

	}

	public void updatePos() {

		x += xVel;
		y += yVel;

	}

}
