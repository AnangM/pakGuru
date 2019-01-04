/**
 * @author Anang Ma'ruf Budiyanto
 * @since Friday, January 4 2019
 */

//deklarasi class
class Table{
    //deklarasi dan inisialisasi state sebagai "template"
    /*
     * Penggunaan %-15s adalah untuk memberikan ruang sebanyak
     * 15 string pada console, dan anotasi negatif (-) menandakan
     * string digunakan dari sisi kiri, s menandakan string
     * 
     * Penggunaan %-10.2f adalah untuk memberikan ruang sebanyak
     * 10 float dan angka .2 menandakan memberikan 2 bilangan 
     * setelah tanda koma (.), f menandakan float
     */
    private static String leftAlign = "| %-15s | %-10.2f | %-10.2f | %-10.2f | %-10.2f | %-10.2f |%n";
    //deklarasi constructor private agar pengguna tidak dapat membuat objek
    private Table(){}

    //deklarasi method printHeader untuk mencetak header tabel
    public static void printHeader(){
        printDivider();
        System.out.format("| Nama            | Pelajaran A| Pelajaran B| Pelajaran C| Pelajaran D| Rata-Rata  |%n");
        printDivider();
    }
    
    //deklarasi method pritDivider untuk mencetak pemisah atau penutup tabel
    public static void printDivider(){
        System.out.format("+-----------------+------------+------------+------------+------------+------------+%n");
    }

    //deklarasi method printRecord untuk mencetak data pada tabel
    /**
     * paramater leftAlign menggunakan "template" tabel yang telah dideklarasikan
     * 
     * @param nama
     * nama dengan tipe data string akan ditampilkan pada bagian kiri tabel
     * @param nilaiA
     * nilai A adalah nilai pertama dengan tipe data Double
     * @param nilaiB
     * nilai B adalah nilai kedua dengan tipe data Double
     * @param nilaiC
     * nilai C adalah nilai ketiga dengan tipe data Double
     * @param nilaiD
     * nilai D adalah nilai terakhir dengan tipe data Double
     * @param rataRata
     */
    public static void printRecord(String nama, Double nilaiA,Double nilaiB,Double nilaiC,Double nilaiD, Double rataRata){
        System.out.format(leftAlign,nama,nilaiA,nilaiB,nilaiC,nilaiD,rataRata);
    }
}