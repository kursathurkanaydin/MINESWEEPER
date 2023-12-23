import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class MineSweeper {
    public static void main(String[] args) {
        boolean isGame=true;
        int gameKontrol=0;
        Scanner input=new Scanner(System.in);
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz: ");
        System.out.print("Oyunun Satır Sayısı: ");
        int satir=input.nextInt();
        System.out.print("Oyunun Sütün Sayısı: ");
        int sutun=input.nextInt();
        int mayinSayisi=(satir*sutun)/4;
        int[][] mayinListesi=new int[mayinSayisi][2];
        mayinListesi=Algoritmalar.mayinlar2(satir,sutun);
        String[][] board=new String[satir][sutun];
        board=Algoritmalar.board(satir,sutun,mayinListesi);
        String[][] adetListesi=new String[satir][sutun];
        adetListesi=Algoritmalar.adet(board);
        Algoritmalar.tahtaYazdir(board);
        while(isGame){

            int satir2=Algoritmalar.satirGirme(satir)-1;
            int sutun2=Algoritmalar.sutunGirme(sutun)-1;
            if(board[satir2][sutun2].equals("*")){
                System.out.println("Game Over");
                isGame=false;
                Algoritmalar.tahtaYazdir2(board);
            }
            else{
                board[satir2][sutun2]=adetListesi[satir2][sutun2];
            }
            if(Algoritmalar.sayi(board)==0){
                System.out.println("Tebrikler Kazanadınız");
                isGame=false;
            }
            Algoritmalar.tahtaYazdir(board);
        }
    }
}
