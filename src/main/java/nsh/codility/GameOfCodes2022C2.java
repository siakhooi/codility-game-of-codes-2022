package nsh.codility;

import java.util.ArrayList;

public class GameOfCodes2022C2 implements GameOfCodes2022Interface {

	class Block {
		int size;
		int charNumber;

		public Block(int size, int charNumber) {
			this.size = size;
			this.charNumber = charNumber;
		}
	}

	ArrayList<Block> allBlock;

	public int solution(String S) {
		allBlock = new ArrayList<>();

		int currentCharNumber = -1;
		Block currentBlock = null;
		for (int i = 0; i < S.length(); i++) {
			int charNumber = S.charAt(i) - 'a';
			if (charNumber == currentCharNumber) {
				currentBlock.size++;
			} else {
				currentBlock = new Block(1, charNumber);
				allBlock.add(currentBlock);
				currentCharNumber = charNumber;
			}
		}

		int maxLengthBefore[] = new int[] {-1, -1, -1, 0};
		Block lastBlock[][] = new Block[26][4];
		int lastBlockLength[][] = new int[26][4];


		for (int i = 0; i < allBlock.size(); i++) {
			Block b = allBlock.get(i);
			for (int j = 0; j < 4; j++) {
				if (maxLengthBefore[j] == -1)
					continue;

				int currentMax = maxLengthBefore[j];

				// combine from last
				if (lastBlock[b.charNumber][j] != null) {
					int combineLength = lastBlockLength[b.charNumber][j] + b.size;
					maxLengthBefore[j] = Math.max(currentMax, combineLength);
					lastBlock[b.charNumber][j] = b;
					lastBlockLength[b.charNumber][j] = combineLength;
				}

				if (j > 0) { // stay
					int combineLength = currentMax + b.size;
					maxLengthBefore[j - 1] = Math.max(maxLengthBefore[j - 1], combineLength);
					lastBlock[b.charNumber][j - 1] = b;
					lastBlockLength[b.charNumber][j - 1] =
							Math.max(lastBlockLength[b.charNumber][j - 1], combineLength);
				}
			}
		}

		return Math.max(Math.max(maxLengthBefore[0], maxLengthBefore[1]),
				Math.max(maxLengthBefore[2], maxLengthBefore[3]));
	}
}
