@allScenarios
@loginAccount

Feature: Login Dashboard and My Account Tests

  @login @smoke @regression
  Scenario: Dogru Kullanıcı Bilgileriyle Giris Yapma Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * Kullanıcının hesabına giriş yapıp yapmadığı kontrol edilir

  @login @regression
  Scenario: Yanlıs Kullanıcı Bilgileriyle Giris Yapilamamasi Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "deneme123" olarak login olunur
    * "Username or Password Invalid!" texti kontrol edilir
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir

  @login @regression
  Scenario: Bos Username Ve Password Ile Giris Yapma Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Login butonuna tıklanır
    * "Username or Password Invalid!" texti kontrol edilir
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir

  @login @smoke @regression
  Scenario: Dashboard Ekranı Bilgilerinin Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Challenge name:" texti kontrol edilir
    * "QE Uygulama" texti kontrol edilir
    * "Start time:" texti kontrol edilir
    * "08-01-2025 10:00:02" texti kontrol edilir
    * "End time:" texti kontrol edilir
    * "12-01-2025 23:59:39" texti kontrol edilir
    * "Manager name:" texti kontrol edilir
    * "QAManager" texti kontrol edilir
    * "Company name:" texti kontrol edilir
    * "Testinium" texti kontrol edilir
    * Logout butonunun görünür olup olmadığı kontrol edilir
    * "Logout" butonu kontrol edilir
    * Open Money Transfer butonunun görünür olup olmadığı kontrol edilir
    * "Open Money Transfer" butonu kontrol edilir

  @login @smoke
  Scenario: Open Money Transfer Butonunun Fonksiyonel Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Open Money Transfer" butonu kontrol edilir
    * "Open Money Transfer" butonuna tıklanır

  @login @smoke
  Scenario: Logout Butonunun Fonksiyonel Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Logout" butonuna tıklanır


    # My Account Scenarios:

  @account @smoke @regression
  Scenario: My Account Ekrani Bilgilerinin Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Open Money Transfer" butonuna tıklanır
    * "My account" texti kontrol edilir
    * "Account name" texti kontrol edilir
    * "egebartu" texti kontrol edilir
    * "Account type" texti kontrol edilir
    * "CHECKING" texti kontrol edilir
    * "Creation time" texti kontrol edilir
    * "08-01-2025 10:02:20" texti kontrol edilir
    * "Amount" texti kontrol edilir
    * Bakiyede değer gözüktüğü kontrol edilir
    * "Transactions" texti kontrol edilir
    * "Transfer money" butonu kontrol edilir
    * "Add money" butonu kontrol edilir
    * "Edit account" butonu kontrol edilir

  @account @smoke
  Scenario: Transfer Money Butonunun Fonksiyonel Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Open Money Transfer" butonuna tıklanır
    * "Transfer money" butonuna tıklanır
    * "Transfer money" overlayinin açılıp açılmadığı kontrol edilir

  @account @regression
  Scenario: Add Money Butonunun Fonksiyonel Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Open Money Transfer" butonuna tıklanır
    * "Add money" butonuna tıklanır
    * "Add money" overlayinin açılıp açılmadığı kontrol edilir

  @account @regression
  Scenario: Edit Account Butonunun Fonksiyonel Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Open Money Transfer" butonuna tıklanır
    * "Edit account" butonuna tıklanır
    * "Edit account" overlayinin açılıp açılmadığı kontrol edilir

  @account @regression
  Scenario: My Account Back Navigasyon Butonunun Fonksiyonel Kontrolu
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Open Money Transfer" butonuna tıklanır
    * "MyAccountBackNavigationButton" elementine tıklanır




