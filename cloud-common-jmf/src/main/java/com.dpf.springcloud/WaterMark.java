package com.dpf.springcloud;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WaterMark {

    public final static void pressText(String text, String targetImg, int x, int y) {
        try {
            //目标文件
            File _file = new File(targetImg);
            BufferedImage src = ImageIO.read(_file);

            final int width = src.getWidth();
            final int height = src.getHeight();
            final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            final Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(Color.red);
            g.setFont(new Font("宋体", 0, 50));
            g.drawString(text, x, y);
            g.dispose();
            final FileOutputStream out = new FileOutputStream(targetImg);
            final JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static void pressPoint(String targetImg, int x, int y) {
        try {
            //目标文件
            File _file = new File(targetImg);
            BufferedImage src = ImageIO.read(_file);

            final int width = src.getWidth();
            final int height = src.getHeight();
            final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            final Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(Color.red);
            final Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 50, 50);
            g.fill(circle);
            g.dispose();
            final FileOutputStream out = new FileOutputStream(targetImg);
            final JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        pressPoint("/Users/david.dong/tmp/image/2.jpg", 100, 100);
    }
}
