@allScenarios
@accountManagement

Feature: Edit Account Ekrani Bilgilerinin Kontrolu

  Background:
    * Kullanıcının Login sayfasında olup olmadığı kontrol edilir
    * Kullanıcı kullanıcı adını "egebartu.teker" ve şifreyi "B1a2r3t4u5*" olarak login olunur
    * "Open Money Transfer" butonuna tıklanır



  @transferMoney @smoke @regression
  Scenario: Transfer Money Ekrani Bilgilerinin Kontrolu
    * "Transfer money" butonuna tıklanır
    * "Transfer money" overlayinin açılıp açılmadığı kontrol edilir
    * "Transfer money" texti kontrol edilir
    * "Sender account" texti kontrol edilir
    * "Receiver account" texti kontrol edilir
    * "Testinium-2" elementi kontrol edilir
    * "Amount" texti kontrol edilir
    * "Send" butonu kontrol edilir
    * "EditAccountOverlayCloseIcon" elementi kontrol edilir

  @transferMoney @smoke
  Scenario: Amount Bos Durumda Send Butonunun Disable Oldugunun Kontrolu
    * "Transfer money" butonuna tıklanır
    * "SendButton" elementin disabled olduğu kontrol edilir

    # FAIL alması beklenen senaryo
  @transferMoney @regression
  Scenario: Hesaptan Baska Bir Hesaba Basarılı Sekilde Para Gonderildiginin Kontrolu
    * "Transfer money" butonuna tıklanır
    * "TransferMoneyAmountInput" elementine "200" değeri girilir
    * "SendButton" elementine tıklanır
    * "MyAccountBackNavigationButton" elementi kontrol edilir
    * "FirstTransactionsAmount" alanının değerinin "200" olduğu kontrol edilir

    # FAIL olması beklenen senaryo
  @transferMoney @regression
  Scenario: Amount Alanına Eksi Deger Para Girilemediginin Kontrolu
    * "Transfer money" butonuna tıklanır
    * "TransferMoneyAmountInput" elementine "-200" değeri girilir
    * "SendButton" elementin disabled olduğu kontrol edilir
    * "TransferMoneyAmountInput" alanının değerinin boş olduğu kontrol edilir

  @transferMoney @regression
  Scenario: Amount Alanına Karakter Girilemediginin Kontrolu
    * "Transfer money" butonuna tıklanır
    * "TransferMoneyAmountInput" elementine "b" değeri girilir
    * "TransferMoneyAmountInput" alanının değerinin boş olduğu kontrol edilir

  @transferMoney @regression
  Scenario: Transfer Money Carpı Ikonunun Fonksiyonel Kontrolu
    * "Transfer money" butonuna tıklanır
    * "TransferMoneyOverlayCloseIcon" elementine tıklanır
    * "MyAccountBackNavigationButton" elementi kontrol edilir



    # Add Money Scenarios:

  @addMoney @smoke @regression
  Scenario: Add Money Ekrani Bilgilerinin Kontrolu
    * "Add money" butonuna tıklanır
    * "Add money" overlayinin açılıp açılmadığı kontrol edilir
    * "Add money" texti kontrol edilir
    * "Card number" texti kontrol edilir
    * "Card holder" texti kontrol edilir
    * "Expiry date" texti kontrol edilir
    * "CVV" texti kontrol edilir
    * "Amount" texti kontrol edilir
    * "Add" butonu kontrol edilir
    * "AddMoneyOverlayCloseIcon" elementi kontrol edilir

    # FAIL alması beklenen senaryo
  @addMoney @smoke @regression
  Scenario: Dogru Kart Bilgileriyle Basarılı Sekilde Para Eklenebildiginin Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyCardNumberInput" elementine "1234123412341234" değeri girilir
    * "AddMoneyCardHolderInput" elementine "bartu" değeri girilir
    * "AddMoneyExpiryDateInput" elementine "1026" değeri girilir
    * "AddMoneyCVVInput" elementine "110" değeri girilir
    * "AddMoneyAmountInput" elementine "200" değeri girilir
    * "AddButton" elementine tıklanır
    * "FirstTransactionsAmount" alanının değerinin "200" olduğu kontrol edilir

    # FAIL alması beklenen senaryo
  @addMoney @regression
  Scenario: Yanlıs Kart Bilgileriyle Para Eklenemediginin Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyCardNumberInput" elementine "1234123412341234" değeri girilir
    * "AddMoneyCardHolderInput" elementine "bartu" değeri girilir
    * "AddMoneyExpiryDateInput" elementine "1026" değeri girilir
    * "AddMoneyCVVInput" elementine "110" değeri girilir
    * "AddMoneyAmountInput" elementine "200" değeri girilir
    * "AddButton" elementine tıklanır
    * "AddButton" elementi kontrol edilir

  @addMoney @regression
  Scenario: Kart Bilgilerinin Required Oldugunun Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyCardHolderInput" elementine tıklanır
    * "AddMoneyExpiryDateInput" elementine tıklanır
    * "AddMoneyCVVInput" elementine tıklanır
    * "AddMoneyAmountInput" elementine tıklanır
    * "AddMoneyCardNumberInput" elementine tıklanır
    * "AddMoneyCardHolderRequiredWarning" elementi kontrol edilir
    * "AddMoneyExpiryDateRequiredWarning" elementi kontrol edilir
    * "AddMoneyCVVRequiredWarning" elementi kontrol edilir
    * "AddMoneyAmountRequiredWarning" elementi kontrol edilir
    * "AddMoneyCardNumberRequiredWarning" elementi kontrol edilir


  @addMoney @regression
  Scenario: Kart Bilgileri Doldurulmadan Para Eklenemediginin Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyCardHolderInput" elementine tıklanır
    * "AddMoneyExpiryDateInput" elementine tıklanır
    * "AddMoneyCVVInput" elementine tıklanır
    * "AddMoneyAmountInput" elementine tıklanır
    * "AddMoneyCardNumberInput" elementine tıklanır
    * "AddButton" elementine tıklanır
    * "AddMoneyCardHolderRequiredWarning" elementi kontrol edilir
    * "AddMoneyExpiryDateRequiredWarning" elementi kontrol edilir
    * "AddMoneyCVVRequiredWarning" elementi kontrol edilir
    * "AddMoneyAmountRequiredWarning" elementi kontrol edilir
    * "AddMoneyCardNumberRequiredWarning" elementi kontrol edilir

  @addMoney @regression
  Scenario: Card Number Alanına Karakter Girilemediginin Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyCardNumberInput" elementine "b" değeri girilir
    * "AddMoneyCardNumberInput" alanının değerinin boş olduğu kontrol edilir


    # FAIL alması beklenen senaryo
  @addMoney @regression
  Scenario: Card Holder Alanına Sayi Girilemediginin Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyCardHolderInput" elementine tıklanır
    * "AddMoneyCardNumberInput" elementine tıklanır
    * "AddMoneyCardHolderInput" elementine "1234" değeri girilir
    * "AddMoneyCardHolderInput" alanının değerinin boş olduğu kontrol edilir

    # FAIL alması beklenen senaryo
  @addMoney @regression
  Scenario: Amount Alanına Eksi Deger Para Girilemediginin Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyAmountInput" elementine tıklanır
    * "AddMoneyCardNumberInput" elementine tıklanır
    * "AddMoneyAmountInput" elementine "-100" değeri girilir
    * "AddMoneyAmountInput" alanının değerinin boş olduğu kontrol edilir


    # FAIL alması beklenen senaryo
  @addMoney @regression
  Scenario: Amount Alanına Karakter Girilemediginin Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyAmountInput" elementine "b" değeri girilir
    * "AddMoneyAmountInput" alanının değerinin boş olduğu kontrol edilir

  @addMoney @regression
  Scenario: Add Money Carpı Ikonunun Fonksiyonel Kontrolu
    * "Add money" butonuna tıklanır
    * "AddMoneyOverlayCloseIcon" elementine tıklanır
    * "MyAccountBackNavigationButton" elementi kontrol edilir



    # Edit Account Scenarios:

  @editAccount @smoke @regression
  Scenario: Edit Account Ekrani Bilgilerinin Kontrolu
    * "Edit account" butonuna tıklanır
    * "Edit account" overlayinin açılıp açılmadığı kontrol edilir
    * "Edit account" texti kontrol edilir
    * "Account name" texti kontrol edilir
    * "UPDATE" butonu kontrol edilir
    * "EditAccountOverlayCloseIcon" elementi kontrol edilir

  @editAccount @smoke @regression
  Scenario: Account Name Dogru Oldugunun Kontrolu
    * "Edit account" butonuna tıklanır
    * Edit account alanındaki account name "egebartu" olduğu kontrol edilir

    # Kontrol için zaman yetmedi. Action classının kullanılması gerekiyor.
  @editAccount @regression
  Scenario: Account Name Bos Oldugunda Update Butonunun Disable Oldugunun Kontrolu
    * "Edit account" butonuna tıklanır
    * Edit account alanindaki account name inputu silinir
    * "EditAccountUpdateButton" elementin disabled olduğu kontrol edilir

  @editAccount @regression
  Scenario: Account Name Degistirilebildiginin Kontrolu
    * "Edit account" butonuna tıklanır
    * 2 saniye bekle
    * "EditAccountNameInputValue" elementine "bartu" değeri girilir
    * "EditAccountUpdateButton" elementine tıklanır
    * "Edit account" butonuna tıklanır
    * 2 saniye bekle
    * "EditAccountNameInputValue" elementine "egebartu" değeri girilir
    * "UPDATE" butonuna tıklanır

  @editAccount @regression
  Scenario: Edit Account Carpı Ikonunun Fonksiyonel Kontrolu
    * "Edit account" butonuna tıklanır
    * "EditAccountOverlayCloseIcon" elementine tıklanır
    * "MyAccountBackNavigationButton" elementi kontrol edilir








