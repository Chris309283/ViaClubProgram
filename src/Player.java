import java.util.ArrayList;

public class Player
{
  private String name;
  private int number, benchedInARow;
  private ArrayList<String> positions;
  private ArrayList<Unavailability> unavailabilities;

  public Player(String name, int number)
  {
    this.name = name;
    this.number = number;
    positions = new ArrayList<String>();
    unavailabilities = new ArrayList<Unavailability>();
  }

  public String getName()
  {
    return name;
  }

  public int getNumber()
  {
    return number;
  }

  public void setNumber(int number)
  {
    this.number = number;
  }

  public void addPosition(String position)
  {
    positions.add(position);
  }

  public void removePosition(String position)
  {
    if (positions.contains(position))
    {
      positions.remove(position);
    }
  }

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

  public void addUnavailability(Unavailability unavailability)
  {
    unavailabilities.add(unavailability);
  }

  public void removeUnavailability(Unavailability unavailability)
  {
    //add contains
    unavailabilities.remove(unavailability);
  }

  public ArrayList<Unavailability> getAllUnavailabilities()
  {
    return unavailabilities;
  }

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
    return "name: " + name + " number: " + number + " positions: " + positions;
  }
  public int getBenchedInARow(){
    return benchedInARow;
  }
  public void setBenchedInARow(int games){
    benchedInARow=games;
  }
  public void incrementBenchedInARow(){
    benchedInARow++;
  }

}
