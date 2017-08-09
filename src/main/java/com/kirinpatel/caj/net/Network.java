package main.java.com.kirinpatel.caj.net;

public abstract class Network {

    private final NETWORK_TYPE type;

    public enum NETWORK_TYPE {
        SERVER(0),
        CLIENT(1);

        private int networkType;

        NETWORK_TYPE(int networkType) {
            this.networkType = networkType;
        }

        public int getNetworkType() {
            return networkType;
        }
    }

    Network(NETWORK_TYPE type) {
        this.type = type;
    }

    public NETWORK_TYPE getType() {
        return type;
    }
}
