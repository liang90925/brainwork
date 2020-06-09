/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GFSClient {

    private Map<String, List<Integer>> fileToChunkIds;
    private int chunkID;
    private int chunkSize;
    BaseGFSClient client;
    /*
     * @param chunkSize: An integer
     */public GFSClient(int chunkSize) {
        // do intialization if necessary
        this.chunkSize = chunkSize;
        this.chunkID = 0;
        this.fileToChunkIds = new HashMap<>();
        this.client = new BaseGFSClient();
    }

    /*
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        // write your code here
        if (!fileToChunkIds.containsKey(filename)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int id: fileToChunkIds.get(filename)) {
            sb.append(client.readChunk(filename,id));
        }
        return sb.toString();
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        // write your code here
        int contentSize = content.length();
        int chunkNeeded = contentSize % chunkSize == 0 ? contentSize / chunkSize : contentSize / chunkSize + 1;
        fileToChunkIds.put(filename, new ArrayList<>());
        for (int i = 0; i < chunkNeeded; i++) {
            int left = i * chunkSize;
            int right = Math.min(left + chunkSize, contentSize);
            fileToChunkIds.get(filename).add(chunkID);
            client.writeChunk(filename, chunkID++, content.substring(left, right));
        }
    }
}
