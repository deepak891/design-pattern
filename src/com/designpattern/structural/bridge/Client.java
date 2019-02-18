package com.designpattern.structural.bridge;

/**
 * Bridge Design pattern
 *      - We use this pattern when we want our abstraction and implementation to be decoupled.
 *      - Bridge pattern defines abstraction hierarchies and implementation hierarchies separate and bring both together
 *      using composition.
 *      - Implementation do not HAVE to have methods that exactly match method defined in abstraction.
 *      It is fairly common to have primitive methods in implementation, methods which does small work; in implementation
 *      Abstraction uses these methods to provide its functionality
 */
public class Client {
    public static void main(String[] args) {
        FifoCollection<Integer> collection = new Queue<>(new SinglyLinkedList<>());
        collection.offer(10);
        collection.offer(40);
        collection.offer(99);

        System.out.println(collection.poll());
        System.out.println(collection.poll());
        System.out.println(collection.poll());
        System.out.println(collection.poll());

    }
}
