package com.skillmatch.tests;

import org.junit.Test;

import java.io.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by agermenos on 12/8/2016.
 */
public class FileToTree {
    public TNode convertFile(String fileName){
        try {
            FileReader reader = new FileReader(new File(fileName));
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            TNode root = new TNode("blank");
            TNode dad = null;
            while (line!=null){
                String[] names = line.split(" ");
                if (dad==null) {
                    dad = new TNode(names[0]);
                    root = dad;
                }
                else {
                    root = root.getChild(names[0]).isPresent()?root.getChild(names[0]).get():new TNode(names[0]);
                }
                for (int k=1; k<names.length; k++) {
                    root.addChild(new TNode(names[k]));
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

    @Test
    public void test(){
        TNode node = this.convertFile("Names.txt");
        System.out.println(this.digestNode(node));
    }

    private String digestNode(TNode node) {
       String response = new String (node.name + "{\n\t");
       if (node.getChildren()!=null) {
           response= response + ("\t C:");
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
    public void addChildren(Set<TNode> children){
        this.setChildren(children);
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
}
