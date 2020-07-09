package com.ycf;

public class FastSort {
    public static void main(String[] args) {
        int[] a = new int[] {4,2,7,3,12,8,5,11,9,1,10};
        System.out.print("Before: ");
        for (int i: a) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
        System.out.print("After : ");
        fastSort(a, 0, a.length - 1);

        for (int i: a) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void fastSort(int[] a, int begin, int end) {
        int b = begin, e = end;
        int fix = a[b];
        while (b < e) {
            while (b < e) {
                if (fix > a[e]) {
                    a[b] = a[e];
                    a[e] = fix;
                    break;
                }
                e --;
            }
            while (b < e) {
                if (fix < a[b]) {
                    a[e] = a[b];
                    a[b] = fix;
                    break;
                }
                b ++;
            }
        }
        if (begin < b)
            fastSort(a, begin, b);
        if (e + 1 < end)
            fastSort(a, e + 1, end);
    }
}
