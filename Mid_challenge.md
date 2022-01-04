# Enoca Backend Developer

## Soru 1:

**Cevap:** Filtrede her değişiklik yapıldığında oluşan filtre dizisini API'ya göndererek, aldığımız sonucu ekrana yazabiliriz. Bu işlem için ajax, axios, fetch gibi methodlar kullanılabilir. ajax ve axios için ayrıca kütüphane gerekmektedir.

```javascript

    const filter_data={
        region: 0,
        service:0,
        flight_date:new Date(),
        .
        .
        .
    }
    fetch("/flights",{method:"POST", body:JSON.stringfy(filter_data)}).then();
```

## Soru 2:

**Cevap** unmodifiableList bir final olan değişkendir. Sonradan değişiklik yapılamaz. Aşağıdaki örnekteki gibi, değişiklik yapmak isterseniz, UnsupportedOperationException hatası alırsınız.

```java
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class App
{
    private static final String[] LIST = {"1","2","3"};


    public static final List<String> getList()
    {
    return Collections.unmodifiableList(Arrays.asList(App.LIST));
    }

    public static void main(String[] args)
    {
    List<String> list = App.getList();
    list.remove(0);
    System.out.println(list);
    }
}
```

Alınacak exception : `java.lang.UnsupportedOperationException`

## Soru 3: `Projenin yazılması`

## Soru 4:

**Cevap** Server IP adresi, şifresi ve kullanıcı adı varsa:
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

## Soru 5:
```java

@PostMapping(path="/customer", 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer customer(@RequestBody Customer customer) {
        if(customer.firstName!=null && customer.lastName!=null && customer.age<0 ) // Class parametrelerinin kontrol işlemi basit olarak
        customerService.customerSave(customer);
        return customer;
    }


```

```java
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Data
public class Customer {
   //Bos birakilamaz Annotation'u
   @NotEmpty(message = "Isim bos bırakılamaz.")
   private String firstName;
   //Bos birakilamaz Annotationu
   @NotEmpty(message = "Soyisim bos birakilamaz.")
   private String surname;
   //Min value Annotation'u
   @Min(value = 18, message = "18 yasindan kucuk musteri olamaz.")
   private int age;
   //Mail check Annotation'u
   @Email(message = "Hatali email")
   private String email;
   //Regex Annotation'u
   @Pattern(regexp ="[0-9\\s]{12}")
   private String phone;
}
```
## Soru 6:

**Cevap** Error vs Exceptions

Error: Bir kodun, projenin işleyişe uygun olmayan veya hatalı yazıldığı parçası, satırı veya fonksiyonudur.
Exceptions: Oluşan hataların JVM üzerinde atılması(Throwable) işlemidir.

```java
 try {

            List<Character> list = new ArrayList<Character>();

            list.add('X');
            list.add('Y');

            System.out.println("Initial list: " + list);

            List<Character> immutablelist = Collections
                                                .unmodifiableList(list);

            immutablelist.add('Z'); //Error
        }

        catch (UnsupportedOperationException e) {//Exception
            System.out.println("Exception thrown : " + e);
        }

```

## Soru 7

**Cevap**

- Super
  _Super methodu bir üst sınıfa ait constructor yerine geçer, üst sınıfta overload edilmiş constructorlar tanımlı ise, hangisini çağıracağını, kullanılan parametreler belirler._
- this
  _Bir metodun içerisinde o metodun ait olduğunu sınıftan türetilen nesneyi veya nesnenin bir alt değişkenini tanımlamamız gerektiğinde kullandığımız ifade._
- final
  _Bir kez tanımlandıktan sonra değiştirilemeyen veya sonradan türetilemeyen bir varlığı tanımlar._

## Soru 8

**Override**

```java
class A{
    void example(){
        System.out.println("Class A");
    }
}
class B extends A{
    @Override
    void example(){
        System.out.println("Class B");
    }
}
class Main {
    public static void main(String[] args)
    {

        A obj1 = new A(); //obj2 is A object
        obj1.example();
        //Output:
        // Class A
        A obj2 = new B(); //obj2 is A object, but it has B metods.
        obj2.example();
        //Output:
        //Class B
    }
}
```

**Overload**

