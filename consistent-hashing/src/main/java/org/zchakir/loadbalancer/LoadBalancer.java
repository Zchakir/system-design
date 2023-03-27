package org.zchakir.loadbalancer;
import java.util.List;
import java.util.TreeMap;
public class LoadBalancer {

    private TreeMap<Long, String> serverHashes = new TreeMap<>();
    private List<String> serverPool;

    public LoadBalancer(List<String> serverPool) {

    }

    public void addServer(String server) {

    }

    public void removeServer(String server) {

    }

    public String getServer(String key) {
        return "";
    }
}

