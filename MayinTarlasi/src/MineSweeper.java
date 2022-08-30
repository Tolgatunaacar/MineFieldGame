
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int columnNumber;
    int[][] map;
    int[][] gameField;
    int size;
    boolean game;
    int success = 0;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);


    MineSweeper(int row,int column){
        this.rowNumber = row;
        this.columnNumber = column;
        this.map = new int[row][column];
        this.gameField = new  int[row][column];
        this.size = row*column;
        this.game= game =false;
    }

    public void run(){
        mineField();
        System.out.println("Oyun basladi");
        game();
        //again();

    }

    public void mineField(){
        int mineRow, mineColumn,mineCount = 0;

        while (mineCount < (size/4) ){
            mineRow = rand.nextInt(rowNumber);
            mineColumn = rand.nextInt(columnNumber);
            if (map[mineRow][mineColumn] != -1){
                map[mineRow][mineColumn] = -1;
                mineCount++;
            }
        }
    }

    public void printArray(int[][] arr){
        for (int i =0 ; i < arr.length; i++){
            for(int j =0; j < arr[i].length;j++){
                if (arr[i][j] >= 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }

    public void mineCheck(int row,int col){
        if (map[row][col] == 0 ){
            if ((row > 0 && col > 0) && (map[row-1][col-1] == -1)){
                gameField[row][col] ++;
            }
            if ((row > 0) && (map[row-1][col] == -1)){
                gameField[row][col] ++;
            }
            if ((row > 0 && col < columnNumber-1 ) && (map[row-1][col+1] == -1)){
                gameField[row][col] ++;
            }
            if ((col > 0) && (map[row][col-1] == -1)){
                gameField[row][col] ++;
            }
            if ((col < columnNumber -1) && (map[row][col+1] == -1)){
                gameField[row][col] ++;
            }
            if ((row < rowNumber -1 && col > 0) && (map[row+1][col-1] == -1)){
                gameField[row][col] ++;
            }
            if ((row < rowNumber-1) && (map[row+1][col] == -1)){
                gameField[row][col] ++;
            }
            if ((row < rowNumber - 1 && col < columnNumber - 1) && (map[row+1][col+1] == -1)){
                gameField[row][col] ++;
            }
            if (gameField[row][col] == 0){
                gameField[row][col] = -2 ;
            }
        }
    }

    public void game(){
        while (!game){
            //printArray(map);
            System.out.println("------------------");
            printArray(gameField);
            System.out.println("Acmak istediğiniz konumun;");
            System.out.println("Satir numarasi:");
            int row = input.nextInt();
            System.out.println("Sutun numarasi:");
            int col = input.nextInt();

            if (map[row][col] == -1){
                System.out.println("Mayina bastininiz...");
                System.out.println("Oyun bitti...");
                game = true;
            } if (map[row][col] == 0){
                mineCheck(row,col);
                success += 1;
                if (success == (size - size/4)){
                    System.out.println("Kazandiniz...");
                    game = true;
                }
            }
        }
    }
    public void again(){
        System.out.println("Yeniden Baslamak ister misiniz..." + "1- Evet 2- Hayir");
        System.out.println("Seciminiz:");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                run();
                break;
            case 2:
                System.out.println("Güzel oyundu...");
                break;
            default:
                System.out.println("Belirsiz bir deger girdiniz...");
        }
    }

}
