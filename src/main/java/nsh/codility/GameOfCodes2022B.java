package nsh.codility;

import java.util.ArrayList;

public class GameOfCodes2022B implements GameOfCodes2022Interface {

	class Block {
		int size;
		int charNumber;
		int indexByChar;
		int indexByAll;

		public Block(int size, int charNumber, int indexByChar, int indexByAll) {
			this.size = size;
			this.charNumber = charNumber;
			this.indexByChar = indexByChar;
			this.indexByAll = indexByAll;
		}
	}

	ArrayList<Block> allBlock;
	ArrayList<ArrayList<Block>> allBlockByChar;

	public int solution(String S) {
		allBlock = new ArrayList<>();
		allBlockByChar = new ArrayList<>(26);

		for (int i = 0; i < 26; i++)
			allBlockByChar.add(new ArrayList<>());
		int currentCharNumber = -1;
		Block currentBlock = null;
		for (int i = 0; i < S.length(); i++) {
			int charNumber = S.charAt(i) - 'a';
			if (charNumber == currentCharNumber) {
				currentBlock.size++;
			} else {
				currentBlock =
						new Block(1, charNumber, allBlockByChar.get(charNumber).size(), allBlock.size());
				allBlock.add(currentBlock);
				allBlockByChar.get(charNumber).add(currentBlock);
				currentCharNumber = charNumber;
			}
		}

		int maxLength[][] = new int[allBlock.size()][4];
		int R = 0;
		for (int i = 0; i < allBlock.size(); i++) {
			Block b = allBlock.get(i);
			for (int j = 1; j < 4; j++) {
				int currentMax = maxLength[i][j];
				// delete
				if (i < allBlock.size() - 1) {
					maxLength[i + 1][j] = Math.max(maxLength[i + 1][j], currentMax);

				}
				int totalLength = 0;
				for (int k = b.indexByChar; k < allBlockByChar.get(b.charNumber).size(); k++) {
					Block n = allBlockByChar.get(b.charNumber).get(k);
					totalLength += n.size;
					R = Math.max(R, currentMax + totalLength);
					if (n.indexByAll < allBlock.size() - 1 && j > 1) {
						maxLength[n.indexByAll + 1][j - 1] =
								Math.max(maxLength[n.indexByAll + 1][j - 1], currentMax + totalLength);
					}
				}
			}
		}
		return R;
	}
}
