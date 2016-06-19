/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class ImageSub {
    /**
     * 
     * 得到分割后的图片
     * @param img
     * @return 
     */
    public static List<BufferedImage>splitImage(BufferedImage img){
    List<BufferedImage> subImages=new ArrayList<BufferedImage>();
    subImages.add(img.getSubimage(3, 5, 12, 16));
    subImages.add(img.getSubimage(17, 5, 12, 16));
    subImages.add(img.getSubimage(31, 5, 12, 16));
    subImages.add(img.getSubimage(45, 5, 12, 16));
    return subImages;
    
    }
    
    public static String comparesingleALLCharOCR(BufferedImage img) throws IOException{
        String a=comparesingleCharOCR(img.getSubimage(3, 5, 12, 16));
        String b=comparesingleCharOCR(img.getSubimage(17, 5, 12, 16));
        String c=comparesingleCharOCR(img.getSubimage(31, 5, 12, 16));
        String d=comparesingleCharOCR(img.getSubimage(45, 5, 12, 16));
        
      return a+b+c+d;
    
    }
    /**
     * 
     * @param img
     * @return
     * @throws IOException 
     */
    public static String   comparesingleCharOCR(BufferedImage img) throws IOException{
        int start[][]=imageTest.getErZhiHua(img);
        Set<String>Zi=ziku.ZIs.keySet();
        Iterator<String> iter= Zi.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
           System.out.println("-----------"+next);
           // ziku.Print_zi(ziku.ZIs.get(next));
            
            int count=0;
            int src[][]=ziku.ZIs.get(next);
            for(int i=0;i<16;i++){
            for(int j=0;j<12;j++){
                if(1==src[i][j]&&1==start[i][j]){
                count++;
                }
            }
            }
            //
            System.out.println("count++="+count);
            
            int num=ziku.getZi_count(next);
            //
            System.out.println("num====="+num);
            float tmp=(float)count/num;
            if("c".equals(next)){
            if((tmp>0.97)){
                //处理c d g  的d
                 {
                   if(next.equals("c")){
                              int m=0;
                             for(int k=0;k<3;k++){
                                 for(int l =7;l<10;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                if(m>5)return "d";
                }
                }
                 //处理cdg 的g
                  {
                   if(next.equals("c")){
                              int m1=0;
                             for(int k=14;k<16;k++){
                                 for(int l =3;l<9;l++){
                                    if(start[k][l]==1)m1++;
                                     }
                                 } 
                             int q=0;
                              for(int k=14;k<16;k++){
                                 for(int l =8;l<10;l++){
                                    if(start[k][l]==1)q++;
                                     }
                                 } 
                            
                if(m1>7&&q<2){
                    System.out.println(next+"----1111111111111111111111111111-----------G--1"+"m="+m1+"q=="+q);
                    return "g";
                }
                }
                }
                  //处理q
                   {
                   if(next.equals("c")){
                              int m=0;
                             for(int k=14;k<16;k++){
                                 for(int l =6;l<11;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                if(m>6)return "q";
                }
                    if(next.equals("c")){
                              int m=0;
                             for(int k=6;k<8;k++){
                                 for(int l =3;l<8;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                if(m>7)return "e";
                }
                }
                return next;}
           
            }
            else 
                if("3".equals(next)){
                if((tmp>0.89))return next;
                }else 
                if("q".equals(next)){
                    
                if((tmp>0.95))return next;
                
                }else if("6".equals(next)){
                if((tmp>0.832))return next;
                } else if("4".equals(next)){
                if((tmp>0.852))return next;
                }else if("w".equals(next)){
                if((tmp>0.84))return next;
                }else if("2".equals(next)){
                if((tmp>0.88))return next;
                }
                else if(tmp>0.89){
                    //处理V和y不一样
                    {
                   if(next.equals("v")){
                              int m=0;
                             for(int k=14;k<16;k++){
                                 for(int l =1;l<8;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                if(m>7)return "y";else return "v";
                }
                }
                    //q和g
                     {
                   if(next.equals("g")){
                              int m=0;
                             for(int k=14;k<16;k++){
                                 for(int l =8;l<11;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                             System.out.println("----00000000000000000000000000000000000000----q---g");
                if(m>4)return "q";else return "g";
                }
                }
                     {
                     if(next.equals("c")){
                              int m=0;
                             for(int k=6;k<8;k++){
                                 for(int l =3;l<8;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                if(m>7)return "e";
                }
                     }
                      {
                   if(next.equals("g")){
                              int m=0;
                              int q=0;
                             for(int k=14;k<16;k++){
                                 for(int l =3;l<8;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                              for(int k=14;k<16;k++){
                                 for(int l =8;l<11;l++){
                                    if(start[k][l]==1)q++;
                                     }
                                 } 
                              System.out.println("G--1");
                if(m>7&&q<3)return "g";else return "q";
                }
                   }
                         {
                   if(next.equals("h")||next.equals("n")){
                              int m=0;
                            
                             for(int k=0;k<3;k++){
                                 for(int l =1;l<4;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                            
                              System.out.println("G--1"+m);
                if(m>6)return "h";else return "n";
                }
                   }
                    
                return next;
                }
        }
        return ImageOCRTwoErCi(img);
      // return "#";
    }
    
    public static String ImageOCRTwoErCi(BufferedImage img) throws IOException{
     int start[][]=imageTest.getErZhiHua(img);
        Set<String>Zi=ziku.ZIs.keySet();
        Iterator<String> iter= Zi.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
           System.out.println("-----------"+next);
           // ziku.Print_zi(ziku.ZIs.get(next));
            
            int count=0;
            int src[][]=ziku.ZIs.get(next);
            for(int i=0;i<16;i++){
            for(int j=0;j<12;j++){
                if(1==src[i][j]&&1==start[i][j]){
                count++;
                }
            }
            }
            //
            System.out.println("count++="+count);
            
            int num=ziku.getZi_count(next);
            //
            System.out.println("num====="+num);
            float tmp=(float)count/num;
            if(tmp>0.80){
                 {
                   if(next.equals("c")){
                              int m=0;
                             for(int k=0;k<3;k++){
                                 for(int l =7;l<10;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                if(m>5)return "d";
                }
                }
                 //处理cdg 的g
                  {
                   if(next.equals("c")){
                              int m=0;
                             for(int k=14;k<16;k++){
                                 for(int l =3;l<8;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                if(m>7)return "g";
                }
                }
                  //处理q
                   {
                   if(next.equals("c")){
                              int m=0;
                             for(int k=14;k<16;k++){
                                 for(int l =6;l<11;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                if(m>6)return "q";
                }
                }
                   {
                   if(next.equals("g")){
                              int m=0;
                              int q=0;
                             for(int k=14;k<16;k++){
                                 for(int l =3;l<8;l++){
                                    if(start[k][l]==1)m++;
                                     }
                                 } 
                              for(int k=14;k<16;k++){
                                 for(int l =8;l<11;l++){
                                    if(start[k][l]==1)q++;
                                     }
                                 } 
                if(m>7&&q<3)return "g";else return "q";
                }
                   }
                return next;
            }
    }
        return "#";
    }
    public static void main(String[] args) throws IOException {
        File files = new File("D:\\OCR\\hello\\"); 
        
        int x=0;
        File filetmp=new File("D:\\OCR\\test");
        if(!filetmp.exists())filetmp.mkdirs();
        
        if(files.isDirectory()){
        for(File file:files.listFiles()){
            
             BufferedImage bi = ImageIO.read(file);
        String a=comparesingleCharOCR(bi);
            System.out.println("正在处理图片"+x+"张");
        ImageIO.write(bi, "png", new File("D:\\OCR\\test\\"+a+"_"+x++ +".png"));
        }
//        // File files = new File("E:\\3.png");
//        BufferedImage bi = ImageIO.read(files);
//        String a=comparesingleCharOCR(bi);
//        System.out.println(a);
    }
}
}
