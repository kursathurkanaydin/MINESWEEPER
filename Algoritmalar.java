import java.util.Random;
import java.util.Scanner;

public class Algoritmalar {
    static int[][] mayinlar2(int satir,int sutun){
        int sayi=(satir*sutun)/4;
        Random r=new Random();
        int[][] list=new int[sayi][2];
        list[0][0]=r.nextInt(satir);
        list[0][1]=r.nextInt(sutun);
        for(int i=1;i<sayi;){
            for(int j=0;j<sayi;j++){
                int a=r.nextInt(satir);
                int b=r.nextInt(sutun);
                boolean isDeger=false;
                if(!(list[j][0]==a && list[j][1]==b)){
                    isDeger=true;
                }
                if(isDeger){
                    list[i][0]=a;
                    list[i][1]=b;
                    i++;
                    j=sayi;
                }
            }
        }
        return list;
    }
    static String[][] board(int satir,int sutun,int[][] dizi){
        int a=0;
        String[][] tahta=new String[satir][sutun];
        for(int i=0;i<satir;i++){
            for(int j=0;j<sutun;j++){
                    tahta[i][j]="-";
            }
        }
        for(int i=0;i<dizi.length;i++){
            tahta[dizi[i][0]][dizi[i][1]]="*";
        }
        return tahta;
    }
    static void tahtaYazdir(String[][] dizi){
        for(int i=0;i< dizi.length;i++){
            for(int j=0;j<dizi[0].length;j++){
                if(dizi[i][j].equals("*")){
                    System.out.print("-");
                }
                else {
                    System.out.print(dizi[i][j]);
                }
            }
            System.out.println();
        }
    }
    static void tahtaYazdir2(String[][] dizi){
        for(int i=0;i< dizi.length;i++){
            for(int j=0;j<dizi[0].length;j++){
                System.out.print(dizi[i][j]);
            }
            System.out.println();
        }
    }


    static String[][] adet(String[][] dizi) {
        int x=dizi.length;
        int y=dizi[0].length;
        String[][] adetListesi = new String[x][y];
        for(int satir=0;satir<x;satir++){
            for(int sutun=0;sutun<y;sutun++){
                int adetSayisi=0;
                if(dizi[satir][sutun].equals("*")){
                    adetListesi[satir][sutun]=Integer.toString(adetSayisi);
                }
                else if(satir==0 && sutun==0){
                    if (dizi[0][1].equals("-")) {
                        adetSayisi++;
                    }
                    if (dizi[1][0].equals("-")) {
                        adetSayisi++;
                    }
                    adetListesi[satir][sutun]=Integer.toString(adetSayisi);
                }
                else if (satir==0 && sutun==y-1) {
                    if(dizi[0][y-2].equals("-")){
                        adetSayisi++;
                    }
                    if(dizi[1][y-1].equals("-")){
                        adetSayisi++;
                    }
                    adetListesi[satir][sutun] = Integer.toString(adetSayisi);
                }
                else if (satir==x-1 && sutun==0) {
                    if(dizi[x-1][1].equals("-")){
                        adetSayisi++;
                    }
                    if(dizi[x-2][0].equals("-")){
                        adetSayisi++;
                    }
                    adetListesi[satir][sutun] = Integer.toString(adetSayisi);
                }
                else if (satir==x-1 && sutun==y-1) {
                    if(dizi[x-1][y-2].equals("-")){
                        adetSayisi++;
                    }
                    if(dizi[x-2][y-1].equals("-")){
                        adetSayisi++;
                    }
                    adetListesi[satir][sutun] = Integer.toString(adetSayisi);
                }
                else if(satir==0){
                    for(int i=sutun-1;i<=sutun+1;i++){
                        if(dizi[satir][i].equals("-")){
                            adetSayisi++;
                        }
                    }
                    if(dizi[1][sutun].equals("-")){
                        adetSayisi++;
                    }
                    adetSayisi--;
                    adetListesi[satir][sutun] = Integer.toString(adetSayisi);
                } else if (satir==x-1) {
                    for(int i=sutun-1;i<=sutun+1;i++){
                        if(dizi[satir][i].equals("-")){
                            adetSayisi++;
                        }
                    }
                    if(dizi[satir-1][sutun].equals("-")){
                        adetSayisi++;
                    }
                    adetSayisi--;
                    adetListesi[satir][sutun] = Integer.toString(adetSayisi);
                } else if (sutun==0) {
                    for(int i=satir-1;i<=satir+1;i++){
                        if(dizi[i][sutun].equals("-")){
                            adetSayisi++;
                        }

                    }
                    if(dizi[satir][1].equals("-")){
                        adetSayisi++;
                    }
                    adetSayisi--;
                    adetListesi[satir][sutun] = Integer.toString(adetSayisi);
                } else if (sutun==y-1) {
                    for(int i=satir-1;i<=satir+1;i++){
                        if(dizi[i][sutun].equals("-")){
                            adetSayisi++;
                        }
                    }
                    if(dizi[satir][sutun-1].equals("-")){
                        adetSayisi++;
                    }
                    adetSayisi--;
                    adetListesi[satir][sutun] = Integer.toString(adetSayisi);
                }
                 else {
                     for(int i=satir-1;i<=satir+1;i++){
                            if(dizi[i][sutun].equals("-")){
                                adetSayisi++;
                            }
                        }
                     for(int j=sutun-1;j<=sutun+1;j++){
                         if(dizi[satir][j].equals("-")){
                             adetSayisi++;
                         }
                     }
                     adetSayisi-=2;
                    adetListesi[satir][sutun] = Integer.toString(adetSayisi);
                }
            }
        }
        return adetListesi;

    }
    static int satirGirme(int satir){
        Scanner input=new Scanner(System.in);
        boolean deger=true;
        int satir2=0;
        while(deger){
            System.out.print("Satır Giriniz: ");
            satir2=input.nextInt();
            if(satir2>satir || satir2<0){
                System.out.println("Hatalı Satır Girdiniz Tekrar Giriş Yapınız");
            }
            else{
                deger=false;
            }
        }
        return satir2;
    }

    static int sutunGirme(int sutun){
        Scanner input=new Scanner(System.in);
        boolean deger=true;
        int sutun2=0;
        while(deger){
            System.out.print("Sütün Giriniz: ");
            sutun2=input.nextInt();
            if(sutun2>sutun || sutun2<0){
                System.out.println("Hatalı Sütun Girdiniz Tekrar Giriş Yapınız");
            }
            else{
                deger=false;
            }
        }
        return sutun2;
    }
    static int sayi(String[][] dizi){
        int adetSayisi=0;
        for(int i=0;i< dizi.length;i++){
            for(int j=0;j<dizi[0].length;j++){
                if(dizi[i][j].equals("-")){
                    adetSayisi++;
                }
            }
        }
        return adetSayisi;
    }
}

