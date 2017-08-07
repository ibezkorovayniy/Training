import java.util.Arrays;

public class StrategyPattern {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();
        int[] arr0 = {1, 3, 2, 4, 5, 0};
        client.setStrategy(new SelectionSorting());
        client.executeStrategy(arr0);

        int[] arr1 = {11, -4, 15, 40, 17, -5, -9, 0};
        client.setStrategy(new BubbleSort());
        client.executeStrategy(arr1);

        int[] arr2 = {7, 20, 8, 9, 16, -4, -11, 45};
        client.setStrategy(new InsertionSort());
        client.executeStrategy(arr2);
    }
}

interface Sorting{
    void sort(int[] array);
}
class StrategyClient{
    Sorting strategy;
    public void setStrategy(Sorting strategy){
        this.strategy = strategy;
    }
    public void executeStrategy(int[] array){
        strategy.sort(array);
    }
}

class BubbleSort implements Sorting{
    public void sort(int[] array) {
        System.out.println("Bubble sorting");
        System.out.println("Before: " + Arrays.toString(array));
        for(int barrier = array.length-1; barrier >= 0; barrier--){
            for(int i = 0; i < barrier; i++){
                if(array[i] > array[i+1]){
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(array));
    }
}
class SelectionSorting implements Sorting{
    public void sort(int[] array) {
        System.out.println("Selection sorting");
        System.out.println("Before: " + Arrays.toString(array));
        for(int barrier = 0; barrier < array.length; barrier++){
            for(int i = barrier + 1; i < array.length; i++){
                if(array[i] < array[barrier]){
                    int tmp = array[i];
                    array[i] = array[barrier];
                    array[barrier] = tmp;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(array));
    }
}

class InsertionSort implements Sorting{
    public void sort(int[] array) {
        System.out.println("Insertion sorting");
        System.out.println("Before: " + Arrays.toString(array));
        for(int barrier = 1; barrier < array.length; barrier++){
            int index = barrier;
            while(index - 1 >= 0 && array[index]< array[index-1]){
                int tmp = array[index];
                array[index] = array[index-1];
                array[index-1] = tmp;
                index--;
                }
            }
        System.out.println("After: " + Arrays.toString(array));
        }
    }
