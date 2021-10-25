//referenced from class lecture
import java.util.Random;
	public class Dice {
		Random rand = new Random();
		private final int numFaces; 
		private int faceValue; 
		
		public Dice(int _numFaces) 
		{
		numFaces = _numFaces;
		roll();
		}
		
		public void roll() 
		{
		int curr_faceValue = 1 + rand.nextInt(numFaces);
		setFaceValue(curr_faceValue);
		}
		
		private void setFaceValue (int value)
		{
		if (value <= numFaces)
		faceValue = value;
		}


		public int getFaceValue() {
		return faceValue;
		}

		
		public int getNumFaces() {
		return numFaces;
		}

		
		} // End of Dice class

