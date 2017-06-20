package ftp;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


public class FTPConnectAndLogin {
	private static void showServerReply(FTPClient ftpClient) {
		String [] replies = ftpClient.getReplyStrings();
		if (replies!= null && replies.length > 0){
			for (String aReply: replies) {
				System.out.println("Server: " + aReply);
			}
		}
	}
	
	public static void main(String [] args){
		
		String server ="ftp2.cowi.dk";
		int port = 21;
		
		String user = "E18Rugtvedt";
		String pass = "Bcwnvf69";
		
		FTPClient ftpClient = new FTPClient();
		try{
			ftpClient.connect(server, port);
			showServerReply(ftpClient);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)){
				System.out.println("Operation failed. Server reply code: " + replyCode);
				return;
			}
			boolean success = ftpClient.login(user, pass);
			showServerReply(ftpClient);
			if(!success) {
				System.out.println("Could not login to the server");
				return;
			}
			else {
				System.out.println("Logged in server");
			}
		}catch (IOException e) {
				System.out.println("Something went wrong");
				e.printStackTrace();
			}
		
			
		}
		
		
		
	}


