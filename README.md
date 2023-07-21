# City Class Project

## Introduction
The `City` class is a Java-based implementation that represents a city with various attributes such as its name, center point, central station point, number of residents, and number of neighborhoods. 

This class is designed to create and manage City objects with different properties.

The `City` class is based on a `Point` class, which provides functionality for handling coordinates.

## Class Description
### Class Properties
- `String _cityName` : Stores the name of the city.
- `Point _cityCenter` : Represents the center point of the city.
- `Point _centralStation`: Represents the central station point of the city.
- `long _numOfResidents` : Stores the number of residents in the city.
- `int _noOfNeighborhoods` : Stores the number of neighborhoods in the city.
- `final long MIN_RESIDENTS` : A constant that represents the minimum value for the number of residents.
- `final int MIN_NEIGHBORHOODS` : A constant that represents the minimum value for the number of neighborhoods.
- `final double X_ORIGIN = 0, Y_ORIGIN = 0` : Constants representing the origin coordinates (0,0).

### Class Constructors
1. `City(String cityName, double cityCenterX, double cityCenterY, double centralStationX, double centralStationY, long numOfResidents, int noOfNeighborhoods)` : Custom constructor that initializes a new City object with the specified attributes. If any coordinate value is negative, it is set to 0. If the number of residents or neighborhoods is smaller than their respective minimum values, they are set to their minimum values.

2. `City(City other)` : Copy constructor that creates a new City object by copying the attributes of another City object.

### Class Methods
The `City` class provides the following methods to interact with and manipulate City objects:

- `String getCityName()` : Returns the name of the city.
- `Point getCityCenter()` : Returns the center point of the city as a new Point object.
- `Point getCentralStation()` : Returns the central station point of the city as a new Point object.
- `long getNumOfResidents()` : Returns the number of residents in the city.
- `int getNoOfNeighborhoods()` : Returns the number of neighborhoods in the city.
- `void setCityName(String cityName)` : Sets the name of the city.
- `void setCityCenter(Point cityCenter)` : Sets the center point of the city.
- `void setCentralStation(Point centralStation)` : Sets the central station point of the city.

- `void setNumOfResidents(long numOfResidents)` : Sets the number of residents in the city, but only if it is bigger or equal to MIN_RESIDENTS.

- `void setNoOfNeighborhoods(int noOfNeighborhoods)` : Sets the number of neighborhoods in the city, but only if it is bigger or equal to MIN_NEIGHBORHOODS.

- `boolean addResidents(long residentsUpdate)` : Adds the given number of residents (can be positive or negative) to the city. If the resulting number of residents is smaller than `MIN_RESIDENTS`, `MIN_RESIDENTS` is set to be the new number of residents of the city, and false is returned. Otherwise (i.e., the resulting number is bigger or equal to `MIN_RESIDENTS`), true is returned.
- `void moveCentralStation(double deltaX, double deltaY)` : Moves the location of the central station of the city by the given deltas. If the new location has a negative coordinate, the central station keeps its original location.
- `double distanceBetweenCenterAndStation()` : Calculates the distance between the center of the city and its central station.
- `City newCity(String newCityName, double dX, double dY)` : Creates a new city with a new name and where its center and central station are moved by the given deltas from this city. If either new point has negative coordinates, it gets the center or central station of this city. The new city's number of residents is set to `MIN_RESIDENTS`, and its number of neighborhoods is set to `MIN_NEIGHBORHOODS`.
- `String toString()` : Returns a string representation of this City in a specified format.

## How to Use
1. Create a new `City` object using the custom constructor by providing a name, center point coordinates, central station coordinates, number of residents, and number of neighborhoods.

2. Access and modify the city's properties using the provided getters and setters.

3. Perform city-specific operations such as adding or moving residents, calculating distances, and creating new cities with adjusted coordinates.

4. Obtain a string representation of the city's attributes using the `toString()` method.

### Examples
**Here are some examples of how to use the City class:**
```java
// Create a new city object
City myCity = new City("New York", 10.0, 15.0, 12.0, 18.0, 1000000, 20);

// Get the name of the city
String cityName = myCity.getCityName(); // Returns "New York"

// Move the central station of the city
myCity.moveCentralStation(2.0, -3.0);

// Add residents to the city
myCity.addResidents(50000);

// Create a new city with adjusted coordinates
City newCity = myCity.newCity("Brooklyn", 5.0, 5.0);

// Get a string representation of the city
String cityInfo = myCity.toString();
System.out.println(cityInfo);
// Output:
// City Name: New York
// City Center: (10.0,15.0)
// Central Station: (14.0,15.0)
// Number Of Residents: 1050000
// Number Of Neighborhoods: 20
```
## Conclusion
The `City` class provides a convenient and efficient way to manage and manipulate city objects with various attributes. By using the provided methods, users can easily create, modify, and obtain information about cities. Feel free to utilize the City class to model and work with different cities in your projects!
