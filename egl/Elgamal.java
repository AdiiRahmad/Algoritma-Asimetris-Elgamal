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
public class Elgamal {

    private static BigInteger p, g, y, x;

    public static String enkripsiElgamal(String pesan) {
        String chiper = "";
        String hasilEnkrip = "";

        BuatKunci bk = new BuatKunci();

        KonversiChar converter = new KonversiChar();
        BilanganAcak number = new BilanganAcak();
        EnkripDekrip ed = new EnkripDekrip();

        p = new BigInteger("2903");
        g = new BigInteger("6");
        x = new BigInteger("1794");

        if (p.intValue() < 225) {
            System.out.println("Bilangan Harus Lebih Besar Dari 255");
        } else if (g.intValue() < 1 | g.intValue() >= p.intValue() - 1) {
            System.out.println("Nilai g : 1 < g <= p-1");
        } else if (x.intValue() < 1 | x.intValue() >= p.intValue() - 2) {
            System.out.println("Nilai x : 1 < x <= p-2");
        } else {

            bk.setPrima(p.intValue());

            if (bk.isPrima() == false) {
               // System.out.println(p + " bukan bilangan prima");
            } else {
                y = bk.getKunci(p, g, x);
                //System.out.println("Kunci Public : " + p + "," + g + "," + y);
                //System.out.println("Kunci Private : " + x + "\n");

                //konversi char ke ASCII
                ArrayList chr = converter.getCharASCII(pesan);

                //membuat nilai random
                ArrayList rn = number.getBilanganAcak(pesan, p);

//                System.out.println("Pesan\tASCII\tNilai Random");
//                for (int i = 0; i < pesan.length(); i++) {
//                    char c = pesan.charAt(i);
//              /      System.out.println(c + "\t" + chr.get(i).toString()
//                            + "\t" + rn.get(i));
//                }

                //==============================================================
                //Proses Enkripsi
            //    System.out.println("\n+++++ENKRIPSI+++++");
                for (int i = 0; i < pesan.length(); i++) {
                    chiper = ed.getEnkripsi(chr.get(i).toString(),
                            rn.get(i).toString(), g, p, y, pesan);
                    hasilEnkrip += chiper;
                }
          //      System.out.print("Chiper : " + hasilEnkrip);
            }

        }
        return hasilEnkrip;
    }
        
        

    public static String dekripsiElgamal(String chiper) {
        System.out.println("\n+++++DEKRIPSI+++++");
        PecahChiperText pct = new PecahChiperText();

        pct.setChiper(chiper);

        ArrayList ngama = pct.getGamma();
        ArrayList ndelta = pct.getDelta();

        //Mengambil nilai gamma dan delta
//        System.out.println("Gamma\tDelta");
//        for (int i = 0; i < pesan.length(); i++) {
//            System.out.println(ngama.get(i) + "\t" + ndelta.get(i));
//        }
                //--------------------------------------------------------------
        
        EnkripDekrip ed = new EnkripDekrip();
        String hasilDekrip = "";
        try {
            for (int i = 0; i < chiper.length(); i++) {
            char dek = ed.getDekripsi(ngama.get(i).toString(),
                    ndelta.get(i).toString(), p, x, chiper);
            hasilDekrip += dek;
        }
        //System.out.println("\nPesan : " + hasilDekrip);

                //Akhir dari proses Dekripsi
        return hasilDekrip;
        } catch(IndexOutOfBoundsException e) {
            return hasilDekrip;
        }
        

    }
    
    public static void main(String[] args) {
        String pesan = "Satria Winarah";
        
        String cipher = enkripsiElgamal(pesan);
        String hasil = dekripsiElgamal(cipher);
        
        System.out.println("=====================");
        System.out.println("Pesan : " + pesan);
        System.out.println("Cipher : " + cipher);
        System.out.println("Hasil : " + hasil);
    }
}
