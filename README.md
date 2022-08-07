# BTK-SQLiteLearningProject

## Kotlin İle Android Mobil Uygulama Geliştirme Eğitimi Temel Seviye (BTK AKADEMİ) Notlarım

> SQLite dediğimiz androidin kullandığı ve telefonun içinde local olarak saklanan bir veritabanı ile çalışacağız. Yapacağımız işlemler sunucuda değil herkesin kendi telefonunda saklanacak. SharedPreferences gibi telefonda data klasörünün altında oluşturulup saklanacak. Yani bu veriler başka bir kullanıcı tarafından başka bir telefondan görülemez.

> SQL (Structure Query Language); yapısal query dili demektir.

> Query; sorgu demektir.

> Bu projede kullanıcı arayüzü ile ilgili pek çalışma yapılmadı kodlara odaklandık.

## try - catch mekanizması

> Bu bize hata verebilecek durumlarda kullanılır. Aldığımız hata sonucu uygulamanın çökmesini istemiyorsak ve hatayı ele alıp kullanıcıya bir mesaj göstermek veya loglara yazdırıp hatayı debug etmek istiyorsak  try - catch mekanizmasını kullanırız. 

> try içindeki kod blokları denenir ve bir hata alındığında catch içinde belirlenen kodlar kullanılır. 

> try dedikten sonra catch kullanmak zorundayız. try denemek, catch ise yakalamak demektir. 

> Yakalanacak hata türünü catch'e parametre olarak vermemiz gerekir. Biz Exception verdik. Exception istisnademek ama aslında hata. 

```kotlin
// Tüm hatayı loglara yazdırır:
exception.printStackTrace()
```

> Eğer istersek hatayı kullanıcıya da gösterebiliriz. 

> Bu projede tüm SQLite kodlarını try içine yazacağız. 

> Excel'de açtığımız sayfalar SQLite'da tablo olarak geçer. Tablolardada row ve column'lar var içlerinde de verilerimiz var. 

> SQLite kodlarını online çalıştırabileceğim bir site:

![image](https://user-images.githubusercontent.com/109730490/183300995-b6f67a11-6a5f-40ba-a120-563c3cfd410e.png)

## SQLite veritabanı ve tablo oluşturmak

![image](https://user-images.githubusercontent.com/109730490/183301521-7c5ad598-70b4-4d27-bf29-9906ba7b41d7.png)

- 1: Eğer yoksa bir tablo oluştur

- 2: tablonun adı

> 3 , 4 ve 5 tablonun kolonları

- 3: id adında bir kolon oluşturduk. INTEGER tipinde veri tutacak ve PRIMARY KEY olacak yani id rakamları benzersiz ve düzgün artış gösteren bir yapıda olacak.

- 4: name adında bir kolon oluşturduk. VARCHAR tipinde veri tutacak.

- 5: price adında bir kolon oluşturduk INT tipinde veri tutacak.

> 3'te INTEGER dedik ama5'te INT dedik. Genelde INT olarak veririz ama 3'te durumundan ötürü INTEGER demek zorundaydık.

## Oluşturulan Tabloya Veri Eklemek

![image](https://user-images.githubusercontent.com/109730490/183304410-ebed91bd-36a2-4757-9bb7-0f0b0d9757d2.png)

> INSERT INTO products: products tablosunun içine koy

> Query'ler veritabanından verileri okumak için yazdığımız komutlardır. 

> * SQL'de everything yani her şey anlamına gelir. * kullandığımızda her şey seçilir.

> SQLite'ta cihaza kaydettiğimiz veriler uygulama tamamen cihazdan silinene kadar silinmez. Yani telefonu veya uygulamayı tamamen kapatmamız verileri etkilemez. 

> Eğer SQLite kodlarında bir hata yaparsak ve veriler kaydolmazsa hatayı düzelttikten sonra uygulamayı tamamen kapatığ telefondan silmemiz gerekiyor. 

## Proje Hakkında Bilgi

> Bu projede arayüzde bir geliştirme yapmadık.

> Sadece MainActivity.kt dosyasında çalıştık.

> Yaptığımız işlemlerin başarılı olup olmadığını logcat bölümünden kontrol ettik.

## Kaynaklar

- [BTK Akademi](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274)
