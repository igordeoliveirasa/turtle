/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import codility.Codility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igor
 */
public class MainTest {

    public MainTest() {
    }
    
    @Test
    public void hello() {
        int[]A = new int[]{1,3,2,5,4,4,6,3,2};
        Codility codility = new Codility();
        assertEquals(codility.solution(A), 7);
    }       
}
