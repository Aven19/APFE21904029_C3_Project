# Restaurant Finder

Restaurant Finder is a backend service for managing restaurant details, menus, and user interactions. This project provides core functionalities for customers to search for restaurants, view menus, and check restaurant availability.

## Features

- **Restaurant Management:** Stores restaurant details, including opening and closing times.
- **Menu Management:** Provides a list of items available at each restaurant.
- **Restaurant Search:** Allows customers to find restaurants by name.
- **Operating Hours Check:** Determines whether a restaurant is currently open.

## Project Structure

- `RestaurantService.java` - Service class handling restaurant-related operations.
- `Restaurant.java` - Model class representing a restaurant with its details.
- `Item.java` - Model class representing individual menu items.
- `RestaurantServiceTest.java` - Unit tests for `RestaurantService`.
- `RestaurantTest.java` - Unit tests for `Restaurant`.

## Implementation Details

### `Restaurant.java`
- `getMenu()`: Returns the list of menu items available at the restaurant.
- `isRestaurantOpen()`: Checks whether the restaurant is currently open based on the system time.

### `RestaurantService.java`
- `findRestaurantByName(String name)`: Searches and returns a restaurant matching the given name. Throws an exception if the restaurant is not found.

## Testing
The project includes unit tests to validate the functionality of the service and model classes:

### `RestaurantServiceTest.java`
- `searching_for_existing_restaurant_should_return_expected_restaurant_object()`
- `searching_for_non_existing_restaurant_should_throw_exception()`

### `RestaurantTest.java`
- `Is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time()`
- `Is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time()`

## Refactoring
After implementing the required features and test cases, redundant code has been refactored to improve maintainability and readability.

## Setup and Running Tests
1. Clone the repository.
2. Ensure you have Java and a testing framework (JUnit) installed.
3. Run the test cases to validate the implementation.

```sh
mvn test
```

## Contribution
Feel free to contribute by reporting issues or submitting pull requests to improve the project further.

## License
This project is licensed under the MIT License.

