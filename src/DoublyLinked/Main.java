package DoublyLinked;

import java.util.*;

public class Main {                // Metotlarla ilgili gerekli açıklamalar rapor dosyasında bulunmaktadır.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean tamamlanma = false;
        do{
            System.out.println("------------------------Menü------------------------");
            System.out.println("""
                    1-Dosyadan okuma yaparak çift bağlı liste oluşturma
                    2-Girilen yeni öğrenciyi sıralı şekilde listeye ekleme
                    3-Adı ve soyadı girilen öğrenciyi ekrana yazdırma
                    4-Öğrenci numarasıyla listeden öğrenci silme
                    5-Öğrenci numarası artan sırada rehberi yazdırma
                    6-Öğrenci numarası azalan sırada rehberi yazdırma
                    7-Çıkış\s""");
            System.out.println("----------------------------------------------------");
            System.out.println("Yapmak istediğiniz işlem için bir sayı giriniz(1-7):");
            int menu;
            try {
                menu = input.nextInt();
                input.nextLine();
                switch (menu){
                case 1 -> {
                    System.out.println("Dosyadan okuma yapılarak listeye öğrenciler yerleştirildi.");
                    System.out.println();
                    DoublyLinkedList.doublyOlustur();
                    break;
                }
                case 2 -> {                             
                    try {
                        DoublyLinkedList.ogrenciEkle();
                        System.out.println("Öğrenci rehbere eklendi.");    
                    System.out.println(); 
                    }catch (Exception e){
                        System.out.println("Hatalı giriş yaptınız.");
                    }              
                    break;
                }
                case 3 -> {
                    System.out.println("Listede aramak istediğiniz öğrencinin adını ve soyadını giriniz:");
                        DoublyLinkedList.ogrenciBul();
                    System.out.println();           
                    break;
                }
                case 4 -> {                    
                    try{
                        DoublyLinkedList.ogrenciSil();
                        System.out.println();  
                    }catch (Exception e){
                        System.out.println("Hatalı giriş yaptınız.");
                    }                       
                        break;
                }
                case 5 -> {                   
                        System.out.println("Öğrenci numaraları artan sırada ekrana yazdırılıyor...");
                        DoublyLinkedList.kucuktenBuyugeYazdir(DoublyLinkedList.head);
                        System.out.println();  
                        break;
                }
                case 6 -> {                   
                        System.out.println("Öğrenci numaraları azalan sırada ekrana yazdırılıyor...");
                        DoublyLinkedList.buyuktenKucugeYazdir(DoublyLinkedList.head);
                        System.out.println();   
                        break;
                }
                case 7 -> {
                    System.out.println("Rehberden çıkış yapılıyor...");
                    tamamlanma = true;
                    break;
                }
                default -> System.out.println("Hatalı sayı girişi yaptınız 1-7 dahil bir sayı tuşlayınız!");
            }
            }
            catch(Exception e){
                System.out.println("Hatalı veri girişi yaptınız 1-7 dahil bir sayı tuşlayınız!");
                input.nextLine();
            }
        }
        while(!tamamlanma);
    }
}