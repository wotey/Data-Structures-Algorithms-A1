import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {
   int[] c = {8,7,6,5,4};
   int[] b = {5,9,1,7,3};
   int[] a = {2,8,7,3,4};
   int[] d = {2,8,8,7,3,3,4};
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void MinTest() {
   
     
      Assert.assertEquals(4, Selector.min(c));
      Assert.assertEquals(1, Selector.min(b));
      Assert.assertEquals(2, Selector.min(a));
      Assert.assertEquals(2, Selector.min(d));
   }
   
   @Test public void MaxTest(){
      Assert.assertEquals(8, Selector.max(c));
      Assert.assertEquals(9, Selector.max(b));
      Assert.assertEquals(8, Selector.max(a));
      Assert.assertEquals(8, Selector.max(d));
   
   }
   
   @Test public void KminTest(){
   
      Assert.assertEquals(8, Selector.kmin(c, 5));
      Assert.assertEquals(5, Selector.kmin(b, 3));
      Assert.assertEquals(2, Selector.kmin(a, 1));
      Assert.assertEquals(4, Selector.kmin(d, 3));
   
   }
   
   @Test public void KmaxTest(){
      Assert.assertEquals(4, Selector.kmax(c, 5));
      Assert.assertEquals(5, Selector.kmax(b, 3));
      Assert.assertEquals(8, Selector.kmax(a, 1));
      Assert.assertEquals(4, Selector.kmax(d, 3));
   
   }
   
   @Test public void RangeTest(){
      int[] e = {8,7,6,5,4};
      int[] f = {3, 5};
      int[] g = {2,3,4};
      int[] h = {7,3,3,4};
      Assert.assertEquals(e.length, Selector.range(c,4,8).length);
      Assert.assertEquals(f.length, Selector.range(b,3,5).length);
      Assert.assertEquals(g.length, Selector.range(a,1,5).length);
      Assert.assertEquals(h.length, Selector.range(d,3,7).length); 
   }
   
   @Test public void CeilingTest(){
      Assert.assertEquals(2, Selector.ceiling(a,1));
      Assert.assertEquals(7, Selector.ceiling(b,7));
      Assert.assertEquals(4, Selector.ceiling(c,0));
      Assert.assertEquals(7, Selector.ceiling(d,5)); 
   }
   
   @Test public void FloorTest(){
      Assert.assertEquals(4, Selector.floor(a,6));
      Assert.assertEquals(1, Selector.floor(b,1));
      Assert.assertEquals(8, Selector.floor(c,9));
      Assert.assertEquals(4, Selector.floor(d,5)); 
   }
}
