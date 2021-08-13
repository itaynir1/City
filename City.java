/**
 * city class - this class will generates city objects with a name, and a center point
 * central station point, adjustable count of the residents and number of neighborhoods.
 * notice - this class based on a point class.
 * @author Itay Nir
 */

public class City
{
    private String _cityName;
    private Point _cityCenter , _centralStation;
    private long _numOfResidents;
    private int _noOfNeighborhoods;

    final long MIN_RESIDENTS = 0;
    final int MIN_NEIGHBORHOODS = 1;
    final double X_ORIGIN = 0, Y_ORIGIN = 0;

    //custom City object constructor

    /**
     * Constructor for objects of class City.
     * Construct a new city with the specified info.
     * If numOfResidents is smaller than MIN_RESIDENTS, MIN_RESIDENTS is used.
     * If noOfNeighborhoods is smaller than MIN_NEIGBORHOODS, MIN_NEIGBORHOODS is used.
     * If any coordinate is negative - 0 is used instead.
     * @param cityName The name of the city
     * @param cityCenterX The X coordinate of the center point of the city
     * @param cityCenterY The Y coordinate of the center point of the city
     * @param centralStationX The X coordinate of the central station of the city
     * @param centralStationY The Y coordinate of the central station of the city
     * @param numOfResidents The number of residents in the city
     * @param noOfNeighborhoods The number of neighborhoods in the city
     */
    public City(String cityName, double cityCenterX, double cityCenterY ,double centralStationX , double centralStationY, long numOfResidents, int noOfNeighborhoods )
    {
        _cityName = cityName;
        _cityCenter = new Point(cityCenterX,cityCenterY);
        _centralStation = new Point(centralStationX,centralStationY);
        if(numOfResidents >= MIN_RESIDENTS)
            _numOfResidents = numOfResidents;
        else _numOfResidents=MIN_RESIDENTS;
        if(noOfNeighborhoods>=MIN_NEIGHBORHOODS)
            _noOfNeighborhoods = noOfNeighborhoods;
        else _noOfNeighborhoods = MIN_NEIGHBORHOODS;
    }

    //City object copy constructor.

    /**
     * Constructor for objects of class City.
     * Copy constructor, construct a city using another city.
     * @param other The city from which to construct the new object
     */
    public City(City other)
    {
        _cityName = other._cityName;
        new Point(_cityCenter = other._cityCenter);
        new Point(_centralStation = other._centralStation);
        _numOfResidents = other._numOfResidents;
        _noOfNeighborhoods = other._noOfNeighborhoods;
    }

    //getters and setters.

    /**
     * Returns the name of the city.
     * @return The name of the city
     */
    public String getCityName()
    {
        return _cityName;
    }

    /**
     * Returns the center of the city as a Point object.
     * @return The center point of the city
     */
    public Point getCityCenter()
    {
        return new Point(_cityCenter);
    }

    /**
     * Returns the centeral station of the city as a Point object.
     * @return The central station of the city
     */
    public Point getCentralStation()
    {
        return new Point(_centralStation);
    }

    /**
     * Returns the number of residents of the city.
     * @return The number of residents of the city
     */
    public long getNumOfResidents()
    {
        return _numOfResidents;
    }

    /**
     * Returns the number of neighborhoods of the city.
     * @return The number of neighborhoods of the city
     */
    public int getNoOfNeighborhoods()
    {
        return _noOfNeighborhoods;
    }

    /**
     * Sets the name of the city.
     * @param cityName The new name of the city
     */
    public void setCityName(String cityName) { _cityName = cityName; }

    /**
     * Sets the center point of the city.
     * @param cityCenter The new center point of the city
     */
    public void setCityCenter(Point cityCenter)
    {
        _cityCenter = new Point(cityCenter);
    }

    /**
     * Sets the central station point of the city.
     * @param centralStation The new central station point of the city
     */
    public void setCentralStation(Point centralStation)
    {
        _centralStation = new Point(centralStation);
    }

