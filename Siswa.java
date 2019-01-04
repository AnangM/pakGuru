/**
 * @author Anang Ma'ruf Budiyanto
 * @since Friday, January 4 2019
 */

 //deklarasi class Siswa
class Siswa{
    //deklarasi state nama
    private String nama;
    //deklarasi state nilai pertama
    private Double nilaiA;
    //deklarasi state nilai kedua
    private Double nilaiB;
    //deklarasi state nilai ketiga
    private Double nilaiC;
    //deklarasi state nilai terakhir
    private Double nilaiD;

    //deklarasi constructor
    public Siswa(){
    }
    //deklarasi constructor dengan paramater
    public Siswa(String name){
        nama = name;
    }

    //deklarasi method setNama untuk mengubah nama siswa
    public void setNama(String name){
        nama = name;
    }
    //deklarasi method getNama untuk mengambil nama siswa
    public String getNama(){
        return nama;
    }
    
    //deklarasi method setNilaiA untuk mengubah nilai nilaiA
    public void setNilaiA(Double nilai){
        nilaiA = nilai;
    }
    
    //deklarasi method setNilaiB untuk mengubah nilai nilaiB
    public void setNilaiB(Double nilai){
        nilaiB = nilai;
    }
    
    //deklarasi method setNilaiC untuk mengubah nilai nilaiC
    public void setNilaiC(Double nilai){
        nilaiC = nilai;
    }
    
    //deklarasi method setNilaiD untuk mengubah nilai nilaiD
    public void setNilaiD(Double nilai){
        nilaiD = nilai;
    }

    //deklarasi method get Nilai A untuk mengambil nilai nilaiA
    public Double getNilaiA(){
        return nilaiA;
    }
    
    //deklarasi method get Nilai B untuk mengambil nilai nilaiB
    public Double getNilaiB(){
        return nilaiB;
    }
    //deklarasi method get Nilai C untuk mengambil nilai nilaiC
    public Double getNilaiC(){
        return nilaiC;
    }
    //deklarasi method get Nilai D untuk mengambil nilai nilaiD
    public Double getNilaiD(){
        return nilaiD;
    }

    //deklarasi method rata-rata untuk mengambil rata-rata nilai siswa
    public Double getRataRata(){
        Double rataRata = (nilaiA + nilaiB + nilaiC + nilaiD)/4;
        return rataRata;
    }
}