import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * public class HtmlHelper {
 *     public static List<String> parseUrls(String url);
 *         // Get all urls from a webpage of given url.
 * }
 */

public class WebCrawler {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    AtomicLong numTasks = new AtomicLong(0);  // wait for all task to finish
    Lock lock = new ReentrantLock();  // to protect ans::List<String> and visited::Set<String>.
    List<String> results = new ArrayList<>();
    Set<String> visited = new HashSet<>();

    /**
     * @param url: a url of root page
     * @return: all urls
     */
    public List<String> crawler(String url) {
        // write your code here
        visited.add(url);
        results.add(url);
        executorService.execute(new CrawlerRunnable(url));
        numTasks.incrementAndGet();
        try {
            while( numTasks.get() != 0) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return results;
    }

    private class CrawlerRunnable implements Runnable {
        String url;

        public CrawlerRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            try {
                for (String parsedUrl : HtmlHelper.parseUrls(url)) {
                    if (parsedUrl.contains("wikipedia.org")) {
                        lock.lock();
                        if (!visited.contains(parsedUrl)) {
                            visited.add(parsedUrl);
                            results.add(parsedUrl);
                            executorService.execute(new CrawlerRunnable(parsedUrl));
                            numTasks.incrementAndGet();
                        }
                        lock.unlock();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                numTasks.decrementAndGet();
            }

        }
    }
}