    /**
     * Sets the number of residents of the city,
     * but only if it is bigger or equal to MIN_RESIDENTS.
     * @param numOfResidents The new number of residents in the city
     */
    public void setNumOfResidents(long numOfResidents)
    {
        if(numOfResidents>=MIN_RESIDENTS)
            _numOfResidents = numOfResidents;
    }

    /**
     * Sets the number of neighborhoods of the city,
     * but only if it is bigger or equal to MIN_NEIGBORHOODS.
     * @param noOfNeighborhoods The new number of neighborhoods in the city
     */
    public void setNoOfNeighborhoods(int noOfNeighborhoods)
    {
        if(_noOfNeighborhoods + noOfNeighborhoods >= MIN_NEIGHBORHOODS)
            _noOfNeighborhoods = noOfNeighborhoods;
    }

    //methods:

    /**
     *Adds the given number of residents - either positive or negative number - to the city.
     * If the resulted number of residents is smaller than MIN_RESIDENTS, MIN_RESIDENTS
     * is set to be the new number of residents of the city, and false is returned.
     * Otherwise (i.e. the resulted number is bigger or equal to MIN_RESIDENTS), true is retu   rned.
     * @param residentsUpdate The wished number for update to the original resident count
     * @return false if resulted number of residents is smaller than MIN_RESIDENTS, true otherwise
     */
    public boolean addResidents(long residentsUpdate)
    {
        _numOfResidents += residentsUpdate;
        if(_numOfResidents >=MIN_RESIDENTS)
            return true;
        else {
            _numOfResidents = MIN_RESIDENTS;
            return  false;
        }
    }

    /**
     * Move the location of the central station of the city with the given deltas.
     * If the new location has a negative coordinate - the central station keeps its original location.
     * @param deltaX  How much the x coordinate of the central station of the city is to be moved
     * @param deltaY How much the y coordinate of the central station of the city is to be moved
     */
    public void moveCentralStation(double deltaX,double deltaY)
    {
        Point newCentralStation = new Point(_centralStation);
        newCentralStation.move(deltaX,deltaY);
        setCentralStation(newCentralStation);
    }

    /**
     * Calculates the distance between the center of this city and its central station.
     * @return The distance between the center of this city and its central station
     */
    public double distanceBetweenCenterAndStation()
    {
        return  this._cityCenter.distance(_centralStation);

    }

    /**
     * Creates a new city with a new name, and where its center and
     * central station are moved by the given deltas from this city.
     * If either new point has negative coordinates - it gets the center
     * or central station of this city.
     * Its number of residents is set to MIN_RESIDENTS and its number of
     * neightborhoods is set to MIN_NEIGBORHOODS.
     * @param newCityName The name of the new city
     * @param dX How much the x coordinates of the city's center and central station are to be moved for the new city
     * @param dY How much the y coordinates of the city's center and central station are to be moved for the new city
     * @return A new city with the given values
     */
    public City newCity(String newCityName,double dX,double dY)
    {

        Point _newCityCenter = new Point(_cityCenter);
        Point _newCentralStation = new Point(_centralStation);

        _newCityCenter.move(dX,dY);
        _newCentralStation.move(dX,dY);

        City newCityTablet = new City(newCityName,_newCityCenter.getX(),_newCityCenter.getY(),_newCentralStation.getX(),_newCentralStation.getY(),MIN_RESIDENTS,MIN_NEIGHBORHOODS);


        return newCityTablet;
    }


    /**
     * Returns a string representation of this City in the format
     * City Name: Tel Aviv
     * City Center: (5.0,8.0)
     * Central Station: (3.0,4.0)
     * Number of Residents: 1004
     * Number of Neighborhoods: 5
     * @return A String representation of this city
     */
    public String toString()
    {
        return "City Name: " + getCityName() + "\n" +
                "City Center: " + getCityCenter() + "\n" +
                "Central Station: " + getCentralStation() + "\n" +
                "Number Of Residents: " + getNumOfResidents() + "\n" +
                "Number Of Neighborhoods: " + getNoOfNeighborhoods() ;
    }
}
