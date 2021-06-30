import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE

    @BeforeEach
    public void setup(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
//        Restaurant restaurant = Mockito.mock(Restaurant.class);
//        LocalTime currentTime = LocalTime.parse("12:00:00");
//        Mockito.when(restaurant.getCurrentTime()).thenReturn(currentTime);
        assertTrue(restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        Restaurant restaurant = Mockito.mock(Restaurant.class);
        LocalTime currentTime = LocalTime.parse("23:00:00");
        Mockito.when(restaurant.getCurrentTime()).thenReturn(currentTime);
        assertFalse(restaurant.isRestaurantOpen());

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //TDD

    //Display the number of items
    //selected item should have name price with total price.
    //On removing the price must be subtracted.
    //show the total price once selected all.
    //The item should be available in the menu card

    @Test
    public void when_adding_items_it_should_calculate_total_price(){

        restaurant.addToMenu("Biryani", 1000);
        restaurant.addToMenu("Butter Chicken", 300);
        ArrayList<String> bag = new ArrayList<String>();
        bag.add("Biryani");
        bag.add("Butter Chicken");
        assertNotNull(restaurant);
        assertEquals("Your order will cost ₹1300", restaurant.returnTotalPrice(bag));
        bag.remove("Butter Chicken");
        assertEquals("Your order will cost ₹1000", restaurant.returnTotalPrice(bag));
    }
}