package com.skillmatch.util;

import java.io.*;
import java.net.URL;

/**
 * Created by agermenos on 7/6/16.
 */
public class HttpDownloader {
    public static void main(String args[]){
        try {
            HttpDownloader httpDL = new HttpDownloader();
            StringBuilder sb = new StringBuilder();
            URL url = new URL("http://www.hypno-fetish.com/public/music_song/da/21/01/11fba_71ba.mp3?c=8d62");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            httpDL.writeFile("princessMaker.mp3", sb);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void writeFile(String fileName, StringBuilder data){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(data.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
