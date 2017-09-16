/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.gui.ders10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author vektorel
 */
public class FileUtils {

    public static final String fileName = "E:\\data\\data.txt";

    public void readFile() {
        String kisilerMetni = "";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                kisilerMetni += scanner.nextLine();
            }
            String[] kisiDizisi = kisilerMetni.split("@");
            for (int i = 0; i < kisiDizisi.length; i++) {
                String[] detaylar = kisiDizisi[i].split("#");
                Kisi kisi = new Kisi();
                kisi.setNo(Integer.valueOf(detaylar[0]));
                kisi.setAd(detaylar[1]);
                kisi.setSoyad(detaylar[2]);
                FrmAnasayfa.kisiListe.add(kisi);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void writeToFile() throws IOException {
        //Listenin Tüm elemanlarını formatlarıp dosyaya yaz
        String sstrToFile = "";
        for (int i = 0; i < FrmAnasayfa.kisiListe.size(); i++) {
            sstrToFile += FrmAnasayfa.kisiListe.get(i).getNo() + "#"
                    + FrmAnasayfa.kisiListe.get(i).getAd() + "#"
                    + FrmAnasayfa.kisiListe.get(i).getSoyad();
            if (i != FrmAnasayfa.kisiListe.size() - 1) {
                sstrToFile += "@";
            }
        }
        FileWriter outFile = new FileWriter(fileName);

        BufferedWriter outStream = new BufferedWriter(outFile);

        

        outStream.write(sstrToFile);

        outStream.close();

        }

    }


