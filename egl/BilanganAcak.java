/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package des.egl;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author AdiRahmad
 */
public class BilanganAcak {
     private ArrayList listNumber = new ArrayList();
 
    public ArrayList getBilanganAcak(String pesan, BigInteger p) {
 
        int pp = p.intValue() - 2;
        for (int i = 0; i < pesan.length(); i++) {
            int rand = (int) (pp * Math.random());
 
            listNumber.add(rand);
        }
        return listNumber;
    }
}
