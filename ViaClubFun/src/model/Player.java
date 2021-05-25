package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class for creating player objects
 *
 * @author Java Gods
 * @version 1.0
 */
public class Player implements Serializable
{
  private String name;
  private int number, benchedInARow;
  private ArrayList<String> positions;
  private ArrayList<Unavailability> unavailabilities;

  /**
   * Two argument constructor for creating a player object
   *
   * @param name   sets the name of the player
   * @param number sets the jersey number of the player
   *               the positions and unavailabilities Array lists are created
   */
  public Player(String name, int number)
  {
    this.name = name;
    this.number = number;
    positions = new ArrayList<String>();
    unavailabilities = new ArrayList<Unavailability>();
  }

  public Player (String name)
  {
    this.name=name;
    this.number=0;
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
        .equals("Suspended"))
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
   * @param unavailability is added the the unavaliabilities array list
   */

  public void addUnavailability(Unavailability unavailability)
  {
    unavailabilities.add(unavailability);
  }

  /**
   * Remove the unavailability from the unavailabilities array list
   * @param unavailability is removed form the unavailabilities array list
   */

  public void removeUnavailability(Unavailability unavailability)
  {
    //add contains
    unavailabilities.remove(unavailability);
  }

  /**
   * Gets the history of the player's unavailabilities
   * @return all unavailability objects from unavailabilites array list
   */
  public ArrayList<Unavailability> getAllUnavailabilities()
  {
    return unavailabilities;
  }

  /**
   *
   * @return
   */

  public ArrayList<String> getPositions()
  {
    return positions;
  }

  public String getPosition(int index)
  {
    return positions.get(index);
  }

  public Player copy()
  {
    Player newPlayer = new Player(name, number);
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

  public String toString()
  {
    String returnStr = "Name: " + name + " Number: " + number + " Positions: ";
    for (int i = 0; i < positions.size(); i++)
    {
      if (i+1!=positions.size())
      {
        returnStr += positions.get(i) + ", ";
      }
      else
      {
        returnStr += positions.get(i);
      }
    }
    return returnStr;
  }

  public int getBenchedInARow()
  {
    return benchedInARow;
  }

  public void setBenchedInARow(int games)
  {
    benchedInARow = games;
  }

  public void incrementBenchedInARow()
  {
    benchedInARow++;
  }

  /*public boolean isAvailable()
  {
    for (int i = 0; i < unavailabilities.size(); i++)
    {
      if (unavailabilities.get(i).isAvailable)
    }
  }

  public boolean isAvailable()
  {
    if (!isSuspended() && !isInjured())
    {
      return true;
   }
    return  false;
  }

   */

}

