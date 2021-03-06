package com.agh.p3_algorithms.example1;

import com.agh.p3_algorithms.example1.sorting_algorithms.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    public void ProgramCorectnessTest()
    {
        int arr[] = {13,3,45,8,21,1};
        int sorted_arr[] = arr.clone();
        Context c = new Context(new QuickSort());
        try{
            c.performSort(arr);
        }
        catch (Exception e){

        }

        Arrays.sort(sorted_arr);
        assertArrayEquals(arr,sorted_arr);
    }

    @Test
    public void ProgramAcceptanceTimeTest(){

        Random r = new Random();
        int[] var_random = new int[50];
        for ( int i = 0 ; i <50 ; i++) {
            var_random[i] = r.nextInt((2000001)-1000000);
        }
        int[] var_random_clone = new int[50];
        var_random_clone = var_random.clone();

        Context c = new Context(new QuickSort());
        long start=System.nanoTime();
        try{
            c.performSort(var_random);
        }
        catch (Exception e){

        }
        long stop=System.nanoTime();
        long time_elapsed = stop - start;

        start=System.nanoTime();
        Arrays.sort(var_random_clone);
        stop=System.nanoTime();

        long time_elapsed_clone = stop - start;

        System.out.println("Time elapsed quiiiick sort: " + time_elapsed + " .. time elapsed Arrays.sort() : " + time_elapsed_clone);

        assertTrue(time_elapsed < time_elapsed_clone);

    }
}