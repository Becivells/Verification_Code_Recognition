/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveimage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;





public class ResolveImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//       String url="http://211.69.32.174/logins/zzjlogin2.dll/zzjgetimg?pid=672F7FB6CC914CAF9C34304D38B8C890";
//        String filename="672F7FB6CC914CAF9C34304D38B8C890.bmp";
//        String savepath="D:\\";
//        imageDownLoad(url, filename, savepath);
        getURL();
    }
    /**
     * 
     * @param UrlString
     * @param filename
     * @param savePath
     * @throws Exception 
     */
    public static void imageDownLoad(String UrlString,String filename,String savePath) throws Exception{
     //构造URL   
    URL url = new URL(UrlString);
    //打开链接
    URLConnection conn = url.openConnection();
    //设置请求超时为5S
    conn.setConnectTimeout(5000);
         //输入流
        InputStream is = conn.getInputStream();
        //1k的数据缓冲
        byte[]bs=new byte[1024];
        //读取到的数据长度
        int len;
        //输出的文件流
        File sf = new File(savePath);
        if(!sf.exists()){
        sf.mkdirs();
        
        }
        OutputStream os=new FileOutputStream(sf.getPath()+File.separator+filename);
        while((len=is.read(bs) )!= -1){
        os.write(bs, 0, len);
        }
        os.close();
        is.close();
    
    }
    public static void getURL() throws MalformedURLException, IOException{
       //定义url字符串
    String urlString="http://211.69.32.174/logins/zzjlogin2.dll/zzjgetfirstpage";
    //获取的url
    URL url=new URL(urlString);
    //打开URL链接
    URLConnection conn = url.openConnection();
    InputStream is =conn.getInputStream();
        StringBuffer sb = new StringBuffer();
        String temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"gbk"));
        int i=0;
        while((temp=br.readLine())!=null){
            sb.append(temp.trim());
          if((i++)==41)  {
              System.out.println(temp);
          }
       
        }
     
    }
    
}
