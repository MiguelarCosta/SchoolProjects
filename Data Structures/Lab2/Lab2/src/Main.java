
public class Main {

    public static <T extends Comparable<T>> int BinarySearch(T []arr,T key){
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
            return -(mid+1);
        else
            return -mid;
    }

    public static void main(String[] args) {
        Integer []arr = {1,2,3,4,5,8};
        System.out.println(BinarySearch(arr, 9));

    }

}
