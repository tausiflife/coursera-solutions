package com.leetcode;

import org.jetbrains.annotations.NotNull;

public class LockOrdering {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAcct, final Account toAcct, final DollarAmount amount)
            throws InsufficientFundsException {
        class Helper {
            public void transfer() throws InsufficientFundsException {
                if (fromAcct.getBalance().compareTo(amount) < 0)
                    throw new InsufficientFundsException();
                else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);
        if (fromHash < toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    private class Account {
        DollarAmount dollarAmount;

        public void debit(DollarAmount amount) {

        }

        public void credit(DollarAmount amount) {

        }

        public DollarAmount getBalance() {
            return dollarAmount;
        }
    }

    private class DollarAmount implements Comparable {
        @Override
        public int compareTo(@NotNull Object o) {
            return 0;
        }
    }

    private class InsufficientFundsException extends Exception {
    }
}
