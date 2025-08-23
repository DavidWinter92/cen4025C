package org.assignment1;

import java.io.File;
import java.util.Scanner;

/**
 * This class represents a folder in your file system and all its subfolders.
 * It keeps track of the folder name, how many files are inside (including subfolders),
 * the total size of those files, and any child folders it contains.
 * You can build a tree of folders and print it out with proper indentation to see the hierarchy.
 */
public class FileTree {

    private String name;
    private int numFiles;
    private long totalSize;
    private FileTree[] children;

    /**
     * Creates a FileTree node for a folder path.
     * It sets the folder name and then builds the tree recursively for all its contents.
     *
     * @param path the folder path to scan
     */
    public FileTree(String path) {
        File folder = new File(path);
        this.name = folder.getName();
        buildTree(folder);
    }

    /**
     * Looks inside the folder and builds the tree.
     * Counts all files, adds up their sizes, and makes FileTree objects for any subfolders.
     *
     * @param folder the folder to scan
     */
    private void buildTree(File folder) {
        File[] files = folder.listFiles();
        if (files == null) return;

        int childCount = 0;
        for (File f : files) {
            if (f.isDirectory()) childCount++;
        }
        children = new FileTree[childCount];

        int index = 0;
        for (File f : files) {
            if (f.isFile()) {
                numFiles++;
                totalSize += f.length();
            } else if (f.isDirectory()) {
                FileTree childTree = new FileTree(f.getAbsolutePath());
                children[index++] = childTree;
                totalSize += childTree.totalSize;
                numFiles += childTree.numFiles;
            }
        }
    }

    /**
     * Prints out the folder tree in a nice, readable format.
     * Each level of the tree is indented so you can see the folder hierarchy.
     *
     * @param depth how deep we are in the tree (used to add spaces)
     */
    public void printTree(int depth) {
        String indent = " ".repeat(depth * 4);
        System.out.printf("%s%s [Files: %d, Size: %d bytes]%n", indent, name, numFiles, totalSize);

        if (children != null) {
            for (FileTree child : children) {
                if (child != null) child.printTree(depth + 1);
            }
        }
    }

    /**
     * Starts the program.
     * Asks the user for a folder path, builds the file tree, and prints it out.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the folder path to scan: ");
        String path = scanner.nextLine();

        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Oops! That doesn't look like a valid folder path.");
            return;
        }

        FileTree tree = new FileTree(path);
        System.out.println("\nHere's the folder tree:");
        tree.printTree(0);
    }
}
