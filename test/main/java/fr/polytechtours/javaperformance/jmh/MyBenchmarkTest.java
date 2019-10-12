package fr.polytechtours.javaperformance.jmh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.polytechtours.javaperformance.jmh.MyBenchmark;

import static org.junit.Assert.*;

public class MyBenchmarkTest {

    private Integer[] MY_ARRAY = {12, 42, 18, 128, 36, 13, 4, 8};
    private static final Integer[] EXPECTED_RESULT = {24, 84, 36, 256, 72, 26, 8, 16};

    private List<Integer> myList;
    private MyBenchmark myBenchmark;

     @Before
     public void setup() {
        myList = new ArrayList<>();
        myList = Arrays.asList(MY_ARRAY);
        myBenchmark = new MyBenchmark();
        myBenchmark.setMyList(myList);
     }

    @Test
    public void testMyMethodOK() {
        Assert.assertTrue(asCorrectValues(myBenchmark.timesTwoForEach()));
        Assert.assertTrue(asCorrectValues(myBenchmark.timesTwoStream()));
        Assert.assertTrue(asCorrectValues(myBenchmark.timesTwoForLoop()));
    }

    private boolean asCorrectValues(List<Integer> list) {
        return list.containsAll(Arrays.asList(EXPECTED_RESULT)) && list.size() == EXPECTED_RESULT.length;
    }

}