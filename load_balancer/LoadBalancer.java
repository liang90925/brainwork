import java.util.*;

public class LoadBalancer {
    private List<Integer> ids = new ArrayList<>();
    private Map<Integer, Integer> idToIdx = new HashMap<>();
    private Random random = new Random(1);

    public LoadBalancer() {
        // do intialization if necessary
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        ids.add(server_id);
        idToIdx.put(server_id, ids.size() - 1);

    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        int idxToRemove = idToIdx.remove(server_id);
        int currIdsSize = ids.size();
        ids.set(idxToRemove, ids.get(currIdsSize -1));
        // update the idxToRemove to the new one
        idToIdx.put(ids.get(idxToRemove), idxToRemove);
        // Remove the last one.
        ids.remove(currIdsSize - 1);

    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        return ids.get(random.nextInt(ids.size()));
    }
}


/// Using set
//public class LoadBalancer {
//    private Set<Integer> ids = new HashSet<>();
//    private Random random = new Random(1);
//    private Integer size = 0;
//    public LoadBalancer() {
//        // do intialization if necessary
//    }
//
//    /*
//     * @param server_id: add a new server to the cluster
//     * @return: nothing
//     */
//    public void add(int server_id) {
//        // write your code here
//        ids.add(server_id);
//        size++;
//    }
//
//    /*
//     * @param server_id: server_id remove a bad server from the cluster
//     * @return: nothing
//     */
//    public void remove(int server_id) {
//        // write your code here
//        ids.remove(server_id);
//        size--;
//    }
//
//    /*
//     * @return: pick a server in the cluster randomly with equal probability
//     */
//    public int pick() {
//        // write your code here
//        int curr = random.nextInt(size);
//        int i = 0;
//        Iterator<Integer> itr = ids.iterator();
//
//        while(i != curr) {
//            itr.next();
//            i++;
//        }
//        return itr.next();
//
//    }
//}
