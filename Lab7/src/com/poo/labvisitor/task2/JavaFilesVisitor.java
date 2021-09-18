package com.poo.labvisitor.task2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {
    int cnt = 0;
    private ArrayList<Path> javaFiles = new ArrayList<Path>();

    public final ArrayList<Path> getJavaFiles() throws IOException {
        return javaFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr)
            throws IOException {

        if(file.toString().endsWith("class") || file.toString().endsWith("java")) {
            javaFiles.add(file);
        }
        System.out.print(cnt + ".Path: " + file.toString() + " ");
        System.out.println(" Size: " + attr.size() + " bytes");
        this.cnt++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)
            throws IOException {
        System.err.println(exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException  {
        Path startingDir = Paths.get(".");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        Files.walkFileTree(startingDir, filesVisitor);
        System.out.println("JavaFiles: " + filesVisitor.getJavaFiles());
        System.out.println(filesVisitor.getJavaFiles().size());
    }
}
