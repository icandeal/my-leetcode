package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/1.
 *
 * LeetCode 1116. 打印零与奇偶数
 * 难度 中等
 */
public class TestZeroEvenOdd {
    @Test
    public void test() {
        ZeroEvenOdd zeo = new ZeroEvenOdd(5);
        IntConsumer i0 = new IntConsumer(zeo, 0);
        IntConsumer i1 = new IntConsumer(zeo, 1);
        IntConsumer i2 = new IntConsumer(zeo, 2);

        i0.start();
        i1.start();
        i2.start();
        try {
            i0.join();
            i1.join();
            i2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class IntConsumer extends Thread {
        private ZeroEvenOdd obj;
        private int type;

        public IntConsumer(ZeroEvenOdd obj, int type) {
            this.obj = obj;
            this.type = type;
        }

        @Override
        public void run() {
            try {
                switch (type) {
                    case 0:
                        obj.zero(this);
                        break;
                    case 1:
                        obj.even(this);
                        break;
                    case 2:
                        obj.odd(this);
                        break;
                }
            } catch (InterruptedException e) {
            }
        }

        public void accept(int x) {
            System.out.print(x);
        }
    }

    class ZeroEvenOdd {
        private int n;
        private Integer flag = 0;
        private int num = 1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (flag != 0) {
                        this.wait();
                    }
                    printNumber.accept(0);
                    if (num % 2 == 0)
                        flag = 2;
                    else {
                        flag = 1;
                    }
                    this.notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n / 2 + n % 2; i++) {
                synchronized (this) {
                    while (flag != 1) {
                        this.wait();
                    }
                    printNumber.accept(num++);
                    flag = 0;
                    this.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n / 2; i++) {
                synchronized (this) {
                    while (flag != 2) {
                        this.wait();
                    }
                    printNumber.accept(num++);
                    flag = 0;
                    this.notifyAll();
                }
            }
        }
    }
}
