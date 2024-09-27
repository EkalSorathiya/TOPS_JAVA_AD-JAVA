package com.p2;

import com.p1.Protection;

public class NonDerived {
    public NonDerived() {
        Protection p = new Protection();
        System.out.println("NonDerived Default Constructor");
//        System.out.println("n: " + p.n);
        System.out.println("n_pub: " + p.n_pub);
//            System.out.println("n_pri: "+p.n_pri);
//        System.out.println("n_pro: " + p.n_pro);
    }
}
