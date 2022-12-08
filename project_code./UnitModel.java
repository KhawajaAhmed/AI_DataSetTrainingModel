/**
 * @author Steven Bogaerts (starter code)
 */
// import java.util.LinkedList;

public class UnitModel {
    
    private Matrix w; // shape (nx, 1)
    private double b;
    
    public UnitModel() {
    }
    
    public String toString() {
        String result = "";
        result += "w:\n" + w + "\n";
        result += "b: " + b + "\n";
        return result;
    }
    
    /**
     * @param X shape (nx, m)
     * @return output of the model, shape (1, m)
     */
    public Matrix forward(Matrix X) {
        return w.transpose().matMult(X).plusScalar(b).sigmoid();
    }
    
    /**
     * @param X shape (nx, m)
     * @param Y shape (1, m)
     */
    public void fit(Matrix X, Matrix Y) {
        double learningRate = 0.2;// OG = 0.2 Learning Rate! Number Of Steps that are taken to reach the minimum. // Let's change this!
        int numIterations = 100; 
        int nx = X.getNumRows();
        int m = X.getNumCols();
        w = new Matrix(nx,1);
        b = 0.0;
        
        
        for(int i = 0 ; i < numIterations; i++){
          
            Matrix A = forward(X);
            Matrix dZ = A.elementwisePlus(Y.timesScalar(-1.0));
            
            Matrix dw = (X.matMult(dZ.transpose())).timesScalar(1.0/m);    
            double db = (1.0/m) * (dZ.sumAll());
            
            w = w.elementwisePlus(dw.timesScalar(-learningRate));
            b = b - learningRate*db;
        }
        
        
    }

   
    /**
     * @param X shape (nx, m)
     * @return predictions, shape (1, m)
     */
     
    public Matrix predict(Matrix X) {
        
        Matrix A = new Matrix(1,X.getNumCols());
        A = forward(X);
        
        double[][] result = new double[1][X.getNumCols()];
        //System.out.println(X.getNumCols());
        
        for(int i = 0; i < A.getNumCols(); i++ ){
        
            if(A.get(0,i) <= 0.5 )
                result[0][i] = 0;
            else
                result[0][i] = 1;
                
        }
        
        return new Matrix(result);
    }

    
    
    public void compare(Matrix Yactual, Matrix Ypred) {
        double right = 0.0;
        int wrong = 0;
        
        System.out.println("Actual correct classification, predicted classification");
        
        for(int i  = 0; i < Yactual.getNumCols(); i++){
            
            System.out.println(Yactual.get(0,i)+", "+Ypred.get(0,i));
            
            if(Yactual.get(0,i) == Ypred.get(0,i))
                right++;
            else
                wrong++;
            
        }
        
        System.out.println("Right: "+right+", Wrong: "+wrong);
        System.out.println("Accuracy (higher is better): "+right/(wrong+right));
        
    }
    
   
    
}
