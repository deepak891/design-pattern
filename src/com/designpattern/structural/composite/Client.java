package com.designpattern.structural.composite;

public class Client {
    public static void main(String[] args) {
        File root1 = createTreeOne();
        root1.ls();
        System.out.println("**********************************************");
        File root2 = createTreeTwo();
        root2.ls();

    }

    //Client build tree using leaf and  composite
    private static File createTreeOne() {
        File file1 = new BinaryFile("File1", 1000);
        Directory directory = new Directory("dir1");
        directory.addFile(file1);

        File file2 = new BinaryFile("File2", 100);
        File file3 = new BinaryFile("File3", 10000);
        Directory directory2 = new Directory("dir2");
        directory2.addFile(file2);
        directory2.addFile(file3);
        directory2.addFile(directory);
        return directory2;
    }

    private static File createTreeTwo() {
        return new BinaryFile("Another file", 200);
    }
}
