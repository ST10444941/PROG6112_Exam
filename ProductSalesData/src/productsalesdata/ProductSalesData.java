
package productsalesdata;

public class ProductSalesData {

    public static void main(String[] args) {
         int[][] sales = {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };

        ProductSales ps = new ProductSales();

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("-----------------------------");
        System.out.println("Total sales:   " + ps.TotalSales(sales));
        System.out.printf("Average sales: %.2f\n", ps.AverageSales(sales));
        System.out.println("Maximum sale:  " + ps.MaxSale(sales));
        System.out.println("Minimum sale:  " + ps.MinSale(sales));
    

    }
    
}
