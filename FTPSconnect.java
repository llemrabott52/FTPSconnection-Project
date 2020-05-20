import java.io.IOException;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;


public class FTPSConnect{
    private static void showServerReply(FTPSClient ftpsClient) {
        String[] replies = ftpsClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
    public static void main(String[] args) {
        String server = "30.30.1.140";
        int port = 22;
        String user = "root";
        String pass = "rootroot";
        FTPSClient ftpsClient = new FTPSClient();
        try {
            ftpsClient.connect(server, port);
            showServerReply(ftpsClient);
            int replyCode = ftpsClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
            boolean success = ftpsClient.login(user, pass);
            showServerReply(ftpsClient);
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            } else {
                System.out.println("LOGGED IN SERVER SUCCESFULY !");
            }
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        }
    }
}