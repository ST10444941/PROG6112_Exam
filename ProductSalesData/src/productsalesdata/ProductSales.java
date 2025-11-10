
package productsalesdata;

public class ProductSales implements IProduct{
    // Class implementing the interface


    public int TotalSales(int[][] sales) {
        int total = 0;
        for (int[] year : sales) {
            for (int s : year) {
                total += s;
            }
        }
        return total;
    }

    public double AverageSales(int[][] sales) {
        int total = TotalSales(sales);
        int count = 0;
        for (int[] year : sales) count += year.length;
        return (double) total / count;
    }

    public int MaxSale(int[][] sales) {
        int max = sales[0][0];
        for (int[] year : sales)
            for (int s : year)
                if (s > max) max = s;
        return max;
    }

    public int MinSale(int[][] sales) {
        int min = sales[0][0];
        for (int[] year : sales)
            for (int s : year)
                if (s < min) min = s;
        return min;
    }
}