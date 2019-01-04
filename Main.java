/**
 * @author Anang Ma'ruf Budiyanto
 * @since Friday, January 4 2019
 */
//import bahan untuk user input
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.IOException;

//deklarasi class
class Main{
    //deklarasi main method
    public static void main(String[] args){
        //deklarasi dan inisialisasi bufferedReader dan string untuk mendapatkan user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        //deklarasi array yang menampung data 3 orang siswa privat
        Siswa[] siswa = new Siswa[3];
        //deklarasi dan inisialisasi variable temp sebagai penyimpan sementara data
        //yang sedang diubah tipe dari string menjadi double
        Double temp = 0.0;
        //deklarasi variable rata-rata seluruh siswa
        Double rataRataSiswa;

        //pembuatan objek pelajaran
        Pelajaran pelajaranA = new Pelajaran("Pelajaran A");
        Pelajaran pelajaranB = new Pelajaran("Pelajaran B");
        Pelajaran pelajaranC = new Pelajaran("Pelajaran C");
        Pelajaran pelajaranD = new Pelajaran("Pelajaran D");
        //deklarasi array yang menampung data pelajaran
        Pelajaran[] pelajaran = {pelajaranA,pelajaranB,pelajaranC,pelajaranD};
        //untuk mengubah nilai desimal menjadi 2 angka dibelakang koma
        DecimalFormat df = new DecimalFormat("#.00");

        //main loop untuk mendapatkan data nama siswa dan nilai nilai nya
        for(int i = 0; i<3;i++){
            try{
                System.out.print("Masukkan nama siswa " + (i+1) + " : ");
                input = br.readLine();
                //membuat objek Siswa berdasarkan inputan user
                siswa[i] = new Siswa(input);

                System.out.print("Masukkan nilai mata pelajaran A untuk siswa " + siswa[i].getNama() + " : ");
                input = br.readLine();
                //mengubah tipe data string dari input menjadi double
                temp = Double.parseDouble(input);
                //mengubah nilai nilaiA pada objek Siswa
                siswa[i].setNilaiA(temp);
                
                System.out.print("Masukkan nilai mata pelajaran B untuk siswa " + siswa[i].getNama() + " : ");
                input = br.readLine();
                temp = Double.parseDouble(input);
                //mengubah nilai nilaiB pada objek Siswa
                siswa[i].setNilaiB(temp);
                
                System.out.print("Masukkan nilai mata pelajaran C untuk siswa " + siswa[i].getNama() + " : ");
                input = br.readLine();
                temp = Double.parseDouble(input);
                //mengubah nilai nilaiC pada objek Siswa
                siswa[i].setNilaiC(temp);
                
                System.out.print("Masukkan nilai mata pelajaran D untuk siswa " + siswa[i].getNama() + " : ");
                input = br.readLine();
                temp = Double.parseDouble(input);
                //mengubah nilai nilaiD pada objek Siswa
                siswa[i].setNilaiD(temp);

            }catch(IOException e){
                e.printStackTrace();
            }
            
        }
        //meberi jarak
        Table.spacer();
        //mencetak header tabel
        Table.printHeader();
        //perulangan untuk mencetak nilai pada tabel menggunakan method printRecord
        for(int i = 0; i< siswa.length; i++ ){
            Table.printRecord(siswa[i].getNama(),
            siswa[i].getNilaiA(),
            siswa[i].getNilaiB(),
            siswa[i].getNilaiC(),
            siswa[i].getNilaiD(),
            siswa[i].getRataRata());
        }
        //mencetak penutup tabel
        Table.printDivider();
        //memberi nilai rata-rata pada setiap objek pelajaran
        pelajaran[0].setRataRata(rataRataPelajaran(siswa[0].getNilaiA(), siswa[1].getNilaiA(), siswa[2].getNilaiA()));
        pelajaran[1].setRataRata(rataRataPelajaran(siswa[0].getNilaiB(), siswa[1].getNilaiB(), siswa[2].getNilaiB())); 
        pelajaran[2].setRataRata(rataRataPelajaran(siswa[0].getNilaiC(), siswa[1].getNilaiC(), siswa[2].getNilaiC())); 
        pelajaran[3].setRataRata(rataRataPelajaran(siswa[0].getNilaiD(), siswa[1].getNilaiD(), siswa[2].getNilaiD())); 
        rataRataSiswa = rataRataPelajaran(siswa[0].getRataRata(), siswa[1].getRataRata(), siswa[2].getRataRata()); 
        //mencetak nilai rata rata dibawah tabel
        Table.printRecord("Rata-Rata",pelajaran[0].getRataRata(),
            pelajaran[1].getRataRata(),
            pelajaran[2].getRataRata(),
            pelajaran[3].getRataRata(),rataRataSiswa);
        //mencetak penutup tabel
        Table.printDivider();
        //memberi batasan
        Table.spacer();

        //deklarasi variabel untuk menampung nilai pelajaran tertinggi dan terendah
        Pelajaran pelajaranTertinggi = pelajaran[0], pelajaranTerendah = pelajaran[0];
        //perulangan untuk menentukan pelajaran dengan nilai rata-rata tertinggi dan terendah
        /**
         * //didalam perulangan
         * jika rata-rata pelajaran lebih tinggi dari nilai rata-rata pelajaranTertinggi
         * maka nilai tersebut menjadi nilai pelajaranTertinggi
         * 
         * namun jika rata-rata pelajaran lebih rendak dari nilai rata-rata pelajaranTerendah
         * maka nilai tersebut menjadi pelajaranTerendah
         */
        for(int i = 0; i<pelajaran.length;i++){
            if(pelajaran[i].getRataRata()>pelajaranTertinggi.getRataRata()){
                pelajaranTertinggi = pelajaran[i];
            }else if(pelajaran[i].getRataRata()<pelajaranTerendah.getRataRata()){
                pelajaranTerendah = pelajaran[i];
            }
        }

        //mencetak hasil perhitungan nilai rata-rata tertinggi
        System.out.println("Nilai rata-rata mata pelajaran tertinggi adalah " 
        + pelajaranTertinggi.getNama() 
        + ", dengan rata-rata " 
        + df.format(pelajaranTertinggi.getRataRata()) + ".");
        //mencetak hasil perhitungan nilai rata-rata terendah
        System.out.println("Nilai rata-rata mata pelajaran terendah adalah " 
            + pelajaranTerendah.getNama() 
            + ", dengan rata-rata " 
            + df.format(pelajaranTerendah.getRataRata()) + ".");
        
        Table.spacer();
        
        //deklarasi variabel untuk menampung nilai rata-rata siswa tertinggi dan terendah
        Siswa siswaTertinggi = siswa[0],siswaTerendah = siswa[0];

        //main loop untuk menhitung nilai rata-rate tertinggi dan terendah
        /**
         * Jika rata-rata siswa lebih dari rata-rata siswaTertinggi maka
         * nilai tersebut menjadi nilai dari siswaTertinggi
         * 
         * Namun jika rata-rata siswa kurang dari rata-rata siswaTerendah maka
         * nilai tesebut menjadi nilai dari siswaTerendah
         * 
         */
        for(int i = 0; i<siswa.length;i++){
            if(siswa[i].getRataRata()>siswaTertinggi.getRataRata()){
                siswaTertinggi = siswa[i];
            }else if(siswa[i].getRataRata()<siswaTerendah.getRataRata()){
                siswaTerendah = siswa[i];
            }
        }
        
        //mencetak nilai rata-rata siswa tertinggi
        System.out.println("Nilai rata-rata siswa tertinggi adalah " 
        + siswaTertinggi.getNama() 
        + ", dengan nilai rata-rata " 
        + df.format(siswaTertinggi.getRataRata()) + ".");
        //mencetak nilai rata-rata siswa terendah
        System.out.println("Nilai rata-rata siswa terendah adalah " 
            + siswaTerendah.getNama() 
            + ", dengan nilai rata-rata " 
            + df.format(siswaTerendah.getRataRata())+ ".");

    }

    //deklarasi method rata-rataPelajaran untuk melakukan pehitungan rata-rata tiap pelajaran
    static Double rataRataPelajaran(Double siswa1, Double siswa2, Double siswa3){
        Double rataRata = 0.0;
        rataRata = (siswa1 + siswa2 + siswa3 )/3;
        return rataRata;
    }
}