package com.company;

import java.util.HashSet;
import java.util.Set;

class Node{
    static HashSet<String> SetPlus() {
        HashSet<String> setPlus = new HashSet<>();
        setPlus.add("+");
        return setPlus;
    }
    static HashSet<String> SetMinus() {
        HashSet<String> setMinus = new HashSet<>();
        setMinus.add("-");
        return setMinus;
    }
    static  HashSet<String> SetMultiply() {
        HashSet<String> set = new HashSet<>();
        set.add("*");
        return set;
    }
    static  HashSet<String> SetDivide() {
        HashSet<String> set = new HashSet<>();
        set.add("+");
        return set;
    }
    static HashSet<String> Set(){
        HashSet<String> set = new HashSet<>();
        set.add("*");
        set.add("+");
        set.add("/");
        set.add("-");
        return set;
    }
    static HashSet<String> SetPlusMinus(){
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        return set;
    }
    static HashSet<String> SetMultiplyDivide(){
        HashSet<String> set = new HashSet<>();
        set.add("*");
        set.add("/");
        return set;
    }

    private boolean isBrackets = false;
    public boolean getIsBrackets() { return isBrackets; }

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
    public Node(String value, Node left, Node right){
        Value = value;
        Left = left;
        Right = right;
    }

    public void Add(Node node) {
        if (Set().contains(node.Value)) {
            if (!Set().contains(Value)) {
                if (Left == null) {
                    Left = new Node();
                    Left.Add(new Node(Value));
                    Value = node.Value;
                }
            } else {
                if (SetMultiplyDivide().contains(Value) || isBrackets) {
                    Left = new Node(Value, Left, Right);
                    Right = null;
                    Value = node.Value;
                } else {
                    if (SetPlusMinus().contains(Value)) {
                        Right.Add(node);
                    }
                }
            }
        } else {
            if (Value == null) {
                Value = node.Value;
                Left = node.Left;
                Right = node.Right;
            } else {
                if (Left == null) {
                    Left = new Node();
                    Left.Add(node);
                } else {
                    if (Right == null) {
                        Right = new Node();
                        Right.Add(node);
                    } else {
                        Right.Add(node);
                    }
                }
            }
        }
    }
    public void AddFromBufTree(Node rootBufTree) {
        if (Value == null) {
            isBrackets= true;
            Value = rootBufTree.Value;
            Left = rootBufTree.Left;
            Right = rootBufTree.Right;
        } else {
            if (Left == null)
                Left = new Node(rootBufTree.Value, rootBufTree.Left, rootBufTree.Right);
            else
                if (Right == null)
                    Right = new Node(rootBufTree.Value, rootBufTree.Left, rootBufTree.Right);
                else
                    Right.Add(rootBufTree);
        }
    }

    public void Print(){
        if (Value == null)
            return;
        else
        {
            System.out.println(Value);
            if (Left != null)
                Left.Print();
            if (Right != null)
                Right.Print();
        }
    }

    public int Result() {
        if (!Set().contains(Value))
            return Integer.parseInt(Value);
        else {
            if (SetPlus().contains(Value))
                return Left.Result() + Right.Result();
            else {
                if (SetMinus().contains(Value))
                    return Left.Result() - Right.Result();
                else {
                    if (SetMultiply().contains(Value))
                        return Left.Result() * Right.Result();
                    else {
                        return Left.Result() / Right.Result();
                    }
                }
            }
        }
    }
}

public class Tree{
    private Node Root;
    public Node getRoot() { return Root; }
    public void setRoot(Node root) { Root = root; }

    public Tree() { Root = new Node(); }

    public void Add(Node node){
        Root.Add(node);
    }
    public void AddFromBufTree(Node rootBufTree) {
        Root.AddFromBufTree(rootBufTree);
    }

    public void Print(){
        Root.Print();
    }

    public int Result() { return Root.Result(); }
}