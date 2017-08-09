package java.com.kirinpatel.caj;

import com.sun.media.jfxmedia.logging.Logger;
import java.com.kirinpatel.caj.net.Client;
import java.com.kirinpatel.caj.net.Server;

public class CAJ {

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("debug")) {
                Logger.setLevel(0);
            }
            if (arg.equals("server")) {
                new Server();
            } else {
                new Client();
            }
        }
    }
}
