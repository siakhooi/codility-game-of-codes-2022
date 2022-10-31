package nsh.codility;

public class GameOfCodes2022C1 implements GameOfCodes2022Interface {

	public int solution(String S) {
		int N = S.length();
		int blockCount = 0;
		int blockSize[] = new int[N];
		int blockCharNumber[] = new int[N];

		int currentCharNumber = -1;
		blockCount = -1;
		for (int i = 0; i < S.length(); i++) {
			int charNumber = S.charAt(i) - 'a';
			if (charNumber == currentCharNumber) {
				blockSize[blockCount]++;
			} else {
				blockSize[++blockCount] = 1;
				blockCharNumber[blockCount] = charNumber;
				currentCharNumber = charNumber;
			}
		}
		blockCount++;

		int maxLengthBefore[] = new int[] {-1, -1, -1, 0};
		int lastBlock[][] = new int[26][4];
		int lastBlockLength[][] = new int[26][4];
		for (int j = 0; j < 26; j++)
			for (int i = 0; i < 4; i++)
				lastBlock[j][i] = -1;

		for (int i = 0; i < blockCount; i++) {
			for (int j = 0; j < 4; j++) {
				if (maxLengthBefore[j] == -1)
					continue;

				int blockChar = blockCharNumber[i];
				int currentMax = maxLengthBefore[j];

				// combine from last
				if (lastBlock[blockChar][j] != -1) {
					int combineLength = lastBlockLength[blockChar][j] + blockSize[i];
					lastBlock[blockChar][j] = i;
					maxLengthBefore[j] = Math.max(currentMax, combineLength);
					lastBlockLength[blockChar][j] = combineLength;
				}

				if (j > 0) { // stay
					int combineLength = currentMax + blockSize[i];
					maxLengthBefore[j - 1] = Math.max(maxLengthBefore[j - 1], combineLength);
					lastBlock[blockChar][j - 1] = i;
					lastBlockLength[blockChar][j - 1] =
							Math.max(lastBlockLength[blockChar][j - 1], combineLength);
				}
			}
		}
		return Math.max(Math.max(maxLengthBefore[0], maxLengthBefore[1]),
				Math.max(maxLengthBefore[2], maxLengthBefore[3]));
	}
}
