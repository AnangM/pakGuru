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

        for(int i = 0; i<3;i++){
            try{
                System.out.print("Masukkan nama siswa " + (i+1) + " : ");
                input = br.readLine();
                siswa[i] = new Siswa(input);

                System.out.print("Masukkan nilai mata pelajaran A untuk siswa " + siswa[i].getNama() + " : ");
                input = br.readLine();
                temp = Double.parseDouble(input);
                siswa[i].setNilaiA(temp);

                System.out.print("Masukkan nilai mata pelajaran B untuk siswa " + siswa[i].getNama() + " : ");
                input = br.readLine();
                temp = Double.parseDouble(input);
                siswa[i].setNilaiB(temp);

                System.out.print("Masukkan nilai mata pelajaran C untuk siswa " + siswa[i].getNama() + " : ");
                input = br.readLine();
                temp = Double.parseDouble(input);
                siswa[i].setNilaiC(temp);

                System.out.print("Masukkan nilai mata pelajaran D untuk siswa " + siswa[i].getNama() + " : ");
                input = br.readLine();
                temp = Double.parseDouble(input);
                siswa[i].setNilaiD(temp);

            }catch(IOException e){
                e.printStackTrace();
            }
            
        }

        Table.printHeader();

        for(int i = 0; i< siswa.length; i++ ){
            Table.printRecord(siswa[i].getNama(),
            siswa[i].getNilaiA(),
            siswa[i].getNilaiB(),
            siswa[i].getNilaiC(),
            siswa[i].getNilaiD(),
            siswa[i].getRataRata());
        }
        Table.printDivider();

        pelajaran[0].setRataRata(rataRataPelajaran(siswa[0].getNilaiA(), siswa[1].getNilaiA(), siswa[2].getNilaiA()));
        pelajaran[1].setRataRata(rataRataPelajaran(siswa[0].getNilaiB(), siswa[1].getNilaiB(), siswa[2].getNilaiB())); 
        pelajaran[2].setRataRata(rataRataPelajaran(siswa[0].getNilaiC(), siswa[1].getNilaiC(), siswa[2].getNilaiC())); 
        pelajaran[3].setRataRata(rataRataPelajaran(siswa[0].getNilaiD(), siswa[1].getNilaiD(), siswa[2].getNilaiD())); 
        rataRataSiswa = rataRataPelajaran(siswa[0].getRataRata(), siswa[1].getRataRata(), siswa[2].getRataRata()); 
        
        Table.printRecord("Rata-Rata",pelajaran[0].getRataRata(),
            pelajaran[1].getRataRata(),
            pelajaran[2].getRataRata(),
            pelajaran[3].getRataRata(),rataRataSiswa);
        
        Table.printDivider();

        Pelajaran pelajaranTertinggi = pelajaran[0], pelajaranTerendah = pelajaran[0];
        
        for(int i = 0; i<pelajaran.length;i++){
            if(pelajaran[i].getRataRata()>pelajaranTertinggi.getRataRata()){
                pelajaranTertinggi = pelajaran[i];
            }else if(pelajaran[i].getRataRata()<pelajaranTerendah.getRataRata()){
                pelajaranTerendah = pelajaran[i];
            }
        }

        System.out.println("Nilai rata-rata mata pelajaran tertinggi adalah " 
            + pelajaranTertinggi.getNama() 
            + ", dengan rata-rata " 
            + df.format(pelajaranTertinggi.getRataRata()) + ".");
        System.out.println("Nilai rata-rata mata pelajaran terendah adalah " 
            + pelajaranTerendah.getNama() 
            + ", dengan rata-rata " 
            + df.format(pelajaranTerendah.getRataRata()) + ".");
        
        Siswa siswaTertinggi = siswa[0],siswaTerendah = siswa[0];

        for(int i = 0; i<siswa.length;i++){
            if(siswa[i].getRataRata()>siswaTertinggi.getRataRata()){
                siswaTertinggi = siswa[i];
            }else if(siswa[i].getRataRata()<siswaTerendah.getRataRata()){
                siswaTerendah = siswa[i];
            }
        }
        
        System.out.println("Nilai rata-rata siswa tertinggi adalah " 
            + siswaTertinggi.getNama() 
            + ", dengan nilai rata-rata " 
            + df.format(siswaTertinggi.getRataRata()) + ".");
        System.out.println("Nilai rata-rata siswa terendah adalah " 
            + siswaTerendah.getNama() 
            + ", dengan nilai rata-rata " 
            + df.format(siswaTerendah.getRataRata())+ ".");

    }

    static Double rataRataPelajaran(Double siswa1, Double siswa2, Double siswa3){
        Double rataRata = 0.0;
        rataRata = (siswa1 + siswa2 + siswa3 )/3;
        return rataRata;
    }
}