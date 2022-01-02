# Enoca Backend Developer

## Soru 1 - MVC kavramını açıklar mısınız ? Neden ihtiyaç duyuluyor. Java’da nasıl kurgulanıyor. Object Oriented katmanları nelerdir ?

### Cevap:
MVC bir yazılım mimari tasarımıdır. Açılımı Model View Controller şeklindedir. 
Model, MVC’de projenin iş mantığının (business logic) oluşturulduğu bölümdür. İş mantığıyla beraber doğrulama (validation) ve veri erişim (data access) işlemleri de bu bölümde gerçekleştirilmektedir.
View, MVC’de projenin arayüzlerinin oluşturulduğu bölümdür. Bu bölümde projenin kullanıcılara sunulacak olan HTML dosyaları yer almaktadır. 
Controller, MVC’de projenin iç süreçlerini kontrol eden bölümdür. Bu bölümde View ile Model arasındaki bağlantı kurulur. Kullanıcılardan gelen istekler (request) Controller’larda değerlendirilir, isteğin detayına göre hangi işlemlerin yapılacağı ve kullanıcıya hangi View’ın döneceği (response) belirtilir.
Java'da MVC Spring ile birlikte kullanılabilir. Maven ile birlikte gerekli paketlerin kurulumu yapıldıktan sonra Model, Controller ve View dosyaları hazırlanır.

Servlet container tarafından uygulamaya ait ayarlar XML(web.xml) veya Java Tabanlı(ServletContainerInitializer) olarak alınır ve işlem başlatılır.
Servlet başlangıcında ServletContextListener arayüzünü uygulayan bir sınıf(ContextLoaderListener) belirtilirse(listener-class, addListener) Servlet başlatıldığında(contextInitialized) Servlet context alanına Spring MVC RootContext yüklemesi yapar.
RootContext varsayılan olarak ContextLoader.properties dosyasında belirtilen context sınıfını(XmlWebApplicationContext) kullanır.
RootContext oluşturulduktan sonra ayar dosyasında belirtilen servlet(servlet-class, addServlet) sınıfının(DispatcherServlet) bir örneği oluşturularak Servlet yaşam döngüsü çalıştırılır.
DispatcherServlet Spring MVC tarafından Front-Controller olarak kullanılan sıradan bir Servlet sınıfıdır. (DispatcherServlet->FrameworkServlet->HttpServletBean->HttpServlet)

**Model**
```java
//Model
public class Mesaj {

    private String mesaj;

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}

// Controller
@Controller
public class HomeController {

    @GetMapping
    public String index(ModelMap modelMap) {
        Mesaj mesaj = new Mesaj();
        mesaj.setMesaj("Merhaba Spring MVC!");
        modelMap.addAttribute("mesaj", mesaj.getMesaj());
        return "index";
    }

}
```
```jsp
<!-- View -->
<html>
    <body>
        <h1>${mesaj}</h1>
    </body>
</html>
```
**Object Oriented Katmanları:**
Storage -> DataAccess: Veritabanları, verilerin kaydedildiği katman.
Business Logic: Kaydedilen verilerin işlendiği katman. Modeller
Command Processor: Verilerin arayüz/kullanıcı ile bağlantısını sağlayan katman. Controller
User Interface: Kullanıcının verilere kolay ulaşabildiği katman. View. HTML, JSP dosyaları veya POSTMAN gibi request yapabilen uygulamalar.

## Soru 2 - Birbirinden bağımsız iki platformun birbiriyle haberleşmesi nasıl sağlanabilir. Örneğin, X platformu Java ile yazılmış olsun, Y platform u C# ile. Bu iki platformun bir biri ile iletişim halinde request-response ilişkisi kurması gerekiyor. Bu  yapıyı nasıl sağlarız.

### Cevap:
Birbirinden bağımsız iki platformu API'ler yardımı ile haberleştirebiliriz. Java Spring ve ASP.Net projemizde oluşturulan API'ler yardımı ile bir projeden diğerine sorgu gönderip, CRUD işlemlerini gerçekleştirebiliriz. 
Örneğin Java platformundan GET Request yaptığımızda, C# platformunda JSON Response ile veritabanı bilgilerini çekebiliriz. 
```java
URL url = new URL("https://dotnetproject/echo/post/json");
HttpURLConnection http = (HttpURLConnection)url.openConnection();
http.setRequestMethod("POST");
http.setDoOutput(true);
http.setRequestProperty("Content-Type", "application/json");

String data = "{\"login\":\"my_login\",\"password\":\"my_password\"}";

byte[] out = data.getBytes(StandardCharsets.UTF_8);

OutputStream stream = http.getOutputStream();
stream.write(out);

System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
http.disconnect();
```

