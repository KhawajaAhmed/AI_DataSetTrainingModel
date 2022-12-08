/**
 * @author Steven Bogaerts (starter code)
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class DatasetReader {
    
    private Matrix[] readFile(String path) {
        Scanner scTemp = null;
        Scanner sc = null;
        try {
            scTemp = new Scanner(new File(path));
            sc = new Scanner(new File(path));
        }
        catch (Exception e) {
            System.out.println("Error in reading from file " + path);
            System.exit(0);
        }
        
        String[] line = scTemp.nextLine().split(",");
        int nx = line.length - 1;
        scTemp.close();
        
        LinkedList<String[]> rows = new LinkedList<String[]>();
        sc.nextLine(); // skip header row
        while(sc.hasNext()) {
            line = sc.nextLine().split(",");
            rows.add(line);
            // System.out.println("Read row: " + java.util.Arrays.toString(line));
        }
        sc.close();
        
        int m = rows.size();
        double[][] X = new double[nx][m];
        double[][] Y = new double[1][m];
        int ex = 0;
        for(String[] row: rows) {
            for(int attrID = 0; attrID < nx; attrID++)
                X[attrID][ex] = Double.parseDouble(row[attrID]);
            Y[0][ex] = Double.parseDouble(row[row.length-1]);
            ex++;
        }
        
        return new Matrix[]{ new Matrix(X), new Matrix(Y) };
    }
    
    public Matrix[] getDatasets(String baseFilename) {
        Matrix[] results;
        results = readFile("data/" + baseFilename + "Train.csv");
        // results = readFile(baseFilename + "Train.csv");
        Matrix XTrain = results[0];
        Matrix YTrain = results[1];
        
        results = readFile("data/" + baseFilename + "Test.csv");
        // results = readFile(baseFilename + "Test.csv");
        Matrix XTest = results[0];
        Matrix YTest = results[1];
        
        return new Matrix[] {XTrain, YTrain, XTest, YTest};
    }
    
    public static void main(String[] args) {
        DatasetReader reader = new DatasetReader();
        
        Matrix[] results;
        results = reader.getDatasets("breast-cancer-wisconsin");
        Matrix XTrain = results[0];
        Matrix YTrain = results[1];
        Matrix XTest = results[2];
        Matrix YTest = results[3];
        
        System.out.println("XTrain: " + XTrain);
        System.out.println("XTest: " + XTest);
        System.out.println("YTrain: " + YTrain);
        System.out.println("YTest: " + YTest);
    }
    
}
