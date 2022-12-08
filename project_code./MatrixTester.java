/**
 * @author Steven Bogaerts (starter code)
 */
public class MatrixTester {

    public static void main(String[] args) {
        // Please do not change any code in this method! If you'd like to add your own tests (great idea!)
        // then please make a new class called MyMatrixTester and do it there.
        
        System.out.println("=================== Part 4 of a previous lab ====================");
        System.out.println("constructor ----------");
        Matrix m1 = new Matrix(new double[][] {{1, 2, 3}, 
                                               {4, 8, 12}});
        System.out.println("m1: " + m1);
        
        Matrix m2 = new Matrix(2, 3);
        System.out.println("m2: " + m2);
        
        System.out.println("getNumRows, getNumCols, get ----------");
        System.out.println(m1.getNumRows() + ", " + m1.getNumCols());
        System.out.println(m1.get(1, 2));
        System.out.println();
        
        System.out.println("hasSameNumRowsAs, hasSameNumColsAs ----------");
        Matrix m3 = new Matrix(3, 3);
        
        System.out.println("m1, m2: " + m1.hasSameNumRowsAs(m2) + ", " + m1.hasSameNumColsAs(m2));
        System.out.println("m3, m2: " + m3.hasSameNumRowsAs(m2) + ", " + m3.hasSameNumColsAs(m2));
        System.out.println();
        
        /* Expected output for part 4:
        
        constructor ----------
        m1: {
         {1.0, 2.0, 3.0}
         {4.0, 8.0, 12.0}
        }
        
        m2: {
         {0.0, 0.0, 0.0}
         {0.0, 0.0, 0.0}
        }
        
        getNumRows, getNumCols, get ----------
        2, 3
        12.0
        
        hasSameNumRowsAs, hasSameNumColsAs ----------
        m1, m2: true, true
        m3, m2: false, true
        */
        
        System.out.println("=================== Part 5 of a previous lab ====================");
        System.out.println("sumAll ----------");
        System.out.println(m1.sumAll());
        System.out.println();
        
        System.out.println("plusScalar ----------");
        System.out.println(m1.plusScalar(5));
        
        System.out.println("timesScalar ----------");
        System.out.println(m1.timesScalar(5));
        
        System.out.println("elementwisePlus ----------");
        Matrix m4 = new Matrix(new double[][] {{2, 2, 1},
                                               {3, 2, 3}});
        System.out.println(m1.elementwisePlus(m4));
        
        System.out.println("transpose ----------");
        Matrix m5 = new Matrix(new double[][] {{ 1,  2,  3,  4,  5},
                                               { 6,  7,  8,  9, 10},
                                               {11, 12, 13, 14, 15}});
        System.out.println(m5.transpose());
        
        System.out.println("sigmoid ----------");
        Matrix m6 = new Matrix(new double[][] {{-1, 2}, 
                                               {-2, 3},
                                               {-3, 1}});
        System.out.println(m6.sigmoid());
        
        /* Expected output for part 5:
        sumAll ----------
        30.0
        
        plusScalar ----------
        {
         {6.0, 7.0, 8.0}
         {9.0, 13.0, 17.0}
        }
        
        timesScalar ----------
        {
         {5.0, 10.0, 15.0}
         {20.0, 40.0, 60.0}
        }
        
        elementwisePlus ----------
        {
         {3.0, 4.0, 4.0}
         {7.0, 10.0, 15.0}
        }
        
        transpose ----------
        {
         {1.0, 6.0, 11.0}
         {2.0, 7.0, 12.0}
         {3.0, 8.0, 13.0}
         {4.0, 9.0, 14.0}
         {5.0, 10.0, 15.0}
        }
        
        sigmoid ----------
        {
         {0.2689414213699951, 0.8807970779778823}
         {0.11920292202211755, 0.9525741268224334}
         {0.04742587317756678, 0.7310585786300049}
        }
        */
       
        System.out.println("=================== Project 2 pre-reading demo ====================");
        Matrix m7 = new Matrix(new double[][] {{-1, 2, 4, 7, 6, 5, 2, 8, 9, 6, 4}, 
                                               {-2, 3, 4, 8, 6, 3, 2, 6, 8, 9, 1},
                                               {-3, 1, 3, 5, 1, 7, 6, 5, 8, 9, 8}});
        System.out.println("toString:");
        System.out.println(m7);
        
        System.out.println("toPartialString(5):");
        System.out.println(m7.toPartialString(5));
        
        System.out.println("toPartialString(2):");
        System.out.println(m7.toPartialString(2));
        
        /* Expected output:
        toString:
        {
         {-1.0, 2.0, 4.0, 7.0, 6.0, 5.0, 2.0, 8.0, 9.0, 6.0, 4.0}
         {-2.0, 3.0, 4.0, 8.0, 6.0, 3.0, 2.0, 6.0, 8.0, 9.0, 1.0}
         {-3.0, 1.0, 3.0, 5.0, 1.0, 7.0, 6.0, 5.0, 8.0, 9.0, 8.0}
        }
        
        toPartialString(5):
        Shape: (3, 11)
        {
         {-1.0, 2.0, 4.0, 7.0, 6.0, ...},
         {-2.0, 3.0, 4.0, 8.0, 6.0, ...},
         {-3.0, 1.0, 3.0, 5.0, 1.0, ...}
        }
        
        toPartialString(2):
        Shape: (3, 11)
        {
         {-1.0, 2.0, ...},
         {-2.0, 3.0, ...},
         ...
        }         
        */
        
       // Project 2 Step 4
        // Uncomment the lines below when you've written matMult, to test it.
        
        System.out.println("=================== Project 2 Step 4: matMult testing ====================");
        Matrix m8 = new Matrix(new double[][] {{3, 2, 1, 0},
                                               {4, 6, 5, 7}});
        Matrix m9 = new Matrix(new double[][] {{1, 3, 5},
                                               {2, 4, 6},
                                               {8, 6, 4},
                                               {6, 5, 4}});
        System.out.println(m8.matMult(m9));
        

       
        System.out.println(m9.matMult(m8)); // This one should result in a MatrixException if you uncomment it and run it!
        
        /* Expected output:
        {
          {15.0, 23.0, 31.0}
          {98.0, 101.0, 104.0}
        }
        
        Also try running the commented-out line above. You should get a MatrixException.
        */
    }
    
}
