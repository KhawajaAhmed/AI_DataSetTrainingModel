/**
 * @author Steven Bogaerts
 */
public class UnitModelTester {
    
    public static void main(String[] args) {
        DatasetReader reader;
        Matrix[] allData;
        boolean isBinary;
        
        // Test UnitModel
        reader = new DatasetReader();
        //allData = reader.getDatasets("genLinear");
        allData = reader.getDatasets("breast-cancer-wisconsin");
        //allData = reader.getDatasets("titanic");
        
        Matrix XTrain = allData[0];
        Matrix YTrain = allData[1];
        Matrix XTest = allData[2];
        Matrix YTest = allData[3];
        Matrix YPred;
    
        
        System.out.println("XTrain: " + XTrain.toPartialString(4));
        System.out.println("YTrain: " + YTrain.toPartialString(4));
        System.out.println("XTest: " + XTest.toPartialString(4));
        System.out.println("YTest: " + YTest.toPartialString(4));
        
        UnitModel unit = new UnitModel();
        
        System.out.println("---------- fit ----------");
        unit.fit(XTrain, YTrain); // fit on the training data
        System.out.println("After fit, unit is:\n" + unit);
        
        System.out.println("---------- predict ----------");
        YPred = unit.predict(XTest); // make predictions given the testing data inputs
        System.out.println("The predictions are:" + YPred);
        
        
        System.out.println("---------- compare ----------");
        unit.compare(YTest, YPred); // Will print the comparison of the correct testing data outputs with the predictions
        
    }
    
}

/*
Expected output for genLinear:
XTrain: Shape: (2, 70)
{
 {6.403605484505981, -3.8426401076667482, 4.579477185816341, 0.7998354948661408, ...},
 {-0.7139459570213198, 2.3644422916131784, -2.777321230943482, -1.6559252927806192, ...}
}

YTrain: Shape: (1, 70)
{
 {1.0, 0.0, 1.0, 1.0, ...}
}

XTest: Shape: (2, 30)
{
 {8.162954196325387, -5.662183773920897, -3.003345654585225, 9.990948778545384, ...},
 {2.1822545461966456, 3.5881074167459133, -4.935392390836807, 7.49536053460276, ...}
}

YTest: Shape: (1, 30)
{
 {1.0, 0.0, 1.0, 0.0, ...}
}

---------- fit ----------
After fit, unit is:
w:
{
 {0.9648163656688558}
 {-1.5129605182031267}
}

b: -0.08091580028624379

---------- predict ----------
The predictions are:{
 {1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0}
}

---------- compare ----------
Actual correct classification, predicted classification
1.0, 1.0
0.0, 0.0
1.0, 1.0
0.0, 0.0
1.0, 1.0
0.0, 0.0
0.0, 0.0
0.0, 0.0
0.0, 0.0
0.0, 0.0
0.0, 0.0
0.0, 0.0
1.0, 1.0
0.0, 0.0
1.0, 1.0
1.0, 1.0
0.0, 0.0
1.0, 1.0
0.0, 0.0
1.0, 1.0
1.0, 1.0
0.0, 0.0
1.0, 1.0
1.0, 1.0
0.0, 0.0
1.0, 1.0
0.0, 0.0
0.0, 0.0
0.0, 0.0
0.0, 0.0
Right: 30, Wrong: 0
Accuracy (higher is better): 1.0
*/

