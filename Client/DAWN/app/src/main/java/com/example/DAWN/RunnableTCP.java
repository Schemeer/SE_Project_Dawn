package com.example.DAWN;

class RunnableTCP implements Runnable {
    private Thread t;
    private String threadName;
    private Client client;
    private String location;    
    Data dataclass;

    RunnableTCP(String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
        dataclass = new Data ();
        String serverName = dataclass.Server;
        int port = dataclass.port;
        client = new Client(serverName, port);
    }
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            System.out.println("Location: "  + this.location);
            client.testCon(this.location);
            Thread.sleep(1);
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start (String meg) {
        location = meg;
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}