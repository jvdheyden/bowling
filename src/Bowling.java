import java.util.*;

public class Bowling
{
	private List<Frame> _frameList;
	private List<String> _players;

	public Bowling(List<String> players)
	{
		_frameList = new ArrayList<Frame>();
		_players = players;
	}

	public static Bowling startGame(List<String> players)
	{
		return new Bowling(players);
	}

	public boolean isGameFinished()
	{
	}

	public Set<String> winners()
	{
	}

	public int score(String player)
	{
		int sum = 0;

		for (Frame f : _frameList)
		{
			if (f.getPlayer().equals(player))
			{
				sum = sum + f.getScore();
			}
		}
		return sum;
	}

	public int frameScore(String player, int frame)
	{
		int score = -1;
		for (Frame f: _frameList)
		{
			if ((f.getPlayer() == player) && (f.getFrameNumber() == frame))
			{
				score = f.getScore();
				break;
			}
		}
		return score;
	}

	public String playsNext()
	{
	}

	public void roll(int droppedPins)
	{
	}

}
