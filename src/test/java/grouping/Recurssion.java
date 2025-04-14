package grouping;

public class Recurssion {

    public static void printNum(int num){
        if(num>100){
            return;
        }
        System.out.print(num+" ");
        printNum(num+1);
    }

    public static void main(String[] args) {
        int num = 1;
        printNum(num);
    }
}
