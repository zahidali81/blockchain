package BlockchainAdvanceHeaderInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {

	 List<Block> chain;
	
	public Blockchain() {
	
		chain = new ArrayList<Block>();
		chain.add(generateGenesisBlock());

	}
	
	// this creates genesis (First) block and will be added to the chain
	private Block generateGenesisBlock() {
		
		Block genesis = new Block("0x200", new Date(), "<transaction>");
		genesis.setPreviousBlockHash(null);
		genesis.ComputeHash();
		return genesis;
	}
	// this adds a new block to the chain
	public void addBlock(Block block) {
		
		Block newBlock = block;
		newBlock.setPreviousBlockHash(chain.get(chain.size()-1).getHash());
		newBlock.ComputeHash();
		
		chain.add(newBlock);
		
	}

	public void displayChainData()
	{
		for (int i = 0; i < chain.size(); i++) {
			System.out.println("Block:" + i);
			System.out.println("BlockData:" + chain.get(i).getData());
			System.out.println("Version:" + chain.get(i).getVersion());
			System.out.println("TimeStamp:" + chain.get(i).getTimeStamp());
			System.out.println("PreviousHash:" + chain.get(i).getPreviousBlockHash());
			System.out.println("Hash:" + chain.get(i).getHash());
			System.out.println();
		}
	}
	
	public Block getLatestBlock() {
		return this.chain.get(chain.size()-1);
	}
	
	public boolean isValid()
	{
		for (int i =chain.size()-1; i > 0; i--) {
			if(!(chain.get(i).getHash().equals(chain.get(i).ComputeHash()))) {
				return false;
			}
			
			if(!(chain.get(i).getPreviousBlockHash().equals(chain.get(i-1).ComputeHash()))) {
				return false;
			}
				
		}
		return true;
	}

}
