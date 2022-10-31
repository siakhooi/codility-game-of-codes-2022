package nsh.codility;

public class GameOfCodes2022A3 implements GameOfCodes2022Interface {

	int blockSize[];
	int blockCharNumber[];
	int charIndex[];
	int blockCount = 0;

	int blockIndexByChar[][];
	int countBlockByChar[];

	int findMaxLength(int blockIndex, int maxBlock, int currentLength) {

		// delete this block
		int R = blockIndex < blockCount - 1 ? findMaxLength(blockIndex + 1, maxBlock, currentLength)
				: currentLength;
		int currentCharNumber = blockCharNumber[blockIndex];
		int currenCharIndex = charIndex[blockIndex];
		int totalChar = 0;

		for (int i = currenCharIndex; i < countBlockByChar[currentCharNumber]; i++) {
			int newIndex = blockIndexByChar[currentCharNumber][i];
			int size = blockSize[newIndex];
			totalChar += size;
			int l3 = maxBlock > 1 && newIndex + 1 < blockCount
					? findMaxLength(newIndex + 1, maxBlock - 1, currentLength + totalChar)
					: currentLength + totalChar;
			R = Math.max(R, l3);
		}
		return R;
	}

	public int solution(String S) {
		int N = S.length();
		blockSize = new int[N];
		blockCharNumber = new int[N];
		charIndex = new int[N];
		blockIndexByChar = new int[26][N];
		countBlockByChar = new int[26];

		int currentCharNumber = -1;
		for (int i = 0; i < S.length(); i++) {
			int charNumber = S.charAt(i) - 'a';
			if (charNumber == currentCharNumber) {
				blockSize[blockCount - 1]++;
			} else {
				blockSize[blockCount] = 1;
				blockCharNumber[blockCount] = charNumber;
				blockIndexByChar[charNumber][countBlockByChar[charNumber]] = blockCount;
				charIndex[blockCount] = countBlockByChar[charNumber];
				blockCount++;
				countBlockByChar[charNumber]++;
				currentCharNumber = charNumber;
			}
		}

		return findMaxLength(0, 3, 0);
	}

}
