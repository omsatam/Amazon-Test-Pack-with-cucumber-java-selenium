package Pages;
import base.PageBase;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class HomePage extends PageBase {
    private final By greetingSelector = By.id("glow-ingress-line1");
    private final By addressSelector = By.id("glow-ingress-line2");
    private final By greetingsSelector = By.id("nav-link-accountList-nav-line-1");
    protected String AmazonURL = getProerties().getProperty("AmazonURL");
    protected String addressEnglish = new String("Select your address");
    private final By languageSelector = By.id("icp-nav-flyout");
    protected String greetingEnglish = new String("Hello");
    protected String greetingHindi = new String("नमस्ते");
    protected String addressHindi = new String("अपना पता चुनें");
    protected String greetingTamil = new String("வணக்கம்");
    protected String addressTamil = new String("உங்கள் முகவரியைத் தேர்ந்தெடுக்கவும்");
    protected String greetingTelgu = new String("హలో");
    protected String addressTelgu = new String("మీ అడ్రస్ ఎంచుకోండి");
    protected String greetingKannada = new String("ನಮಸ್ಕಾರ");
    protected String addressKannada = new String("ನಿಮ್ಮ ವಿಳಾಸವನ್ನು ಆರಿಸಿ");
    protected String greetingMalayalam = new String("ഹലോ");
    protected String addressMalayalam = new String("വിലാസം തിരഞ്ഞെടുക്കൂ");
    protected String greetingBangla = new String("নমস্কার");
    protected String addressBangla = new String("আপনার ঠিকানা বাছুন");
    protected String greetingMarathi = new String("नमस्कार");
    protected String addressMarathi = new String("तुमचा पत्ता निवडा");
    protected String hindiLanguage = new String("हिन्दी");
    protected String MarathiLanguage = new String("मराठी");
    protected String TamilLanguage = new String("தமிழ்");
    protected String TelguLanguage = new String("తెలుగు");
    protected String KannadaLanguage = new String("ಕನ್ನಡ");
    protected String BanglaLanguage = new String("বাংলা");
    protected String MalayalamLanguage = new String("മലയാളം");
    protected String greetingsUnauthorised = new String("Hello, sign in");

    public HomePage(TestBase testBase) throws IOException {
        super(testBase);
        testBase.getProperties();
    }
    public void goToApplication() throws IOException {
        navigateTo(AmazonURL);
    }
    public void changeDefaultLanguageTo(String language){
        mouseOverToElement(languageSelector);
        waitUntilElementVisible(By.partialLinkText(hindiLanguage));
        if(language.contains("Hindi")) {
            clickElementByText(hindiLanguage);
        } else if (language.contains("Kannada")) {
            clickElementByText(KannadaLanguage);
        }else if (language.contains("Telgu")) {
            clickElementByText(TelguLanguage);
        }else if (language.contains("Tamil")) {
            clickElementByText(TamilLanguage);
        }else if (language.contains("Bangla")) {
           clickElementByText(BanglaLanguage);
        }else if (language.contains("Marathi")) {
            clickElementByText(MarathiLanguage);
        }else if (language.contains("Malayalam")) {
            clickElementByText(MalayalamLanguage);
        }
    }
    public void verifyDefaultLangusge(String language){
        isTextVisible(greetingSelector,greetingEnglish);
        isTextVisible(addressSelector,addressEnglish);
    }
    public void verifytChangedLanguage(String language){
//        waitUntilElementVisible(greetingsSelector);
//        waitUntilElementVisible(addressSelector);
        if(language.contains("Hindi")) {
            waitUntilElementTextVisible(greetingsSelector,greetingHindi);
            waitUntilElementTextVisible(addressSelector,addressHindi);
            isTextVisible(greetingSelector, greetingHindi);
            isTextVisible(addressSelector, addressHindi);
        } else if (language.contains("Kannada")) {
            waitUntilElementTextVisible(greetingsSelector,greetingKannada);
            waitUntilElementTextVisible(addressSelector,addressKannada);
            isTextVisible(greetingSelector, greetingKannada);
            isTextVisible(addressSelector, addressKannada);
        }else if (language.contains("Telgu")) {
            waitUntilElementTextVisible(greetingsSelector,greetingTelgu);
            waitUntilElementTextVisible(addressSelector,addressTelgu);
            isTextVisible(greetingSelector, greetingTelgu);
            isTextVisible(addressSelector, addressTelgu);
        }else if (language.contains("Tamil")) {
            waitUntilElementTextVisible(greetingsSelector,greetingTamil);
            waitUntilElementTextVisible(addressSelector,addressTamil);
            isTextVisible(greetingSelector, greetingTamil);
            isTextVisible(addressSelector, addressTamil);
        }else if (language.contains("Bangla")) {
            waitUntilElementTextVisible(greetingsSelector,greetingBangla);
            waitUntilElementTextVisible(addressSelector,addressBangla);
            isTextVisible(greetingSelector, greetingBangla);
            isTextVisible(addressSelector, addressBangla);
        }else if (language.contains("Marathi")) {
            waitUntilElementTextVisible(greetingsSelector,greetingMarathi);
            waitUntilElementTextVisible(addressSelector,addressMarathi);
            isTextVisible(greetingSelector, greetingMarathi);
            isTextVisible(addressSelector, addressMarathi);
        }else if (language.contains("Malayalam")) {
            waitUntilElementTextVisible(greetingsSelector,greetingMalayalam);
            waitUntilElementTextVisible(addressSelector,addressMalayalam);
            isTextVisible(greetingSelector, greetingMalayalam);
            isTextVisible(addressSelector, addressMalayalam);
        }
    }
    public void verifyUserNameforAuthorisedUser(String Username){
        isTextVisible(greetingsSelector, "Hello, "+ Username);
    }
    public void verifyUserNameforUnauthorisedUser(){
        isTextVisible(greetingsSelector, greetingsUnauthorised);
    }
}
