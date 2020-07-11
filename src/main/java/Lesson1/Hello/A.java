/**
 * @(#)A.java, 7月 09, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package Lesson1.Hello;

/**
 * @author suxinyu
 */
public class A {
    public A() {
        System.out.println("A init");
    }

    static {
        System.out.println("static");
    }

    public static void show() {
        System.out.println("show");
    }
}