package org.zchakir.loadbalancer;


import org.zchakir.utils.HashUtils;

import java.util.*;

public class LoadBalancer {
    private TreeMap<Long, String> serverHashes = new TreeMap<>();
    private List<String> serverPool;

    public LoadBalancer(List<String> serverPool) {
        this.serverPool = serverPool;
        for (String server : serverPool) {
            addServer(server);
        }
    }

    public void addServer(String server) {
        // Add the server to the server pool
        serverPool.add(server);

        // Generate server hashes
        for (int i = 0; i < 100; i++) {
            String virtualServer = server + "-" + i;
            long hash = new HashUtils().getHash(virtualServer);
            serverHashes.put(hash, server);
        }
    }

    public void removeServer(String server) {
        // Remove the server from the server pool
        serverPool.remove(server);

        // Remove server hashes
        Iterator<Map.Entry<Long, String>> iterator = serverHashes.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, String> entry = iterator.next();
            if (entry.getValue().equals(server)) {
                iterator.remove();
            }
        }
    }

    public String getServer(String key) {
        // Get the hash of the key
        long hash = new HashUtils().getHash(key);

        // Get the server with the smallest hash greater than or equal to the key hash
        SortedMap<Long, String> tailMap = serverHashes.tailMap(hash);
        if (tailMap.isEmpty()) {
            return serverHashes.firstEntry().getValue();
        }
        return tailMap.get(tailMap.firstKey());
    }
}