```java
class A{
    void example(){
        System.out.println("Class A 1");
    }
    void example(int a){
        System.out.println("Class A 2");
    }
    void example(int a,int b){
        System.out.println("Class A 3");
    }
}

class Main {
    public static void main(String[] args)
    {

        A obj1 = new A();
        obj1.example();
        //Output:
        // Class A 1
        obj1.example(1);
        //Output:
        // Class A 2
        obj1.example(1,2);
        //Output:
        // Class A 3

    }
}
```

## Soru 9:

Int primitive değişken tipidir. Sınıf olmadığı için herhangi bir metodu yoktur.
Integer bir sınıftır ve metodları mevcuttur. Integer sınıfı içerisinde int veri tipini barındırır

```java
int a = Integer.MIN_VALUE;
Integer b = Integer.MIN_VALUE;
System.out.println(a==b);//true
int c = Integer.parseInt("5");

```

## Soru 10:

Checked Exception IOException, SQLException gibi sınıflardır. catch() ile yakalanmaları mecburidir.
Unchecked Exception RuntimeException sınıfından kalıtırlar. ArithmeticException, NullPointerException gibi sınıflardır.
catch() ile yakalanmaları mecburi değildir.

### Checked Exception

```java
 public static void main(String[] args)
        throws IOException
    {

        // Creating a file and reading from local repository
        FileReader file = new FileReader("C:\\test\\a.txt");

        // Reading content inside a file
        BufferedReader fileInput = new BufferedReader(file);

        // Printing first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        // Closing all file connections
        // using close() method
        // Good practice to avoid any memory leakage
        fileInput.close();

        /*
            First three lines of file "C:\test\a.txt"
        */
    }
```

### Unchecked Exception

```java
    int x = 0;
    int y = 10;
    int z = y / x;

    /*
    Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Main.main(Main.java:5)
    Java Result: 1
    */
```

## Soru 11:

```sql
CREATE TABLE `REMAINING` (
	`PRODUCT` INT NOT NULL,
	`USER` INT NOT NULL,
	`PK` INT NOT NULL AUTO_INCREMENT,
	`STARTDATE` DATE NOT NULL DEFAULT 'CURRENT_TIMESPAN',
	`EXPIREDATE` DATE NOT NULL DEFAULT 'CURRENT_TIMESPAN',
	PRIMARY KEY (`PK`)
) ENGINE=InnoDB;

CREATE TABLE `USER` (
	`PK` INT NOT NULL AUTO_INCREMENT,
	`NATIONALITY` INT NOT NULL,
	`NAME` VARCHAR NOT NULL,
	`MAIL` VARCHAR NOT NULL,
	`PHONE` VARCHAR NOT NULL,
	PRIMARY KEY (`PK`)
) ENGINE=InnoDB;

CREATE TABLE `NATIONALITY` (
	`PK` INT NOT NULL AUTO_INCREMENT,
	`NAME` VARCHAR NOT NULL,
	PRIMARY KEY (`PK`)
) ENGINE=InnoDB;

CREATE TABLE `PRODUCT` (
	`PK` INT NOT NULL AUTO_INCREMENT,
	`NAME` VARCHAR NOT NULL,
	`CODE` VARCHAR NOT NULL,
	PRIMARY KEY (`PK`)
) ENGINE=InnoDB;

 Select USER.PHONE,USER.MAIL,NATIONALITY.NAME as NATIONALITYNAME,PRODUCT.NAME as PRODUCTNAME,PRODUCT.CODE as PRODUCTCODE,REMAINING.STARTDATE,REMAINING.EXPIREDATE from USER
 inner join REMAINING on REMAINING.USER=USER.PK
 inner join NATIONALITY on NATIONALITY.PK=USER.NATIONALITY
 inner join PRODUCT on PRODUCT.PK=REMAINING.PRODUCT;
```

## Soru 12:

Aynı interface'i veya abstract sınıfı implement etmiş etmiş factory nesnelerinin üretiminden sorumlu pattern dir.

