import java.util.List;

public class Frame
{

	private String _player;
	private int _frameNumber;
	private List<Integer> _scores;

	public Frame(String player, int frameNumber, List<Integer> scores)
	{
		_player = player;
		_frameNumber = frameNumber;
		_scores = scores;
	}

	public String getPlayer()
	{
		return _player;
	}

	public int getFrameNumber()
	{
		return _frameNumber;
	}

	public int getScore()
	{
		int sum = 0;
		for (int i : _scores)
		{
			sum = sum + i;
		}
		return sum;
	}
	
	public void addScore(int droppedPins)
	{
		_scores.add(droppedPins);
	}

}
