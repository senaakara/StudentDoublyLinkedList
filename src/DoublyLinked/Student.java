package DoublyLinked;

import java.util.ArrayList;

public class Student {            // Metotlarla ilgili gerekli açıklamalar rapor dosyasında bulunmaktadır.
    private int ogrenciNo;
    private String adSoyad;
    private ArrayList<String> iletisimNumaralari = new ArrayList();

    public Student() {
        this.ogrenciNo = 0;
        this.adSoyad = null;
        this.iletisimNumaralari = null;
    }

    public Student(int ogrenciNo, String adSoyad, ArrayList<String> iletisimNumaralari) {
        this.ogrenciNo = ogrenciNo;
        this.adSoyad = adSoyad;
        this.iletisimNumaralari = iletisimNumaralari;
    }

    public Student(Student copyStudent) {
        this.ogrenciNo = copyStudent.getOgrenciNo();
        this.adSoyad = copyStudent.getAdSoyad();
        this.iletisimNumaralari = copyStudent.getIletisimNumaralari();
    }

    public int getOgrenciNo() {
        return this.ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getAdSoyad() {
        return this.adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public ArrayList<String> getIletisimNumaralari() {
        return this.iletisimNumaralari;
    }

    public void setIletisimNumaralari(ArrayList<String> iletisimNumaralari) {
        this.iletisimNumaralari = iletisimNumaralari;
    }

    @Override
    public String toString() {
        int var10000 = this.getOgrenciNo();
        return "Öğrenci numarası:" + var10000 + " Adı-Soyadı:" + this.getAdSoyad() + " İletişim Numarası:" + this.getIletisimNumaralari();
    }
}