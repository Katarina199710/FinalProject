package tests;

import org.testng.annotations.Test;

public class RegistrationPage extends BaseTest{
    @Test
    public void checking_the_appearance_of_the_registration_window_C6() {
        balkaBookMainPage.openMainPage()
                .clickSignInButton()
                .checkAppearanceOfWindow();
    }

    @Test
    public void attempt_to_register_with_invalid_email_C7() {
        balkaBookMainPage.openRegisterPage()
                .insertSurname("doh")
                .insertName("jon")
                .insertEmail("mail12@mail.mail")
                .insertPassword("123345")
                .insertSecondPassword("123345")
                .insertPhoneNumber("123456789")
                .selectCity()
                .insertStreet("jtfjgfjgh")
                .insertHouseNumber("13")
                .clickRegisterButton()
                .checkInvalidField();
    }
    @Test
    public void attempt_to_register_without_entering_the_password_C8(){
        balkaBookMainPage.openRegisterPage()
                .insertSurname("doh")
                .insertName("jon")
                .insertEmail("mail14@mail.com")
                .insertPassword("")
                .insertSecondPassword("")
                .insertPhoneNumber("123456789")
                .selectCity()
                .insertStreet("jtfjgfjgh")
                .insertHouseNumber("13")
                .clickRegisterButton()
                .checkInvalidField();
    }
    @Test
    public void attempt_to_register_with_already_used_mail_C9(){
        balkaBookMainPage.openRegisterPage()
                .insertSurname("doh")
                .insertName("jon")
                .insertEmail("mail12@mail.com")
                .insertPassword("123345")
                .insertSecondPassword("123345")
                .insertPhoneNumber("123456789")
                .selectCity()
                .insertStreet("jtfjgfjgh")
                .insertHouseNumber("13")
                .clickRegisterButton()
                .checkInvalidField();
    }
    @Test
    public void registration_of_a_new_user_with_valid_data_C10(){
        balkaBookMainPage.openRegisterPage()
                .insertSurname("doh")
                .insertName("jon")
                .insertEmail("mail35@mail.com")
                .insertPassword("123345")
                .insertSecondPassword("123345")
                .insertPhoneNumber("123456789")
                .selectCity()
                .insertStreet("jtfjgfjgh")
                .insertHouseNumber("13")
                .clickRegisterButton()
                .checkSuccessfulRegistration()
                .exitFromCabinet();
    }
}
