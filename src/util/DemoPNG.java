package util;
/** 
* @author: jan 
* @date: 2018年5月17日 下午3:33:05 
*/
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import javax.imageio.ImageIO;
 
public class DemoPNG {
    public static void main(String[] args) throws Exception {
        BufferedImage bi = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.WHITE);
        g2d.fillRect(0,0,600, 800);
        g2d.setPaint(Color.RED);
        Ellipse2D s1 = new Ellipse2D.Double(100, 100, 400, 600);
        g2d.draw(s1);
        AffineTransform transform = AffineTransform.getRotateInstance(Math.PI/4, 300, 400);
        Shape r1 = transform.createTransformedShape(s1);
        g2d.fill(r1);
        AffineTransform transform2 = AffineTransform.getRotateInstance(Math.PI/2, 300, 400);
        Shape r2 = transform2.createTransformedShape(s1);
        g2d.draw(r2);
        g2d.dispose();
        ImageIO.write(bi, "PNG", new File("demo.png"));
    }
}
