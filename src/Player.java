import java.util.ArrayList;

/**
 * A class for creating player objects
 *
 * @author Java Gods
 * @version 1.0
 */
public class Player
{
  private String name;
  private int number, benchedInARow;
  private ArrayList<String> positions;
  private ArrayList<Unavailability> unavailabilities;

  /**
   * Two argument constructor for creating a player object
   *
   * @param name      sets the name of the player
   * @param number    sets the jersey number of the player
   * @param positions sets the positions array list to the player
   *                  the positions and unavailabilities Array lists are created
   */
  public Player(String name, int number, ArrayList<String> positions)
  {
    this.name = name;
    this.number = number;
    this.positions = positions;
    positions = new ArrayList<String>();
    unavailabilities = new ArrayList<Unavailability>();
  }

  /**
   * Returns the name of the player
   *
   * @return the name of the player
   */
  public String getName()
  {
    return name;
  }

  /**
   * Returns the jersey number of the player
   *
   * @return the jersey number of the player
   */

  public int getNumber()
  {
    return number;
  }

  /**
   * sets the jersey number of the player
   *
   * @param number sets the jersey number of the player
   */

  public void setNumber(int number)
  {
    this.number = number;
  }

  /**
   * adds a position the positions array list
   *
   * @param position the position added to the array list
   */

  public void addPosition(String position)
  {
    positions.add(position);
  }

  /**
   * removes the position from the positions array list
   *
   * @param position the position that is removed
   */

  public void removePosition(String position)
  {
    if (positions.contains(position))
    {
      positions.remove(position);
    }
  }

  /**
   * Checks if the player is currently suspended
   *
   * @return true if the player's last suspension type is "Suspended" and date is not before today's date. False otherwise
   */
  public boolean isSuspended()
  {
    //add today date
    if (unavailabilities.get((unavailabilities.size() - 1)).getType()
        .equals("Suspended") && !(unavailabilities
        .get((unavailabilities.size() - 1)).getEnd().isBefore(Date.today())))
    {

      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   * adds a unavailability to the unavailabilities array list
   *
   * @param unavailability is added the the unavaliabilities array list
   */

  public void addUnavailability(Unavailability unavailability)
  {
    unavailabilities.add(unavailability);
  }

  /**
   * Remove the unavailability from the unavailabilities array list
   *
   * @param unavailability is removed form the unavailabilities array list
   */

  public void removeUnavailability(Unavailability unavailability)
  {
    //add contains
    unavailabilities.remove(unavailability);
  }

  /**
   * Gets the history of the player's unavailabilities
   *
   * @return all unavailability objects from unavailabilites array list
   */
  public ArrayList<Unavailability> getAllUnavailabilities()
  {
    return unavailabilities;
  }

  /**
   * gets all player's positions
   *
   * @return the positions in positions array list
   */

  public ArrayList<String> getPositions()
  {
    return positions;
  }

  /**
   * gets the position at a specific index
   *
   * @param index the index of the position
   * @return the position at the specified index
   */
  public String getPosition(int index)
  {
    return positions.get(index);
  }

  /**
   * Copies and returns a player object
   *
   * @return the copy of the player object
   */
  public Player copy()
  {
    Player newPlayer = new Player(name, number, positions);
    for (int i = 0; i < positions.size(); i++)
    {
      newPlayer.addPosition(positions.get(i));
    }
    for (int i = 0; i < unavailabilities.size(); i++)
    {
      newPlayer.addUnavailability(unavailabilities.get(i));
    }
    return newPlayer;
  }

  /**
   * Compares this Player to the specified object.
   * The result is true if and only if the argument is not null and
   * is a Player object that represents the same parameters as this object.
   *
   * @param obj The object to compare this Player against.
   * @return true if the given object represents a Player equivalent to this player, false otherwise.
   */

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Player))
    {
      return false;
    }
    else
    {
      Player other = (Player) obj;
      return name.equals(other.name) && number == other.number && positions
          .equals(other.positions) && unavailabilities
          .equals(other.unavailabilities);
    }
  }

  /**
   * prints out then name, the number, the positions and the history of unavailabilities of the player
   *
   * @return then name, the number, the positions and the history of unavailabilities of the player
   */
  public String toString()
  {
    return "name: " + name + " number: " + number + " positions: " + positions
        + "unavailabilities:" + unavailabilities;
  }

  /**
   * gets the number of games the player has been benched in a row
   *
   * @return the number of games the player has been benched in a row
   */
  public int getBenchedInARow()
  {
    return benchedInARow;
  }

  /**
   * sets the number of games the player has been benched in a row
   *
   * @param games number of games the player has been benched in a row
   */
  public void setBenchedInARow(int games)
  {
    benchedInARow = games;
  }

  /**
   * Adds one to the number of games benched in a row
   */
  public void incrementBenchedInARow()
  {
    benchedInARow++;
  }

}
