/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package des.egl;

import java.util.ArrayList;

/**
 *
 * @author AdiRahmad
 */
public class KonversiChar {
     private ArrayList listChar = new ArrayList();
 
    public ArrayList getCharASCII(String pesan) {
 
        for (int i = 0; i < pesan.length(); i++) {
            char chr = pesan.charAt(i);
            int in = chr;
 
            listChar.add(in);
        }
 
        return listChar;
    }
}
