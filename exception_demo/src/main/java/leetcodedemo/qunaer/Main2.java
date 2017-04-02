package leetcodedemo.qunaer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.in;

/**
**  author:jack 2017年04月2017/4/1日
*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        int numsa[] = new int[n];
        int numsb[] = new int[n];

        for(int i = 0;i < n;i++){
            numsa[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            numsb[i] = sc.nextInt();
        }

        Tree tree = helper(numsa,0,numsa.length-1,numsb,0,numsb.length-1);

        Queue queue = new LinkedList();
        queue.add(tree);
        boolean flag = true;
        while(!queue.isEmpty()){
            Tree tree3 = (Tree) queue.poll();
            if(flag){
                System.out.print(tree3.val);
                flag = false;
            }else{
                System.out.print(" "+tree3.val);
            }
            if(tree3.left != null){
                queue.add(tree3.left);
            }

            if(tree3.right != null){
                queue.add(tree3.right);
            }

        }
    }

    private static Tree helper(int[] numsa,int afirst,int alast,int[] numsb,int bfirst,int blast){
        Tree tree;
        if(afirst > alast){
            return null;
        }
        if(afirst == alast){
            tree = new Tree(numsa[afirst]);
            return tree;
        }
        tree = new Tree(numsa[afirst]);
        int index = 0;
        for(int i = bfirst;i <= blast;i++){
            if(numsb[i] == numsa[afirst]){
                index = i;
//                System.out.println("index = "+ index);
                break;
            }
        }
        int count = index - bfirst;
        tree.left = helper(numsa,afirst+1 , afirst+count,numsb,bfirst,bfirst + count -1);
        tree.right = helper(numsa,afirst+count+1,alast,numsb,index+1,blast);
        return tree;
    }
}

class Tree{
    public int val;
    public Tree left;
    public Tree right;

    public Tree(int i) {
        this.val = i;
    }
}