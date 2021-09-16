package com.company;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree bufTree = new Tree();

        String str = "(3+2*2)*(7+6/3)";

        Boolean addInBufTree = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '(' && str.charAt(i) != ')')
                if (addInBufTree)
                    bufTree.Add(new Node(Character.toString(str.charAt(i))));
                else
                    tree.Add(new Node(Character.toString(str.charAt(i))));
            else {
                if (str.charAt(i) == '(')
                    addInBufTree = true;
                if (str.charAt(i) == ')') {
                    addInBufTree = false;
                    tree.AddFromBufTree(bufTree.getRoot());
                    bufTree = new Tree();
                }
            }
        }
        //tree.Print();

        System.out.println(tree.Result());
    }
}
