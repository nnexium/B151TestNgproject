package techproed;

public class TESTNG_NOT {
/*

DAY 1

https://testng.org/doc/documentation-main.html

Junit'in gelismis versiyonudur.
İsmi Next Generation Test kelimelerinden türetilmiş, ve Cédric Beust tarafından oluşturulmuştur.
Açık Kaynak kodludur.
TestNG bir test kütüphanesidir.
TestNG sadece JAVA ile calisir ve JDK 7 ve daha ust versiyonlari gereklidir
TestNG ile ilgili dokumanlara asagidaki adresten ulasilabilir
>https://testng.org/doc/documentation-main.html

TestNG tester'lara daha fazla kontrol imkani verir ve testleri daha etkili yapmamizi saglar.
Tester'lar TestNG'yi etkili bir framework tasarlamak ve test case'leri TestNG annotation'ları ile
organize etmek için kullanırlar.
Test caseleri siralama ozelligi (priority) ve test caselerin birbirine bagimliligi (dependsOnMethod)
 bize testleri organize etmekte yardim eder.
Paralel ve Cross-Browser Test yapmamiza imkan tanir
Kullanisli HTML veya xml raporlari olusturmaya yarar
Data Provider ile DDT(data driven testing) imkani saglar

Bir TestNG sınıfı için yapılandırma bilgileri:

@BeforeSuite: Açıklamalı yöntem, bu paketteki tüm testler çalıştırılmadan önce çalıştırılacaktır.

@AfterSuite: Açıklamalı yöntem, bu paketteki tüm testler çalıştırıldıktan sonra çalıştırılacaktır.

@BeforeTest: Açıklamalı yöntem, <test> etiketi içindeki sınıflara ait herhangi bir test yöntemi çalıştırılmadan önce çalıştınlacaktır. @AfterTest: <test> etiketi içindeki sınıflara ait tüm test yöntemleri çalıştıktan sonra açıklamalı yöntem çalıştırılacaktır.

@BeforeGroups: Bu yapılandırma yönteminin daha önce çalışacağı grupların listesi. Bu yöntemin, bu gruplardan herhangi birine ait olan ilk test yöntemi çağrılmadan kısa bir süre önce çalışması garanti edilir.

@Gruplardan Sonra: Bu yapılandırma yönteminin peşinden çalışacağı grupların listesi. Bu yöntemin, bu gruplardan herhangi birine ait olan son test yöntemi çağrıldıktan kısa bir süre sonra çalışması garanti edilir.

@BeforeClass: Açıklamalı yöntem, geçerli sınıftaki ilk test yöntemi çağrılmadan önce çalıştırılacaktır.

@AfterClass: Açıklamalı yöntem, geçerli sınıftaki tüm test yöntemleri çalıştırıldıktan sonra çalıştırılacaktır.

@BeforeMethod: Açıklamalı yöntem, her test yönteminden önce çalıştırılacaktır.

@AfterMethod: Açıklamalı yöntem, her test yönteminden sonra çalıştırılacaktır.


DAY 2

Priority = Öncelik


TestNG (default) olarak @Test methodlarini alfabetik sıraya göre run eder. (Yukardan asagi degil!)

priority annotation Testlere öncelik vermek için kullanılır. Kucuk olan Numara daha once calisir

priority yazmayan Test method'u varsa priority= 0 kabul edilir, siralama buna gore yapilir

ÖRNEK:

Priority

public class C01 {
@Test
public void youtubeTest(){
}
System.out.println("youtubeTest calisti");

@Test
public void amazonTest(){
amazonTest calisti
}
System.out.println("amazonTest calisti");

@Test
public void bestBuyTest(){
}
System.out.println("bestBuyTest calisti");

HANGI SIRAYLA CALISIR?
amazonTest calisti
bestBuyTest calisti
youtubeTest calisti

Istedigimiz test methodunu tarayip ctrl + mouse sol tus surukle birak ile kopyalama islemi yapar


dependsOnMethods

Bu yontem, bir metodun diğer bir metoda bağlı olmasını sağlamak için kullanılır.
Yandaki ornekte, homePage metdod'u searchTest method'una bağlıdır. Yani, homePage başarılı olursa search Test de çalisacaktir.
Diger durumda yani, homePage başarısız olursa search Test ignore edilecek, hic çalismayacaktir.
Yalnızca search Test method'unu çalıştırırsak bile, TestNG önce homePage metodunu çalıştırır. homePage başarılı olursa search Test calistirilir

Ustteki madde sadece 2 method icin gecerlidir. 3 method'u birbirine baglayip 3.method'u calistirirsaniz, 1.method'a kadar gitmez.



Assertions

Test Otomasyonun temel noktalarından biri Assertions'dir.

Her bir test case icin bir Assertion veya Verification
kullanmalıyız.

TestNG ile iki cesit Asertion yapmak mumkundur.

1. ) Junit'te kullandigimiz sekilde Assert Class'indan method❜lar kullanarak
yapmak.

2. ) Junit'te olmayan, TestNG'ye ozel olarak kullanabilecegimiz SoftAssert Class'indan method❜lar kullanarak yapmak.

1.HARD ASSERT

JUnit'te Öğrendiğimiz Assertion ile aynidir. TestNG'de soft assertion da oldugundan,
ayristirmak icin bu isim kullanilmistir.
JUnit'ten bildigimiz uzere en çok kullandığımız 3 cesit hard assertion turu vardir

i. Assert.assertEquals()
ii. Assert.assertTrue()
iii. Assert.assertFalse()

Hard assertion herhangi bir assertion FAILED olursa, test method'nun calismasini durdurur ve
kalan kodlari yürütmez (stops execution).
Test case'in nerede FAILED olduğunu hemen anlamak ve kod'a direk mudahale etmek istenirse
hard assertion tercih edilebilir.


2. SOFT ASSERT (VERIFICATION)

SoftAssert doğrulama (verification) olarak da bilinir.
softAssert kullandigimizda, assert FAILED olsa bile test method'unun istediginiz kismini durdurmaz
ve yürütmeye devam eder. İf else statement'da olduğu gibi.
Test method'unun istedigimiz bolumde yapilan tum testleri raporlar
Eger assertion'lardan FAILED olan varsa raporlama yapilan satirdan sonrasini calistirmaz.
SoftAssert class'indaki method❜lari kullanmak icin kullanabilmemiz için object olusturmamiz gerekir.

Soft Assert

1.Adım: SoftAssert objesi olusturalim
        SoftAssert softAssert = new SoftAssert();
2.Adım: Istedigimiz sayida
        verification'lari yapalim
        soft Assert.assertTrue();
        softAssert.assertFalse(); ....
3.Adım: SoftAssert'in durumu raporlamasini isteyelim
softAssert.assertAll();-->action daki perform gibi


Soft Assert vs Hard Assert

• Ortak ozellikleri

SoftAssert ve HardAssert method'ları TestNG'den gelmektedir.
Kullanma amaçları farklı olsa da method❜lar aynıdır.

• Farklari

•Hard Assertion fail olursa test method❜larının execute etmesi durur. Ve FAILED olarak tanımlanır.
Eğer softAssert FAIL olursa test method'ları execute etmeye devam eder. assertAll dedigimizde
FAILED olan assertion varsa execution durur.







 */















}
