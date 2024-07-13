package DoublyLinked;

import java.util.*;
import java.io.*;

public class DoublyLinkedList {  // Metotlarla ilgili gerekli açıklamalar rapor dosyasında bulunmaktadır.
    
    static class Node{
        Student ogrenciBilgi;
        Node bastakibaglanti;
        Node sondakibaglanti;
        
        public Node(){
        }
    }
    
    static Node head;
    static Node tail = null;
    static int sinifsayisi = 0;
    static Scanner input = new Scanner(System.in);
    
    static void doublyOlustur(){

        try {
            input = new Scanner(new FileInputStream("ogrenciler.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı");
            System.exit(0);
        }
        while(input.hasNext()) {
            String bilgiler = input.nextLine();
            String[] splitListesi = bilgiler.split(",");
            int ogrenciNo=Integer.parseInt(splitListesi[0]);
            String adSoyad = splitListesi[1];           
            List listeYapisi;
            listeYapisi = Arrays.asList(splitListesi);           
            ArrayList<String> iletisimNumaralariliste = new ArrayList<>();
           for(int i=0;i<listeYapisi.size()-2;i++){
               String iletisimNumaralari2 = splitListesi[i+2];
                iletisimNumaralariliste.add(iletisimNumaralari2);
           }                                             
            Student ogrenci = new Student(ogrenciNo, adSoyad, iletisimNumaralariliste);
            DoublyLinkedList.siraliEkle(ogrenci);
            DoublyLinkedList.sinifsayisi += 1;
        }
    }
 
    static void ogrenciEkle(){
        Scanner input2 = new Scanner(System.in);
        System.out.println("Rehbere eklemek istediğiniz öğrencinin okul numarasını giriniz:");
        int ogrenciNo = input2.nextInt();
        input2.nextLine();
        System.out.println("Rehbere eklemek istediğiniz öğrencinin adını giriniz:");
        String adSoyad = input2.nextLine();
        System.out.println("Rehbere eklemek istediğiniz öğrencinin telefon numarasını(Birden fazla ise araya virgül koyarak) giriniz:");
        String iletisimNumaralari = input2.nextLine();
        ArrayList<String> iletisimNumaralariliste = new ArrayList<>();
        iletisimNumaralariliste.add(iletisimNumaralari);
        Student ogrenci = new Student(ogrenciNo, adSoyad, iletisimNumaralariliste);
        DoublyLinkedList.siraliEkle(ogrenci);
        DoublyLinkedList.sinifsayisi += 1;
    }

    static Object ogrenciSil(){
        Scanner input4 = new Scanner(System.in);
        Node a;
        int c = 1;
        a = head;
        if(head != null){
            System.out.println("Rehberden silmek istediğiniz öğrencinin okul numarasını giriniz:");
        int silinenOgrenciNo = input4.nextInt();
        while(a.ogrenciBilgi.getOgrenciNo() != silinenOgrenciNo){   
            a = a.sondakibaglanti;           
            if(a == null){
                System.out.println("Öğrenci bulunamadı.");
                c = 0;
                break;
            }
        }
        if (c == 1){
            System.out.println("Öğrenci silindi.");
        }
        if(a != null){
        if(a == head){
            head = a.sondakibaglanti;
        }else{
            a.bastakibaglanti.sondakibaglanti = a.sondakibaglanti;
        }        
        if(a == tail){
            tail = a.bastakibaglanti;
        }else{
            a.sondakibaglanti.bastakibaglanti = a.bastakibaglanti;
        }
        return a;
        }
        }
        else
            System.out.println("Liste boş olduğundan çıkarma işlemi yapılamaz!");       
        return null;       
    }

    static void ogrenciBul(){
        Scanner input3 = new Scanner(System.in);
        String girdi = input3.nextLine();
        Node gecici2;
        gecici2 = head;
        String b = "b";
        while (true)
        {           
            if (gecici2 != null){
            if (gecici2.ogrenciBilgi.getAdSoyad().equals(girdi)){
                System.out.print(gecici2.ogrenciBilgi + " ");
                System.out.println("");
                gecici2 = gecici2.sondakibaglanti;
                b = "a";
                if (gecici2 != null){
                while (gecici2.ogrenciBilgi.getAdSoyad().equals(girdi)){
                    System.out.print(gecici2.ogrenciBilgi + " ");
                    System.out.println("");
                 gecici2 = gecici2.sondakibaglanti;
                 b = "a";
                }
                }
            }
            }
            if (gecici2 == null){              
            break;
        }
            gecici2 = gecici2.sondakibaglanti;
        }
        
        if ("b".equals(b)){
            System.out.println("Öğrenci bulunamadı.");
        }
    }

    static void siraliEkle(Student ogrenciBilgi2)
    {
        Node a = new Node();
        a.ogrenciBilgi = ogrenciBilgi2;
        a.sondakibaglanti = null;
        if (head == null)
        {
            head = a;
            tail = a;
            head.bastakibaglanti = null;
            return;
        }
        if (a.ogrenciBilgi.getOgrenciNo() < head.ogrenciBilgi.getOgrenciNo())
        {
            a.bastakibaglanti = null;
            head.bastakibaglanti = a;
            a.sondakibaglanti = head;
            head = a;
            return;
        }
        if (a.ogrenciBilgi.getOgrenciNo() > tail.ogrenciBilgi.getOgrenciNo())
        {
            a.bastakibaglanti = tail;
            tail.sondakibaglanti = a;
            tail = a;
            return;
        }
        Node gecici = head.sondakibaglanti;
        while (gecici.ogrenciBilgi.getOgrenciNo() < a.ogrenciBilgi.getOgrenciNo())
            gecici = gecici.sondakibaglanti;
        (gecici.bastakibaglanti).sondakibaglanti = a;
        a.bastakibaglanti = gecici.bastakibaglanti;
        gecici.bastakibaglanti = a;
        a.sondakibaglanti = gecici;
    }

    static void kucuktenBuyugeYazdir(Node gecici)
    {
        if (gecici == null){
            System.out.println("Liste boştur.");
        }
        while (gecici != null)
        {
            System.out.print(gecici.ogrenciBilgi + " ");
            System.out.println();
            gecici = gecici.sondakibaglanti;
        }
    }

    static void buyuktenKucugeYazdir(Node referans)
    {
        Node kuyruk = referans;
        if (kuyruk!=null){
        while (kuyruk.sondakibaglanti != null)
        {
            kuyruk = kuyruk.sondakibaglanti;
        }
        while (kuyruk != referans)
        {
            System.out.print(kuyruk.ogrenciBilgi + " ");
            System.out.println();
            kuyruk = kuyruk.bastakibaglanti;
        }
        System.out.println(kuyruk.ogrenciBilgi );
        }
        else{
            System.out.println("Liste boştur.");
        }           
    }
}