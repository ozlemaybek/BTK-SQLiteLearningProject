package com.ozlem.sqlitelearningproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // try-catch:
        try {
            // Veritabanını oluşturalım:
            // openOrCreateDatabase(): Hali hazırda varsa aç yoksa baştan oluştur.
            // openOrCreateDatabase() 3 parametre alır:
            // 1: database'imizin ismi , 2: Veritabanımızın modu (kim kullanabilir) 3: factory
            // 3. parametreyi şu anda kullanmayacağımız için null verdik.
            // Bu satırda yaptığımız aslında bir SQLite veritabanı dosyası oluşturmak
            val database = this.openOrCreateDatabase("Products" , Context.MODE_PRIVATE , null)
            // Veritabanı oluşturulduktan sonra yapılacak işlemlerin hepsi SQL diliyle alakalı
            // Şimdi veritabanımızda bir tablo oluşturalım:
            database.execSQL("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY , name VARCHAR , price INT)")

            // Oluşturduğumuz tabloya veri ekleyelim
            // id'yi primary key olarak oluşturduğumuz için ona veri girmeyeceğiz kendisi otomatik olarak atanıp artacak
            // Bu satır uygulamayı her çalıştırdığımda veritabanına tekrar kaydolacak
            // veritabanı aynı değerlerle dolabilir
            // Uygulamayı bir kez çalıştırdıktan sonra aşağıdaki satırı yoruma aldım:
            // database.execSQL("INSERT INTO products (name , price) VALUES('Shoes' , 100)")
            // database.execSQL("INSERT INTO products (name , price) VALUES('Dress' , 200)")
            // database.execSQL("INSERT INTO products (name , price) VALUES('Jacket' , 300)")
            // database.execSQL("INSERT INTO products (name , price) VALUES('Glasses' , 400)")
            // database.execSQL("INSERT INTO products (name , price) VALUES('Pants' , 500)")


            // Kaydettiğimiz değeri veritabanından çekelim:
            // ikinci parametre filtreleme yapmak için kullanılır. Şuan yapmayacağımız için null dedik.
            val cursor = database.rawQuery("SELECT * FROM products" , null)
            // cursor(imleç) tüm veri alanlarını gezip onları çekmemizi sağlayacak
            // Fakat cursor'a nereye gideceğini söylemek için hangi kolonun kaçıncı kolona yerleştirildiğini bilmeliyiz.

            // VERİTABANINDAN VERİ SİLMEK VEYA GÜNCELLEMEK:
            // SİLMEK:
            database.execSQL("DELETE FROM products WHERE id = 5")
            // GÜNCELLEMEK:
            database.execSQL("UPDATE products SET price = 250 WHERE name = 'Dress'")



            // Sadece name=Dress olanları almak isteseydim:
            val cursor1 = database.rawQuery("SELECT * FROM products WHERE name = 'Dress'" , null)
            // Sadece id=3 olanı almak isteseydim:
            val cursor2 = database.rawQuery("SELECT * FROM products WHERE id = 3" , null)
            // Sadece name'i A ile başlayan veri satırlarını almak isteseydim:
            val cursor3 = database.rawQuery("SELECT * FROM products WHERE name LIKE 'D%'" , null)
            // Sadece name'i S ile biten veri satırlarını almak isteseydim:
            val cursor4 = database.rawQuery("SELECT * FROM products WHERE name LIKE 'S%'" , null)

            // Hangi kolonun kaçıncı indexte olduğunu alalım:
            val idColumnIndex = cursor.getColumnIndex("id")
            val nameColumnIndex = cursor.getColumnIndex("name")
            val priceColumnIndex = cursor.getColumnIndex("price")

            // Şimdi cursor'ı tek tek gezdirelim ve verileri okuyalım:
            while (cursor.moveToNext()){
                // parantez anlamı: cursor bir sonraki veriye hareket edebildiği yere kadar while devam edecek
                println("ID : ${cursor.getInt(idColumnIndex)}")
                println("NAME : ${cursor.getString(nameColumnIndex)}")
                println("PRICE : ${cursor.getInt(priceColumnIndex)}")
            }
            // Okuma işlemlerim bitti şimdi cursor'ı kapatmalıyım:
            cursor.close()

            // Şuan da println çıktılarını logcat'ten görebiliriz.
            
        }catch (e : Exception){
            // Hatayı log'lara yazdırır:
            e.printStackTrace()
        }

    }

}