public class Mountain {

    public int[] array;

    public Mountain(int[] array){

        this.array = array;

    }

    public static boolean isIncreasing(int[] array, int stop) {
        // To be implemented

        if(!(stop >= 0 && stop < array.length)){

            return false;
        }

        boolean checker = false;

        for(int i = 0; i < stop; i++){

            if(array[i] < array[i + 1]){

                checker = true;

            } else {
                
                checker = false;
                break;
                
            }

        }

        return checker;
    }
    public static boolean isDecreasing(int[] array, int start) {

        if(!(start >= 0 && start < array.length - 1)){

            return false;

        }

        boolean checker = false;

        for(int i = start; i < array.length - 1; i++) {

            if(array[i] > array[i + 1]){

                checker = true;

            } else {

                checker = false;
                break;

            }

        }

        return checker;
        // To be implemented.
    }

    public static int getPeakIndex(int[] array) {

        int peakIndex = -1;

        if(array.length < 3){

            return peakIndex; // should be -1 by default

        }

        // start index 1 (compares with index 0 and index 2), end index array.length - 2 (compares with index array.length - 3 and index array.length - 1);

        int finalIndex = array.length - 2;
        int startIndex = 1;

        for(int i = startIndex; i <= finalIndex; i++){

            if(array[i] > array[i - 1] && array[i] > array[i + 1]){

                peakIndex = i;
                break;

            }

        }

        return peakIndex;
    }

    public static boolean isMountain(int[] array) {

        int peakIndex = getPeakIndex(array);
        boolean isMountain = false;

        if(peakIndex == -1){

            return false; // array must have a peak

        }

//        int increasingArrayLength = peakIndex + 1;
//        int[] arrayIncrease = new int[increasingArrayLength]; // first "array half"
//        System.arraycopy(array, 0, arrayIncrease, 0, peakIndex + 1); // stackOverflow
//
//        int decreasingArrayLength = array.length - peakIndex;
//        int[] arrayDecrease = new int[decreasingArrayLength]; // e.g. length is 5 (max index 4) and peakIndex is 1, we need 1 to 4 as indexes to compare
//        System.arraycopy(array, peakIndex, arrayDecrease, 0, increasingArrayLength);

        if(isIncreasing(array, peakIndex) && isDecreasing(array, peakIndex)){

            isMountain = true;

        }

        // To be implemented.
        return isMountain;
    }

    public int[] getArray(){

        return array;

    }
}
