import java.security.InvalidParameterException;
import java.util.concurrent.locks.ReentrantLock;

public class BadTransfer {
    public static class Account {
        private int cash;
        private ReentrantLock lock = new ReentrantLock();

        public void send_src_transfer_email() {
        }

        public void send_dst_transfer_email() {
        }
    }

//    public static void main(String[] args) throws Exception {
//        Account a = new Account();
//        Account b = new Account();
//        new BadTransfer().makeBadTransfer(a, b, 10);
//    }

    public void makeBadTransfer(Account src_account, Account dst_account,int amount) throws Exception {
        int preSrcCash = -1;
        try {
            src_account.lock.lock();
            try {
                dst_account.lock.lock();

                int src_cash = src_account.cash; // # DB read
                preSrcCash = src_cash;
                int dst_cash = dst_account.cash; // # DB read
                if (src_cash < amount) {
                    throw new InvalidParameterException("insufficient funds");
                }

                src_account.cash = src_cash - amount; // # DB write
                dst_account.cash = dst_cash + amount; //# DB write

                try {
                    retry(src_account::send_src_transfer_email);
                } catch (Exception e) {
                    // log WARNING
                }

                try {
                    retry(dst_account::send_dst_transfer_email);
                } catch (Exception e) {
                    // log WARNING
                }
            } catch (Exception e) {
                if (preSrcCash != -1) {
                    src_account.cash = preSrcCash;
                }
                throw e;
            } finally {
                dst_account.lock.unlock();
            }
        } finally {
            src_account.lock.unlock();
        }
    }

    private void retry(Runnable operation) throws Exception {
        Exception ex = null;
        for (int i = 0; i < 5; i++) {
            try {
                operation.run();
                return;
            } catch (Exception e) {
                ex = e;
            }
        }

        throw ex;
    }


}
