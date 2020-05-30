public class HashFunction {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        int size = key.length;
        int i = 0;
        int value = 0;
        while(i < size) {
            value = (int) (((long) value * 33 + key[i++]) % HASH_SIZE);
        }
        return value;
    }

    public static void main(String[] args) {
        HashFunction solution= new HashFunction();
        System.out.println(solution.hashCode("ubuntu".toCharArray(), 1007));
        System.out.println(solution.hashCode("abcdefghijklmnopqrstuvwxyz".toCharArray(), 2607));
    }
}
