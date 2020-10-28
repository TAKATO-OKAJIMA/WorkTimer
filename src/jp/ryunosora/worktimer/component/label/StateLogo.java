package jp.ryunosora.worktimer.component.label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class StateLogo extends JLabel {

    private ImageIcon workIcon;
    private ImageIcon breakIcon;

    public StateLogo() {

        this.setSize(30,30);

        this.workIcon = this.setSateIcon("image/WorkingDuke.png");
        this.breakIcon = this.setSateIcon("image/BreakingCoffee.png");
        //this.setLabelState();
    }

    private ImageIcon setSateIcon(String path){
        ClassLoader classLoader = this.getClass().getClassLoader();
        ImageIcon imageIcon = new ImageIcon(classLoader.getResource(path));
        imageIcon = this.setStateIcon(imageIcon, 20, 20);
        return imageIcon;
    }

    private ImageIcon setStateIcon(ImageIcon imageIcon, int width, int height){
        Image resizeTarget = imageIcon.getImage();
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(resizeTarget, 0, 0, width, height,null);
        g2.dispose();
        ImageIcon resized = new ImageIcon();
        resized.setImage(resizedImg);
        return resized;
    }

    public void updateIcon(boolean onWork){
        ImageIcon imageIcon;

        if(onWork){
            imageIcon = this.workIcon;
        }
        else{
            imageIcon = this.breakIcon;
        }

        this.setIcon(imageIcon);
    }
}
