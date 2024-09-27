package com.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileInputOutputStream {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos=new FileOutputStream("Tops1.txt");
        String s="This is Input/Output Stream demo";
        byte b[]=s.getBytes();
        fos.write(b);
        fos.flush();
        fos.close();
        System.out.println("File Writen Successfully");

        FileInputStream fis=new FileInputStream("Tops1.txt");
        int i;
        while((i=fis.read())!=-1){
            System.out.print((char)i);
        }
        fis.close();
    }
}