```java
public enum VehicleType
{
    Car = 1,
    Truck = 2,
    Motorcycle = 3
}

public interface IVehicleFactory
{
    IVehicle ProduceVehicle(VehicleType type);
}

public class VehicleFactory : IVehicleFactory
{
    public IVehicle ProduceVehicle(VehicleType type)
    {
        IVehicle vehicle = null;
        switch (type)
        {
            case VehicleType.Car:
                vehicle = new Car();
                break;
            case VehicleType.Truck:
                vehicle = new Truck();
                break;
            case VehicleType.Motorcycle:
                vehicle = new Motorcycle();
                break;
        }
        return vehicle;
    }
}

class Program
{
    static void Main(string[] args)
    {
        var vehicleFactory = new VehicleFactory();

        IVehicle vehicleCar = vehicleFactory.ProduceVehicle(VehicleType.Car);
        vehicleCar.DisplayInfo();

        IVehicle vehicleMotorcycle= vehicleFactory.ProduceVehicle(VehicleType.Motorcycle);
        vehicleMotorcycle.DisplayInfo();
    }
}
```

## Soru 13:

Abstract Java'da ortak özelliklerin birleştirildiği bir yapıdır. extends ile kalıtım sağlanır. Ortak methodların yazılmasını sağlar. Bir sınıfa bir tane abstract class extends edilebilir.

```java
public abstract class Animal {
  public boolean isAPet = true;
  public String owner = "Fred";


  public void sleep(){
    System.out.Println("Sleeping");
  }

  public void eat() {
     System.out.Println("Eating");
  }
}


public class Cat extends Animal{
  public void meow(){
     System.out.Println("Meow ! ");
  }
}
```

Interface ise boş methodların tanımlandığı, "implements" edildiği class(sınıf)'ın ne yapabileceğini belirten yapılardır. Interface üzerinden nesne oluşturulamaz. Bir sınıf birden fazla interface ile implements edilebilir. Eğer bir sınıfa bir interface implements edilmişse o sınıfta interface üzerindeki tüm methodların doldurulması zorunludur.

```java
interface in1 {
  final int a = 10;
  void display();
}

class testClass implements in1{
  public void display(){
    System.out.Println("Geek");
  }

 public static void main(String [] args)
 {
  testClass t = new testClass();
  t.display();
  System.out.println(t.a);
 }
}
```

## Soru 14:

**@Service** - Belirtilen sınıfın bir servis sınıfı olduğunu belirtir.
**@Repository** - Veritabanı işlemlerini gerçekleştirme yeteneği olan yapıldığı repository sınıfını belirtir.
**@Configuration** - Bean tanımlamaları gibi tanımlamalar için bir Bean sınıfı olduğunu belirtir
**@Controller** - Requestleri yakalayabilme yeteneği olan bir web controller sınıfını belirtir.
**@RequestMapping** - controller sınıfının handle ettiği HTTP Requestlerin path eşleştirmesini yapar
**@Autowired** - Constructor, Değişken yada setter metodlar için dependency injection işlemi gerçekleştirir
**@SpringBootApplication** - Spring Boot autoconfiguration ve component taramasını aktif eder.

## Soru 15:
Dependency Injection bağımlılık oluşturacak parçaların ayrılıp, bunların dışardan verilmesiyle sistem içerisindeki bağımlılığı minimize etme işlemidir. 

### Dependency Injection olmadan:
```java
class Vasita
{
    Araba araba;
    public Vasita()
    {
        araba = new Araba(); // Burada vasıta için sadece araba sınıfından üretilmiş nesne kullanılabilir.
    }
 
    public void Kullan()
    {
        araba.GazVer();
        araba.SagaSinyal();
        araba.FrenYap();
        araba.SolaSinyal();
    }
}


```
### Dependency Injection uygulanınca:
```java
interface ITasit
{
    void GazVer();
    void FrenYap();
    void SagaSinyal();
    void SolaSinyal();
}
class Araba implements ITasit
{
    public void GazVer()
    {
        //...
    }
    public void FrenYap()
    {
        //...
    }
    public void SagaSinyal()
    {
        //...
    }
    public void SolaSinyal()
    {
        //..
    }
}

class Vasita
{
    ITasit _tasit;
    public Vasita(ITasit tasit) // ITasit tipindeki herhangi bir class olabilir artık. Motorsiklet, otobus vs...
    {
        _tasit = tasit;
    }
 
    public void Kullan()
    {
        _tasit.GazVer();
        _tasit.SagaSinyal();
        _tasit.FrenYap();
        _tasit.SolaSinyal();
    }
}
```