**Diğer Örnekler:**
Bir başka seçeneğimiz TCP bağlantıları ile iletişim sağlayabiliriz. C# platformumuz C# Server olursa eğer, oradaki TCP URL üzerinden bir JAVA TCP Client oluşturarak iletişim kurmalarını sağlayabiliriz. Java ile Request yaptığımız C# kısmından TCP ile response alabiliriz. 

Socket.io gibi bir kütüphane ile iletişim kurmalarını sağlayabiliriz. 



## Soru 3 - Bir web sayfasında ekran sürekli Backend’ den veya bir başka yapı tarafından güncelleniyor. Siz, web sayfasını refresh etmeden bu güncel bilgiyi anlık ekrana nasıl yansıtırsınız?

### Cevap:
 Arayüzde backend kısmında yapılan herhangi bir değişikliği veya farklı bir sistemden çekilen verileri anlık olarak ekranda gösterebilmek için javascript kütüphanelerinden yararlanılır. API veya realtime veri gönderimi sağlayan (socket.io) gibi yapılarla arayüz oluşturulabilir.

API sistemi için axios, fetch veya ajax kullanılabilir.

```javascript
    function getUIDatas(){
        fetch("/flights",{method:"GET")
        .then((response)=>response.json)
        .then((data)=>{...});
    }
```

Socket.IO, MQTT gibi kütüphanelerde de event oluşturularak veriler kullanılır.

```javascript
 socket.on('data', (response)={...})
```

## Soru 4 - Bir for döngüsü ile aşağıdaki çıktıyı yazar mısınız.

```
*
**
****
******
********
**********
```

### Cevap:


```java
static void stars(int rows){
    for(int i = 0; i < rows; i++){
        for(int j = i; j >= 0; j-- ){
            System.out.print('*');
        }
        System.out.print('\n');
    }
}
public static void main(String []args){
    stars(5);
}
```

## Soru 5 - Firmada çalışman için sana remote bir linux server verildi. Elinde ip adresi port bilgisi kullanıcı adi ve şifren var. Server a erişimi nasıl test edersin, Server a nasıl erişirsin, Server a nasıl dosya atarsın, Serverdan nasıl dosya çekersin.

### Cevap:
Terminalden

```bash
    ssh username@ipaddress:port
```

yazarım ve sonrasında şifresini girip SSH bağlantısı sağlayabilirim.
Dosya aktarımı için:

```bash
   $ sftp username@ipaddress:port
   $ password
   $ cd your/path
   $ put local/file/path/name
   $ quit
```

veya
Dosya aktarımı için:

```bash
   $ scp local/file/path/name username@ipaddress:port:your/path
   $ password
```

## Soru 6 - Proje Sorusu

### Cevap:

**Adım 1:** Veritabanı olarak **POSTGRESQL** kurulumu yapıldı. 
**Adım 2:** [Start Spring](https://start.spring.io) üzerinden gerekli bağımlılıkları seçerek projemi oluşturdum. 
**Adım 3:** Model, View, Controller, Repository, Service gibi katmanları hazırlayarak projemi oluşturdum.

## Soru 7 - Apache Solr servisine yazılacak bir query örneği Apache Solr kullanılan sql programlarından daha farklı runtime bir database. Solr a hali hazırda kayıtlı bir alan olduğunu düşünelim. Alanın ismi “updatedAt” long tipinde tutulan bir alan. Ben 2020 Ocak ayından sonraki verileri getir dediğimde solr a nasıl bir query yazılmalı. http://example?query= kısmını nasıl doldurmalıyım?
Öncelikle verilen tarihin long tipine dönüştürülmesini sağlarım. 
```javascript
const longDate = new Date('2020-01-01T00:00:00Z')*1;
```
Sonuç: **1577836800000**

**İstek atılacak url:**
```curl
http://example/query?fq=updateAt:{1577836800000%20TO%20*}&indent=true&q.op=OR&q=*:*
```