package com.company;

import java.util.HashSet;

class Node{
    static HashSet<String> Set(){
        HashSet<String> set = new HashSet<>();

        set.add("*");
        set.add("+");

        return set;
    }

    private String Value;
    public String getValue() { return Value; }
    public void setValue(String value) { Value = value; }

    private Node Left, Right;
    public Node getLeft() { return Left; }
    public void setLeft(Node left) { Left = left; }
    public Node getRight() { return Right; }
    public void setRight(Node right) { Right = right; }

    public Node(){
        Value = null;
        Left = null;
        Right = null;
    }
    public Node(String value){
        Value = value;
        Left = null;
        Right = null;
    }

    public void Add(Node node) {
        if (node.Value == "(" or )

        if (Value == null) {
            Value = node.Value;
            Left = new Node();
            Right = new Node();
        }
        else {
            if (Set().contains(Value)){
                Right.Add(new Node(node.Value));
            }
            else {
                Left.Add(new Node(Value));
                Value = node.Value;
            }
        }
    }

    public void Print(){
        if (Value == null)
            return;
        else
        {
            System.out.println(Value);
            Left.Print();
            Right.Print();
        }
    }
}

public class Tree{
    private Node Root;
    public Node getRoot() { return Root; }
    public void setRoot(Node root) { Root = root; }

    public Tree() { Root = new Node(); }

    public void Add(String value){
        Root.Add(new Node(value));
    }

    public void Print(){
        Root.Print();
    }
}