
package productsalesapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesAppTest {
 private ProductSales ps;
 private int[][] data = {
     {300, 150 , 700},
     {250, 200, 600}
 };
 
 private final int LIMIT = 500;
 
 @BeforeEach
 void setUp(){
     ps = new ProductSales(data, LIMIT);
 }
 
 @Test 
 void testGetTotalSales(){
     assertEquals(2200, ps.GetTotalSales(), "Total sales be 2200");
 }
 
 @Test
 void testGetAverageSales(){
     assertEquals(366.67, ps.GetAverageSales(), 0.01, "Average should be 366.67");
 }
 
 @Test
 void testGetSalesOverlimit(){
     assertEquals(2, ps.GetSalesOverLimit(), "Two sales are over the limit (700, 600)");
 }
 
 @Test
 void testGetSalesUnderLimit(){
     assertEquals(4, ps.GetSalesUnderLimit(), "Four sales under or equal to the limit");
 }
 
 @Test
 void testGetProductsProcessed(){
     assertEquals(2, ps.GetProductsProcessed(), "Should process 2 product years");
 }
}