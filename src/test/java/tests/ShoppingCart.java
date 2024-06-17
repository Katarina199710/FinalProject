package tests;

import org.testng.annotations.Test;

public class ShoppingCart extends BaseTest {
    @Test
    public void add_item_to_cart_C11() {
        balkaBookMainPage.openMainPage()
                .addItemToCart()
                .checkAddingItem();
    }

    @Test(priority = 1)
    public void delete_item_from_cart_C12() {
        balkaBookMainPage.openMainPage()
                .addItemToCart()
                .openCart()
                .deleteFromCart()
                .checkDeleteFromCart();
    }

    @Test
    public void add_two_items_to_cart_C13() {
        balkaBookMainPage.openMainPage()
                .addItemToCart()
                .openCart()
                .plusItem()
                .closeCart()
                .checkPlusItem();
    }

    @Test
    public void placing_an_order_without_user_data_C14() {
        balkaBookMainPage.openMainPage()
                .addItemToCart()
                .openCart()
                .placeAnOrder()
                .checkInvalidField();
    }
    @Test
    public void add_item_to_wish_list_without_signed_user_C15(){
        balkaBookMainPage.openMainPage()
                .addToWishList();
    }
}
