/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class test_OCR {
    public static void main(String[] args) throws IOException {
        //打开验证码文件夹
        File files=new File("E:\\images");
        //打开识别的验证码文件夹
        File fileOcr = new File("E:\\image-ocr\\");
        //如果不存在则创建
        if(!fileOcr.exists())fileOcr.mkdirs();
        
        
        int i=0;
        if(files.isDirectory()){ 
        for(File file:files.listFiles()){
            BufferedImage bi = ImageIO.read(file);
           String a = ImageSub.comparesingleALLCharOCR(bi);
           ImageIO.write(bi, "png", new File("E:\\image-ocr\\"+a+"___"+i+++".png"));
        }
        }
    }
}
