/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.imageio.ImageIO;
import static resolveimage.ImageSub.comparesingleCharOCR;

/**
 *
 * @author Administrator
 */
public class test {
    public static void hello(String[] args) {
        Set<String>Zi=ziku.ZIs.keySet();
        Iterator<String> iter= Zi.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
            ziku.Print_zi(ziku.ZIs.get(next));
        }
       
    }
    
    
    public static void main(String[] args) throws IOException {
//        File file = new File("E:\\4.png");
//        BufferedImage bi = ImageIO.read(file);
//        ziku.Print_zi(imageTest.getErZhiHua(bi));
     File files = new File("D:\\OCR\\test\\c_50725.png");  
         
          File filetmp = new File("D:\\OCR\\test1\\");  
          if(!filetmp.exists())filetmp.mkdirs();
          
        int x=0;
        if(files.isDirectory()){
        for(File file:files.listFiles()){
            
             BufferedImage bi = ImageIO.read(file);
        String a=comparesingleCharOCR(bi);
        ImageIO.write(bi, "png", new File("D:\\OCR\\test1\\"+a+"_"+x++ +".png"));
        }
    }else {
             BufferedImage bi = ImageIO.read(files);
        String a=comparesingleCharOCR(bi);
            System.out.println(a);
        }
    }
}
