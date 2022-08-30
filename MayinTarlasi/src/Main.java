import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Mayin tarlasi oyununa hosgldiniz...");
        System.out.println("Eger ki tahtada -2 degerini görürseniz bu o kordinatin etrafinda mayin yok demektir...");
        System.out.println("Oyun Tahtasi boyutunu girin...");
        System.out.println("Satir sayisi:");
        int row = input.nextInt();
        System.out.println("Sutun sayisini giriniz:");
        int col = input.nextInt();

        MineSweeper mine = new MineSweeper(row,col);
        mine.run();
    }
}
