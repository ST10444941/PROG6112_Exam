
package productsalesdata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductSalesDataTest {
    
    int[][] sales = {
        {300, 150 , 700},
        {250, 200, 600}
    };
    
    ProductSales ps = new ProductSales();
    
    @Test
    public void testTotalSales(){
        assertEquals(2200, ps.TotalSales(sales), "Total sales should be 2200");
    }
    
    @Test
    public void testAverageSales(){
        assertEquals(366.67, ps.AverageSales(sales), 0.01, "Average should be around 366.67");
    }
    
    @Test
    public void testMaxSales(){
        assertEquals(700, ps.MaxSale(sales), "Max sale should be 700");
    }
    
    @Test
    public void testMinSales(){
        assertEquals(150, ps.MinSale(sales), "Min should be 150");
    }
}
