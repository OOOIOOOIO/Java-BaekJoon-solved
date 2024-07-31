package problems.AAA;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        A b = new B();
        b.paint();
        b.draw();
    }


    static class A {
        public void paint() {
            System.out.print("A");
            this.draw();
        }
        public void draw() {
            System.out.print("B");
            draw();
        }
    }

    static class B extends A {
        public void paint() {
            super.draw();
            System.out.print("C");
            this.draw();
        }
        public void draw() {
            System.out.print("D");
        }
    }
}