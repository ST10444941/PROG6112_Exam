
package productsalesapp;

public class ProductSales implements IProductSales {

    private int[][] salesData;
    private int salesLimit;

    public ProductSales(int[][] data, int limit) {
        this.salesData = data;
        this.salesLimit = limit;
    }

    public int[][] GetProductSales() {
        return salesData;
    }

    public int GetTotalSales() {
        int total = 0;
        for (int[] year : salesData)
            for (int sale : year)
                total += sale;
        return total;
    }

    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = 0;
        for (int[] year : salesData)
            count += year.length;
        return (double) total / count;
    }

    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : salesData)
            for (int sale : year)
                if (sale > salesLimit) count++;
        return count;
    }

    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : salesData)
            for (int sale : year)
                if (sale <= salesLimit) count++;
        return count;
    }

    public int GetProductsProcessed() {
        return salesData.length;
    }
}

    
