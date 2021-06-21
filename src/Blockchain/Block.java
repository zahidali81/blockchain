package BlockchainAdvanceHeaderInfo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
	private String version;
	private Date timeStamp;
	private String hash;
	private String previousBlockHash;
	private String data;
	
	public Block(String version, Date timeStamp, String data) {
		super();
		this.version = version;
		this.timeStamp = timeStamp;
		this.data = data;
		
		this.hash = ComputeHash();
		
		
	}
	
// computes hash ---> SHA256
String ComputeHash()
{
	String dataToHash = "" + this.version + this.timeStamp + this.previousBlockHash + this.data;
	
	MessageDigest digest;
	String encoded = null;
	
	try {
		digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
		encoded = Base64.getEncoder().encodeToString(hash);
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	
	this.hash = encoded;
	return encoded;
}
	
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	
	

}
