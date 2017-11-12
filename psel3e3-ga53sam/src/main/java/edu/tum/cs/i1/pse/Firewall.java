package edu.tum.cs.i1.pse;

import java.util.Arrays;
import java.util.List;

public class Firewall implements ConnectionInterface {
    private int[] allowedPorts;

    private NetworkConnection realConnection = new NetworkConnection();

    public Firewall(int[] allowedPorts){
        this.allowedPorts=allowedPorts;
    }

    @Override
    public void open(String address, int port) {
        boolean isAllowed = false;
        for(int p:allowedPorts){
            if(port==p){
                isAllowed=true;
            }
        }
        if (isAllowed) {
            realConnection.open(address, port);
        } else {
            System.out.println("Connection rejected!");
            throw new RuntimeException("Connection rejected!");
        }
    }

    @Override
    public void close() {
            realConnection.close();
    }

    public int[] getAllowedPorts() {
        return allowedPorts;
    }

    public boolean isConnected(){
            return realConnection.isConnected();
    }
}
