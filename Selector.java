import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   William Otey (wko0001@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2016-08-18
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @return minimum value
    * @param a given array
    */
   public static int min(int[] a) {
     
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int lowest;
      lowest = a[0];
      for (int i = 0; i < a.length; i++) {         
         if (!(lowest < a[i])) {
            lowest = a[i];
         }         
      }
      return lowest;
   }


   /**
    * Selects the maximum value from the array a. This method
    * @throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @return maxval maximum value of the array
    * @param a given array
    */
   public static int max(int[] a) {
     
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Error: The array is empty.");
      }
      int maxval = a[0];
      for (int i = 1; i < a.length; i++) {
         if (maxval < a[i]) {
            maxval = a[i];
         }           
      }
      return maxval;
   }
   /**
    * Selects the kth minimum value from the array a. This method
    * @throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @return kmin value of the array
    * @param a array given
    * @param k value
    */
  
   public static int kmin(int[] a, int k) {
     
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      int[] copy = Arrays.copyOf(a, a.length);
      Arrays.sort(copy);
      
      int uniqNum = 1;
   
      int[] b = new int[copy.length];
      b[0] = copy[0];
      
      for (int i = 0; i < b.length - 1; i++) {
         if (copy[i] != copy[i + 1]) {
            b[uniqNum] = copy[i + 1];
            uniqNum++;
         }
      }
      int[] c = Arrays.copyOfRange(b, 0, uniqNum);
      int j = 0;
      int l = 0;
      int count = 0;  
      for (int i = 1; i < c.length && count < k - 1; i++) {
         if (copy[i] == copy[j]) {
            l++;      
         }
         count++; 
         j++;
      }

      
            
      int kmint = k - 1;
      if (kmint > c.length - 1 || kmint > copy.length) {
         throw new IllegalArgumentException();
      }
      int kmin = c[kmint];
      return kmin;
   }
   /**
    * Selects the kth maximum value from the array a. This method
    * @throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @return kmin of the array
    * @param a array given 
    * @param k value compared
    */
 
   public static int kmax(int[] a, int k) {
      
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException("Error: The array is null, " 
            + "has zero length k is less than 1, k is greater than the number "
            + "of elements in the array, or if k is greater than the number "
            + "of distinct values in the array.");
      }
      int[] copy = Arrays.copyOf(a, a.length);
      Arrays.sort(copy);
      int uniqNum = 1;
   
      int[] b = new int[copy.length];
      b[0] = copy[0];
      
      for (int i = 0; i < b.length - 1; i++) {
         if (copy[i] != copy[i + 1]) {
            b[uniqNum] = copy[i + 1];
            uniqNum++;
         }
      }
      int[] c = Arrays.copyOfRange(b, 0, uniqNum);

      int j = copy.length - 1;
      int l = 0;
      int count = 0;  
      for (int i = c.length - 2; i >= 0 && count < k - 1; i--) {
         if (copy[i] == copy[j]) {
            l++;      
         }
         count++; 
         j--;
      }
      
      
      int kmaxe = c.length - k;
      if (kmaxe < 0 || c.length == 0) {
         throw new IllegalArgumentException();
      }
      return c[kmaxe];   
   }
   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    * @return array of the array
    * @param a given array
    * @param low value given
    * @param high value given
    */
   
   public static int[] range(int[] a, int low, int high) {
     
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Error: The array is null or " 
            + "has zero length.");
      }
      int j = 0;
      int[] range = new int[a.length];
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            range[j] = a[i];
            j++;     
         }
      }     
      return Arrays.copyOfRange(range, 0, j);
   }
   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a given array 
    * @param key value given
    * @return ceiling of array 
    */
 
   public static int ceiling(int[] a, int key) {
     
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Error: The array is empty.");
      } 
      int[] b = new int[a.length];
      int j = 0;
      int count = 0;
      for (int i = 0; i < a.length; i++) {       
         if (a[i] >= key) {
            b[j] = a[i];
            j++;
            count++;
         }  
      }
      if (count == 0) {
         throw new IllegalArgumentException("Error: The array is empty.");
      } 
      int ceiling = b[0];
      for (int i = 1; i < j; i++) {
         if (ceiling > b[i]) {
            ceiling = b[i];
         }     
      } 
      return ceiling;
   }
   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a given array
    * @param key value given
    * @return floor value
    */
 
   public static int floor(int[] a, int key) {
     
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Error: The array is empty.");
      } 
      int count = 0;
      int j = 0;
      int[] b = new int[a.length];
      for (int i = 0; i < a.length; i++) {     
         if (a[i] <= key) {
            b[j] = a[i];
            j++;
            count++;
         }
      }
      if (count == 0) {
         throw new IllegalArgumentException("Error: The array is empty.");
      }
      int floor = b[0];
      for (int i = 1; i < j; i++) {  
         if (floor < b[i]) {
            floor = b[i];
         }     
      }
      return floor;
   }

}