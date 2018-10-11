package com.sleepsoft.tests;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by agermenos on 12/8/2016.
 */
public class FileToTree {
    private void log(String text){
        System.out.println(text);
    }

    public TNode convertFile(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))){
            String line = br.readLine();
            TNode root = new TNode("");
            TNode dad = root;
            while (line!=null){
                String[] names = line.split(",");
                if (root.name.isEmpty()) {
                    root.addChildren(names);
                    root.setName("BASE");
                }
                else {
                    root = root.getChild(names[0]).get();
                    root.setName(names[0]);
                    root.addChildren(copyRange(names, 1, (names.length-1)));
                }
                line = br.readLine();
            }
            return dad;
        }
        catch (IOException ioException){
            ioException.printStackTrace();
            return null;
        }
    }

    private String[] copyRange(String[] origin, int i, int i1) {
        String[] returnValues = new String[i1];
        for (int k=0; k<i1; k++){
            returnValues[k]=origin[k+i];
        }
        return returnValues;
    }

    @Test
    public void test(){
        TNode node = this.convertFile("Names.txt");
        System.out.println(this.digestNode(node));
    }

    private String digestNode(TNode node) {
       String response = new String (node.name + "{");
       if (node.getChildren()!=null) {
           for (TNode child:node.getChildren()) {
               response = "\t" + response + digestNode(child) + " ";
           }
       }
       return response + "}";
    }
}

class TNode{
    Set<TNode> children;
    String name;

    public TNode(String name, Set<TNode>children){
        this.name=name;
        this.children=children;
    }
    public TNode(String name){
        this.name=name;
    }

    public void addChild(TNode child){
        if (children==null) {
            children = new HashSet<>();
        }
        children.add(child);
    }
    public void addChildren(String[] children){
        this.setChildren(Arrays.stream(children).map(TNode::new).collect(Collectors.toSet()));
    }

    public Set<TNode> getChildren() {
        return children;
    }

    public void setChildren(Set<TNode> children) {
        this.children = children;
    }

    public Optional<TNode> getChild(String name){
        return children.stream().filter((TNode node) -> node.name.equals(name)).findFirst();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
