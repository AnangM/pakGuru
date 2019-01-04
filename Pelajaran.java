/**
 * @author Anang Ma'ruf Budiyanto
 * @since Friday, January 4 2019
 */

//deklarasi class
class Pelajaran{
    //deklarasi state
    private String nama;
    //deklarasi state
    private Double rataRata;

    //deklarasi constructor
    public Pelajaran(){

    }
    //deklarasi constructor
    public Pelajaran(String name){
        nama = name;
    }

    //deklarasi method setNama untuk merubah data nama pelajaran
    public void setNama(String name){
        nama = name;
    }
    //deklarasi method getNama untuk mengambil nama pelajaran
    public String getNama(){
        return nama;
    }

    //deklarasi method setRataRata untuk mengubah nilai rata-rata pelajaran
    public void setRataRata(Double rata){
        rataRata = rata;
    }
    //deklarasi method getRataRata untuk mengambil nilai rata-rata
    public Double getRataRata(){
        return rataRata;
    }
}