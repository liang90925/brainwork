
/*
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]

Sample output:

    findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
    findContiguousHistory(user0, user2) => [] (empty)
    findContiguousHistory(user2, user1) => ["a"]
    findContiguousHistory(user5, user2) => ["a"]
    findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
    findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]

n: length of the first user's browsing history
m: length of the second user's browsing history


*/


import java.util.*;
import java.util.stream.Collectors;

public class KrtLongestSubsequStringBetter {
        public List<String> getMaxSubStr(String[] user1, String[] user2) {
            int len1 = user1.length;
            int len2 = user2.length;

            List<String>[][] dp = new List[len1][len2];
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    dp[i][j] = new ArrayList<>();
                }
            }

            int max = 0;
            int maxIdx = 0;

            for (int i = 0; i < len1; i++) {
                if (user1[i].equals(user2[0])) {
                    dp[i][0].add(user2[0]);
                    if (dp[i][0].size() > max) {
                        max = 1;
                        maxIdx = i * len2;
                    }
                }
            }

            for (int i = 1; i < len2; i++) {
                if (user2[i].equals(user1[0])) {
                    dp[0][i].add(user1[0]);
                    if (dp[0][i].size() > max) {
                        max = dp[0][i].size();
                        maxIdx = i;
                    }
                }
            }

            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    if (user1[i].equals(user2[j])) {
                        dp[i][j] = new ArrayList<>(dp[i-1][j-1]);
                        dp[i][j].add(user1[i]);
                    } else {
                        dp[i][j] = new ArrayList<>();
                    }

                    if (dp[i][j].size() > max) {
                        max = dp[i][j].size();
                        maxIdx = i * len2 + j;
                    }
                }
            }

            return dp[maxIdx/len2][maxIdx%len2];
        }


        public List<String> countDomains(String[] domains) {
            Map<String, Integer> domainCntMap = new HashMap<>();

            for (String domain: domains) {
                String[] splitStr = domain.split(",");
                int cnt = Integer.parseInt(splitStr[0]);
                String dm = splitStr[1];

                while(true) {
                    domainCntMap.put(dm, domainCntMap.getOrDefault(dm, 0) + cnt);
                    if (!dm.contains(".")) {
                        break;
                    }
                    dm = dm.substring(dm.indexOf(".") + 1);
                }
            }

            return domainCntMap.entrySet().stream()
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .collect(Collectors.toList());
        }

        public static void main(String[] argv) {

            String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
            String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};

            KrtLongestSubsequStringBetter solution = new KrtLongestSubsequStringBetter();

            System.out.println(solution.getMaxSubStr(user0, user1));



            String[] user2 = {"a", "/one", "/two"};
            String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
            String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
            String[] user5 = {"a"};

            System.out.println(solution.getMaxSubStr(user2, user1));
            System.out.println(solution.getMaxSubStr(user0, user2));
            System.out.println(solution.getMaxSubStr(user5, user2));
            System.out.println(solution.getMaxSubStr(user3, user4));
            System.out.println(solution.getMaxSubStr(user4, user3));



        }
    }
