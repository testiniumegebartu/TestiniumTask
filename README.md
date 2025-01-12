# Test Automation Project
<br>

## 📋 Proje Hakkında 
Bu proje, bir web uygulamasını test etmek için geliştirilen bir test otomasyon framework'üdür. `Java`, `Selenium`, `Cucumber`, `TestNG`, `Log4j` ve `Allure raporlama` araçları kullanılarak geliştirilmiştir.

**Proje Özellikleri**:

- Sayfa Nesne Modeli (POM) tasarım deseni ile sayfa yönetimi.
- Çoklu tarayıcı desteği (Chrome, Firefox, Edge, Safari).
- Cucumber BDD formatında senaryo tanımları.
- Allure ile ayrıntılı test raporlaması.
- JSON tabanlı otomatik lokatör yönetimi.

## 📂 Proje Yapısı
```
TestiniumTask
│
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── Runner              # Test çalıştırma sınıfları
│   │   │   ├── Screens             # Sayfa sınıfları (POM)
│   │   │   ├── Steps               # Cucumber Step Definitions
│   │   │   ├── Tests               # BaseTest sınıfı
│   │   │   ├── Utils               # Yardımcı sınıflar (JsonReader)
│   │   │
│   │   ├── resources
│   │   │   ├── Features            # Cucumber Feature dosyaları
│   │   │   ├── locators            # JSON locator dosyası
│   │   │   ├── log4j.properties    # Log yapılandırma
│   │   │   ├── allure.properties   # Allure raporlama yapılandırma
│
├── pom.xml                         # Maven bağımlılıkları
├── README.md                       # Proje dökümantasyonu
```


## 🚀 Kurulum Talimatları
### Gerekli Ön Koşullar
1. **Java JDK (11)**:
- [Java JDK İndir](https://www.oracle.com/java/technologies/downloads/?er=221886)
- Yüklemeden sonra şu komutla doğrulayın:
```
java -version
```

2. **Maven**:
- [Maven İndir](https://maven.apache.org/download.cgi)
- Yüklemeden sonra doğrulama:
```
mvn -version
```

3. **Allure CLI**:
- [Allure CLI Kurulumu](https://allurereport.org/docs/install/)
- Kurulum için:
```
npm install -g allure-commandline --save-dev
```
- Doğrulama:
```
allure --version
```

# 📖 Projeyi Çalıştırma
1. **Projeyi klonlayın**:
```
git clone https://github.com/testiniumegebartu/TestiniumTask.git
cd TestiniumTask
```

2. **Maven bağımlılıklarını yükleyin**:
```
mvn clean install
```

3. **Testleri çalıştırın**:
```
mvn test
```

4. **Allure raporlarını oluşturun**:
```
allure serve allure-results
```

# 📖 Kullanım Yönergeleri

**Tarayıcı Seçimi**
- CucumberRunner sınıfında @Parameters ile tarayıcı belirleyebilirsiniz:
```
@Parameters({"browser"})
public void setup(@Optional("chrome") String browser) { ... }
```
**Cucumber Etiketleri ile Çalıştırma**
Belirli senaryoları çalıştırmak için Cucumber etiketleri kullanabilirsiniz:
```
@CucumberOptions(tags = "@smoke")
```
JSON Locator Yönetimi
- Locatorler `src/test/resources/locators/locators.json` dosyasında saklanır.

Örnek JSON Locator:
```
[
  {
    "key": "LoginButton",
    "value": "//button[@id='login']",
    "type": "xpath"
  }
]
```

# 🔧 Sorun Giderme
1. **Tarayıcı Açılmıyor**:
- Tarayıcı sürücülerini kontrol edin.
- WebDriverManager güncel mi?
  
2. **Allure Raporları Çalışmıyor**:
- Allure CLI'ın doğru kurulduğundan emin olun:
```
allure --version
```

3. **Bağımlılıklar Yüklenmiyor**:
- Maven temizleme yaparak tekrar deneyin:
```
mvn clean install
```

4. **Locator Bulunamıyor**:
- JSON dosyasındaki key değerini doğru kullandığınızdan emin olun.

# 🛠️ Kullanılan Teknolojiler
- Java 11+
- Selenium 4
- Cucumber 7
- TestNG
- Allure Raporlama
- Log4j
  
# ✨ Ek Özellikler

1. **Paralel Test Çalıştırma**:
- Maven parametreleri ile paralel testler çalıştırılabilir.
2. **Detaylı Raporlama**:
- Test sonuçları Allure ile detaylı bir şekilde analiz edilebilir.
