package BlockchainAdvanceHeaderInfo;

import java.util.Date;

public class BlockTest {

	public static void main(String[] args) {
		
		Blockchain bitcoin = new Blockchain();
		
		Block a = new Block("0x200", new Date(),"Bob recieves 30 bitcoins from alex");
		Block b = new Block("0x200", new Date(),"Sarah sends Julia 1 bitcoins");
		Block c = new Block("0x200", new Date(),"Andrew sends Peter 1.5 bitcoins");

		bitcoin.addBlock(a);
		bitcoin.addBlock(b);
		bitcoin.addBlock(c);
		
		bitcoin.getLatestBlock().setPreviousBlockHash("Abcd123");
		
		bitcoin.displayChainData();

		System.out.println((bitcoin.isValid() ? "The chain is Valid" : "The chain is not Valid"));
		
		
	}

}
