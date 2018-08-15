import org.junit.Assert;
import org.junit.Test;

public class DistanceTest {

    @Test
    public void shouldReturnDistanceBetweenTwoPointsOnLine(){
        Integer[] pointA = new Integer[1];
        Integer[] pointB = new Integer[1];
        pointA[0] = 1;
        pointB[0] = 10;
        double distanceResult = ClassifierRunner.distance(pointA,pointB);
        Assert.assertEquals(9,distanceResult,0);
    }

    @Test
    public void shouldReturnDistanceBetween2DPoints(){
        Integer[] pointA = new Integer[2];
        Integer[] pointB = new Integer[2];
        pointA[0] = 1;
        pointA[1] = 1;
        pointB[0] = 10;
        pointB[1] = 10;
        double distanceResult = ClassifierRunner.distance(pointA,pointB);
        Assert.assertEquals(12.72,distanceResult,0.01);
    }

}
