package com.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriteRead {
    public static void main(String[] args) throws Exception {
        FileWriter fw=new FileWriter("Tops2.txt");
        String s="This File is Writer/Reader demo";
        fw.write(s);
        fw.flush();
        fw.close();

        FileReader fr=new FileReader("Tops2.txt");
        int i;
        while((i=fr.read())!=-1){
            System.out.print((char)i);
        }
        fr.close();
    }
}
