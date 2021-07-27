package com.dpf.springcloud;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriteText {
    public static void main(String[] args) throws IOException {
        String key = "Sample";
        BufferedImage bufferedImage = new BufferedImage(170, 30,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 200, 50);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
        graphics.drawString(key, 10, 25);
        ImageIO.write(bufferedImage, "jpg", new File(
                "/Users/david.dong/tmp/image/1.jpg"));
        System.out.println("Image Created");
    }
}
