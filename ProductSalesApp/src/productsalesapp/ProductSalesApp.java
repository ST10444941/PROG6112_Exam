
package productsalesapp;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ProductSalesApp extends JFrame {

    private JTextArea textArea;
    private JLabel yearsLabel;

    // Example product sales data (2 years, 3 products)
    private int[][] productSales = {
        {300, 150, 700}, // Year 1
        {250, 200, 600}  // Year 2
    };
    private final int SALES_LIMIT = 500;

    public ProductSalesApp() {
        setTitle("Product Sales Application");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Text Area ---
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // --- Bottom Label ---
        yearsLabel = new JLabel("Years Processed: 0");
        add(yearsLabel, BorderLayout.SOUTH);

        // --- Buttons ---
        JPanel panel = new JPanel();
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");
        panel.add(loadButton);
        panel.add(saveButton);
        add(panel, BorderLayout.NORTH);

        // --- Menu Bar ---
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        // --- Action Listeners ---
        loadButton.addActionListener(e -> loadData());
        saveButton.addActionListener(e -> saveData());
        loadItem.addActionListener(e -> loadData());
        saveItem.addActionListener(e -> saveData());
        clearItem.addActionListener(e -> clearData());
        exitItem.addActionListener(e -> System.exit(0));
    }

    private void loadData() {
        ProductSales ps = new ProductSales(productSales, SALES_LIMIT);

        textArea.setText("DATA LOG\n************************\n");
        textArea.append("Total Sales: " + ps.GetTotalSales() + "\n");
        textArea.append(String.format("Average Sales: %.0f\n", ps.GetAverageSales()));
        textArea.append("Sales over limit: " + ps.GetSalesOverLimit() + "\n");
        textArea.append("Sales under limit: " + ps.GetSalesUnderLimit() + "\n");
        yearsLabel.setText("Years Processed: " + ps.GetProductsProcessed());
    }

    private void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt"))) {
            writer.println(textArea.getText());
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data!");
        }
    }

    private void clearData() {
        textArea.setText("");
        yearsLabel.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApp().setVisible(true));
    }
}

 