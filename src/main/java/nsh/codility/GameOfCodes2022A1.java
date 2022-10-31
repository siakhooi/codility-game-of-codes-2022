package nsh.codility;

import java.util.ArrayList;

public class GameOfCodes2022A1 implements GameOfCodes2022Interface {

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

	int findMaxLength(int blockIndex, int maxBlock, int currentLength) {
		if (maxBlock == 0 || blockIndex == allBlock.size())
			return currentLength;

		// delete this block
		int R = findMaxLength(blockIndex + 1, maxBlock, currentLength);

		Block c = allBlock.get(blockIndex);
		int totalChar = 0;

		for (int i = c.indexByChar; i < allBlockByChar.get(c.charNumber).size(); i++) {
			Block n = allBlockByChar.get(c.charNumber).get(i);
			totalChar += n.size;
			int l3 = findMaxLength(n.indexByAll + 1, maxBlock - 1, currentLength + totalChar);
			R = Math.max(R, l3);
		}
		return R;
	}

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

		return findMaxLength(0, 3, 0);
	}

}
