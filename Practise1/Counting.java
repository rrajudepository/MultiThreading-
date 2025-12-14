package Practise1;

public class Counting {
    int count = 0;
    public void increment(){
        for(int i=1;i<=200;i++){
            count++;
        }
        printCount();
    }

    public int getCount(){
        return count;
    }

    public void printCount(){
        System.out.println("Count is: " + count);
    }
}
