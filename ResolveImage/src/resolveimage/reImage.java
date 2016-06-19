/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveimage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class reImage {
    
   
    public static void main(String[] args) {
         String urlString="<img border=\"0\" src=\"http://211.69.32.174/logins/zzjlogin2.dll/zzjgetimg?pid=F1A1E0143711484FA28EBB7F33675127\" width=\"60\" height=\"25\"></td>";
    Pattern pattern = Pattern.compile("\\w{32}");
        Matcher m = pattern.matcher(urlString);
   
    String pid = pattern.matcher(urlString).group();
        System.out.println(pid);
    
    
    }
}
