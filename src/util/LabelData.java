package util;
/** 
* @author: jan 
* @date: 2018年5月23日 下午5:17:22 
*/
public class LabelData {

	private double left;
	private double top;
	private double angle;
	private double scaleX;
	private double scaleY;
	private double radius;
	private double strokeWidth;
	private int red;
	private int green;
	private int blue;
	private double opacity;
	public double getLeft() {
		return left;
	}
	public void setLeft(double left) {
		this.left = left;
	}
	public double getTop() {
		return top;
	}
	public void setTop(double top) {
		this.top = top;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getScaleX() {
		return scaleX;
	}
	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}
	public double getScaleY() {
		return scaleY;
	}
	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getStrokeWidth() {
		return strokeWidth;
	}
	public void setStrokeWidth(double strokeWidth) {
		this.strokeWidth = strokeWidth;
	}
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	public double getOpacity() {
		return opacity;
	}
	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}
	public LabelData(double left, double top, double angle, double scaleX, double scaleY, double radius,
			double strokeWidth, int red, int green, int blue, double opacity) {
		super();
		this.left = left;
		this.top = top;
		this.angle = angle;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.radius = radius;
		this.strokeWidth = strokeWidth;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.opacity = opacity;
	}
	@Override
	public String toString() {
		return "LabelData [left=" + left + ", top=" + top + ", angle=" + angle + ", scaleX=" + scaleX + ", scaleY="
				+ scaleY + ", radius=" + radius + ", strokeWidth=" + strokeWidth + ", red=" + red + ", green=" + green
				+ ", blue=" + blue + ", opacity=" + opacity + "]";
	}
	public LabelData() {
		super();
	}

}
