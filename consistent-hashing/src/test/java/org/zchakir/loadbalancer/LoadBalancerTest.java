package org.zchakir.loadbalancer;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LoadBalancerTest {

    public static void main(String[] args) {
        // Create a new load balancer
        LoadBalancer loadBalancer = new LoadBalancer(new ArrayList<>());
        // Add some servers to the load balancer
        loadBalancer.addServer("server1");
        loadBalancer.addServer("server2");
        loadBalancer.addServer("server3");
        loadBalancer.addServer("server4");
        loadBalancer.addServer("server5");
        loadBalancer.addServer("server6");

        // Generate some requests to the load balancer
        List<String> requests = generateRequests(10000000);

        // Test the load balancing algorithm by counting the number of requests
        // that are assigned to each server
        TreeMap<String, Integer> requestCounts = new TreeMap<>();
        for (String request : requests) {
            String server = loadBalancer.getServer(request);
            if (requestCounts.containsKey(server)) {
                requestCounts.put(server, requestCounts.get(server) + 1);
            } else {
                requestCounts.put(server, 1);
            }
        }

        // Print the request counts for each server
        for (String server : requestCounts.keySet()) {
            System.out.println(server + ": " + requestCounts.get(server) + " requests");
        }
    }

    /**
     * Generates a list of random request IDs.
     */
    private static List<String> generateRequests(int numRequests) {
        List<String> requests = new ArrayList<>();
        for (int i = 0; i < numRequests; i++) {
            requests.add("request" + i);
        }
        return requests;
    }
}