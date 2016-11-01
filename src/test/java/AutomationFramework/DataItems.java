package AutomationFramework;

public class DataItems {

    public static String targetURL =" https://prod.ecarrefour.ro/";
    public static String validUsername = "test01@de.de";
    public static String changedUsername = "test02@de.de";
    public static String validPassword = "Tremend10ani";
    public static String changedPassword = "Tremend11ani";


    // -------------- Notification messages
    public static String wrongLoginMsg = "ceva nu a fost introdus bine..mai incearca o data";
    public static String correctLoginMsg = "bine ai venit!";
    public static String correctLogoutMsg = "ai iesit din cont";
    public static String userUpdateMsg = "Utilizator actualizat";
    public static String addNewShippingAddressMsg = "ai salvat o noua adresa";
    public static String shippingAddressUpdateMsg = "adresa a fost actualizata";
    public static String deleteShippingAddressMsg = "adresa a fost stearsa";
    public static String addNewInvoiceMsg = "datele de facturare au fost salvate";
    public static String updateInvoiceMsg = "";
    public static String deleteInvoiceMsg = "datele de facturare au fost sterse";

    // -------------- Type of notification
    public static String login = "Login";
    public static String logout = "Logout";
    public static String warning = "Warning";
    public static String addProfile = "ProfileAdd";
    public static String updateProfile = "ProfileUp";
    public static String addShppingAddress = "ShippingAdd";
    public static String updateShppingAddress = "ShippingUp";
    public static String deleteShippingAddress = "ShippingDel";
    public static String addInvoice = "InvoiceAdd";
    public static String updateInvoice = "InvoiceUp";
    public static String deleteInvoice = "InvoiceDel";


    // -------------- Field Labels
    // --- Login
    public static String loginFormTabAndTitle[] = {"LoginFormTab ","LoginFormTitle", "intru in cont"};
    public static String loginEmail[] = {"LoginEmail", "e-mail"};
    public static String loginPassword[] = {"LoginPassword", "parola"};
    // --- New Account
    public static String newAccFormTabAndTitle[] = {"NewAccFormTab", "NewAccFormTitle", "imi fac cont"};
    public static String firstName[] = {"FirstName", "prenume"};
    public static String lastName[] = {"LastName", "nume"};
    public static String newAccEmail[] = {"NewAccEmail", "e-mail"};
    public static String phoneNumber[] = {"PhoneNumber", "telefon"};
    public static String newAccPassword[] = {"NewAccPassword", "parola"};
    public static String newAccConfirmPassword[] = {"NewAccConfirmPassword", "confirm parola"};


    // -------------- Empty field, messages after save
    public static String blankFieldMsgForProfile = "Această valoare nu ar trebui să fie goală.";
    public static String blankFieldMsgForShipping = "Aceasta valoare trebuie completata";
    public static String emptyZip = "Cod postal invalid";


    // -------------- MyProfileData
    public static String myProfileData01[] = {"testNume01", "testPrenume01", "test01@de.de", "0754317885"};
    public static String myProfileData02[] = {"testNume02", "testPrenume02", "test02@de.de", "0754317886"};

    // -------------- ShippingAddressData
    public static String shippingAddressData01[] = {"testAddressName01", "testStreetName01", "testStreetNo01", "testBuilding01", "testBuildingDoor01", "testFloor01", "testApartment01", "testIntercom01", "060541", "testDistrict01", "Bucuresti Sector 6"};
    public static String shippingAddressData02[] = {"testAddressName02", "testStreetName02", "testStreetNo02", "testBuilding02", "testBuildingDoor02", "testFloor02", "testApartment02", "testIntercom02", "060543", "testDistrict02", "Bucuresti Sector 6"};
    public static String userDataShippingAdress01[] = {"testFirstname01", "testLastName01", "testPhone01"};
    public static String userDataShippingAdress02[] = {"testFirstname02", "testLastName02", "testPhone02"};

    // -------------- InvoiceData
    public static String invoiceDataForIndividual01[] = {"testInvoiceName01", "testAddress01", "testPerson01"};
    public static String invoiceDataForIndividual02[] = {"testInvoiceName02", "testAddress02", "testPerson02"};
    public static String invoiceDataForLegalEntity01[] = {"testInvoiceName01", "testFirmName01", "testFiscalCode01", "testFirmAddress01", "testPerson01"};
    public static String invoiceDataForLegalEntity02[] = {"testInvoiceName02", "testFirmName02", "testFiscalCode02", "testFirmAddress02", "testPerson02"};


    // -------------- Get Attribute
    public static String placeholder = "placeholder";
    public static String value = "value";


    // -------------- Waiting Time
    public static int shortWait = 10;
    public static int longWait = 20;




}