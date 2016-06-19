/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveimage;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class imageTest {
    public static void main(String[] args) throws IOException {
        File files=new File("E:png.png");
        File file1 = new File("E:1.png");
        if(files.isDirectory()){
        for(File file:files.listFiles()){
          // getErZhiHua(file);
        }
        }//else getErZhiHua(files);
        System.out.println("-------------------------------------");
        BufferedImage bi = ImageIO.read(files);
        BufferedImage img= bi.getSubimage(3, 5, 12, 16);
     ImageIO.write(img, "png", file1);
        int h = img.getHeight();
        int w=img.getWidth();
        for(int i=0;i<h;i++){
        for(int j=0;j<w;j++){
           if(bi.getRGB(j, i)==-256){
               System.out.print("0");
           }
           else{ System.out.print("1");
           
           
           }
           // System.out.print(bi.getRGB(j, i)==-256?"0" :"1");
        }
            System.out.println(""); 
    }
    }
    public static int[][] getErZhiHua( BufferedImage bi) throws IOException {
       /// File file = new File("E:\\png.png");
        
     //   BufferedImage bi = ImageIO.read(file);
        int h = bi.getHeight();
        int w=bi.getWidth();
        int a[][] = new int[h][w];
        int rgb=bi.getRGB(0, 0);
        int x=0;
       // int arr[][]=new int[w][h];
       // int x = bi.getRGB(2, 4);
       // System.out.println(x);
        for(int i=0;i<h;i++){
        for(int j=0;j<w;j++){
         a[i][j]=  bi.getRGB(j, i)==-256?0:1;
          
           }
          
        }
        return a;   
    
        
    }
}
