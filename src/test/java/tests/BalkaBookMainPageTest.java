package tests;

import org.testng.annotations.Test;

public class BalkaBookMainPageTest extends BaseTest {
    @Test(priority = 2)
    public void check_of_the_search_string_C1(){
        balkaBookMainPage.openMainPage()
                .insertValueToSearchField("вініл")
                .checkResultOfSearchPositive("Найдено 54 результатa");
    }

    @Test(priority = 1)
    public void a_checking_dropdown_list_functionality_C2() {
        balkaBookMainPage.openMainPage()
                .chooseOptionFromCatalog()
                .chooseSubOption();
    }

    @Test
    public void checking_the_functionality_of_the_advertising_slider_button_C3() {
        balkaBookMainPage.openMainPage()
                .checkTheAdvertisingSlider(5);
    }

    @Test
    public void check_of_the_search_string_negative_C4() {
        balkaBookMainPage.openMainPage()
                .insertValueToSearchField("vinil")
                .checkResultOfSearchNegative("Товары, доступные к продаже, не найдены!");
    }

    @Test
    public void change_of_localization_C5() {
        balkaBookMainPage.openMainPage()
                .changeLocalizationToRU()
                .checkOFChangeOFLocalization("Вопросы/ответы")
                .changeLocalizationToUA();
    }

}
