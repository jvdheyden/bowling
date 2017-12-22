import java.util.*;

public class Bowling
{
	private List<Frame> _frameList;
	private List<String> _players;
	
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		list.add("jonas");
		list.add("constantin");
		list.add("matthias");
		Bowling game = startGame(list);
		System.out.println(game.score("jonas"));
	}

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
		return _frameList.size() == 10*_players.size();
	}

	public Set<String> winners()
	{
		Set<String> winners = new TreeSet<String>();
		
		int high_score = -1;
		for (String s : _players)
		{
			if (score(s) == high_score)
			{
				winners.add(s);
			} else if (score(s) > high_score)
			{
				winners.clear();
				winners.add(s);
				high_score = score(s);
			}
		}
		
		return winners;
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
		return _players.get(_frameList.size() % _players.size());
	}

	public void roll(int droppedPins)
	{
		Frame currentFrame = null;
		Frame newFrame;
		String currentPlayer = playsNext();
		int round = (int) Math.ceil(((double) _frameList.size()) / _players.size());
		for(Frame f : _frameList)
		{
			if (f.getPlayer() == currentPlayer && f.getFrameNumber() == _frameList.size())
			{
				currentFrame = f;
				f.addScore(droppedPins);
				break;
			}
		}
		if (currentFrame == null)
		{
			newFrame = new Frame(currentPlayer, round, new ArrayList<Integer>(droppedPins));
			_frameList.add(newFrame);
		}
	}

}
