import java.util.Arrays;
import java.util.Random;

public class Main {

    static Integer[] createArray(
            int value,
            int length,
            boolean diferentes) {
        Integer m[] = new Integer[length];
        if (diferentes) {
            for (int i = 0; i < length; i++)
                m[i] = i * 10;
            if ((value % 10 != 0) || (0 > value) || (value > (length - 1) * 10))
                m[0] = value;
        } else {
            Random r = new Random();
            int gama = (Math.abs(value) < 10) ? 10 : Math.abs(value);
            for (int i = 0; i < length; i++)
                m[i] = r.nextInt(gama * 4) - gama * 2;
            m[0] = value;
        }
        Arrays.sort(m);
        return m;
    }

    public static <T extends Comparable<T>> boolean BinarySearchRecursive(T []arr, T key){
        /*
        * This function implements a Recursive Binary Search, returns a boolean indicating if the value is in the array or not
        * */
        if(arr == null || arr.length == 0)
            return false;

        int start = 0;
        int end = arr.length;
        int mid = end/2;

        if(arr[mid].compareTo(key) == 0)
            return true;
        if(arr[mid].compareTo(key) > 0) //The value in the mid is bigger than the key value
            return BinarySearchRecursive(Arrays.copyOfRange(arr, start, mid), key);
        else
            return BinarySearchRecursive(Arrays.copyOfRange(arr, mid+1, end), key);

    }

    public static <T extends Comparable<T>> int BinarySearch(T []arr,T key){
        /*
        * This function implements a Binary Search, returning the index of the key value in the given array
        * If the key value doesn't exit in the array, the function returns the index where the value should be inserted to preserve the order
        */
        int len = arr.length;
        if(arr == null || len == 0)
            return -1;

        int start = 0;
        int end = len-1;
        int mid = end/2;

        do{
            int comp = arr[mid].compareTo(key);

            if (comp == 0)
                return mid;
            if(comp < 0)
                start = mid+1;
            if(comp > 0)
                end = mid-1;
            mid = (start+end)/2;

        }while(start <= end);

        if(arr[mid].compareTo(key) > 0)
            return -mid+1;
        else
            return -mid-1;
    }

    public static Double PercentageOfLower(Integer []arr, Integer key){
        //This function receives an array of Integers and a Key value, returns de Percentage of values that are lower than the key value
        Integer keyPosition = BinarySearch(arr, key);
        if(keyPosition.compareTo(0) < 0){
            return 0.0;
        }
        return (double) keyPosition /arr.length;

    }

    public static Integer NValuesInInterval(Integer []arr, Integer start, Integer end){
        if(arr == null || arr.length == 0)
            return 0;
        int lastInInterval = BinarySearch(arr,end);
        if(lastInInterval < 0)
            return 0;
        int firstInInterval = BinarySearch(arr, start);

        return firstInInterval<0?lastInInterval+1:lastInInterval-firstInInterval+1;
    }

    public static Boolean isRepeated(Integer []arr, Integer key){
        if(arr==null || arr.length == 0)
            throw new RuntimeException("Array is null or empty");

        int keyIndex = BinarySearch(arr, key);
        if(keyIndex < 0)
            return false;
        if(arr[keyIndex-1].equals(key) || arr[keyIndex+1].equals(key)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer []arr = createArray(1,100,true);
        for (Integer e:arr)
            System.out.print(e+" ");
        System.out.println();
        //System.out.println(BinarySearchRecursive(arr, 13));
        //System.out.println(PercentageOfLower(arr, 10));
        System.out.println(NValuesInInterval(arr,0,100));
    }

}
