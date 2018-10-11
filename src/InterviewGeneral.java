package Interview;

import CodeFight.MaxHeap;
import CodeFight.MinHeap;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by tranpham on 3/26/18.
 */
public class InterviewGeneral {

    int[] findMaxSumArray(int[] array){
        return null;
    }

    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        List<String> textLog = logLines.stream().filter((str) -> {
            String[] strArr = str.split("\\s");
            if(strArr[1].charAt(0)>='a' && strArr[1].charAt(0)<='z')
                return true;
            return false;
        }).collect(Collectors.toList());
        textLog.sort((o1,o2) -> {
            String subStr1 = o1.substring(o1.indexOf(' ')+1);
            String subStr2 = o2.substring(o2.indexOf(' ')+1);
            int res = subStr1.compareTo(subStr2);
            if(res==0)
                res = o1.compareTo(o2);
            return res;
        });
        List<String> numLog = logLines.stream().filter((str) -> {
            String[] strArr = str.split("\\s");
            if(strArr[1].charAt(0)>='0' && strArr[1].charAt(0)<='9')
                return true;
            return false;
        }).collect(Collectors.toList());
        textLog.addAll(numLog);
        return textLog;
        // WRITE YOUR CODE HERE
    }

    public List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                 List<String> wordsToExclude)
    {
        Set<String> excludeSet = new HashSet<String>();
        for(String str:wordsToExclude)
            excludeSet.add(str);
        String[] words = literatureText.split("\\s");

        HashMap<String,Integer> hm = new HashMap<>();
        for(String word:words){
            if(!excludeSet.contains(word)){
                if(!hm.containsKey(word))
                    hm.put(word,0);
                hm.put(word,hm.get(word)+1);
            }
        }
        Map.Entry<String,Integer> maxEntry = null;
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            if(maxEntry==null || entry.getValue()>maxEntry.getValue())
                maxEntry = entry;
        }
        final int maxVal = maxEntry.getValue();

//        List<String> res =hm.entrySet().stream().filter((o1)->{return o1.getValue()==maxVal;})
//                                        .map(Map.Entry::getKey).collect(Collectors.toList());
        List<String> res = new LinkedList<>();
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            if(entry.getValue()==maxVal)
                res.add(entry.getKey());
        }
        return res;
        // WRITE YOUR CODE HERE
    }

    public float[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
        PriorityQueue<Integer> minQueueRight = new PriorityQueue<Integer>(a.length,(n1,n2) ->{return n1-n2;});
        PriorityQueue<Integer> maxQueueLeft = new PriorityQueue<Integer>(a.length,(n1,n2) ->{return n2-n1;});
        float[] res = new float[a.length];
        float median = 0;
        for(int i=0;i<a.length;i++){
            if(maxQueueLeft.size()>minQueueRight.size()) {
                if (a[i]>=median) {
                    minQueueRight.add(a[i]);
                } else {
                    minQueueRight.add(maxQueueLeft.poll());
                    maxQueueLeft.add(a[i]);
                }
            }
            else if(maxQueueLeft.size()==minQueueRight.size()){
                if (a[i]>=median) {
                    minQueueRight.add(a[i]);
                } else {
                    maxQueueLeft.add(a[i]);
                }

            } else if(maxQueueLeft.size()<minQueueRight.size()){
                if (a[i]>=median) {
                    minQueueRight.add(a[i]); //2 more on the right
                    maxQueueLeft.add(minQueueRight.poll()); //rebalance
                } else {
                    maxQueueLeft.add(a[i]);
                }
            }

            if(maxQueueLeft.size()>minQueueRight.size())
                median = maxQueueLeft.peek();
            else if(maxQueueLeft.size()==minQueueRight.size())
                //now size of 2 heap are the same
                median = (minQueueRight.peek() + maxQueueLeft.peek()) / 2.0f;
            else {
                median = minQueueRight.peek();
            }

            res[i]=median;
        }
        return res;
    }

    public float[] runningMedian2(int[] a)  {
        /*
         * Write your code here.
         */
        ArrayList<Integer> arrList = new ArrayList<>();
        MinHeap minHeapRight = new MinHeap(a.length);
        MaxHeap maxHeapLeft = new MaxHeap(a.length);
        float[] res = new float[a.length];
        float median = 0;
        for(int i=0;i<a.length;i++){
            try {
                if(maxHeapLeft.size()>minHeapRight.size()) {
                    if (a[i]>=median) {
                        minHeapRight.insertKey(a[i]);
                    } else {
                        minHeapRight.insertKey(maxHeapLeft.extractRoot());
                        maxHeapLeft.insertKey(a[i]);
                    }
                }
                else if(maxHeapLeft.size()==minHeapRight.size()){
                    if (a[i]>=median) {
                        minHeapRight.insertKey(a[i]);
                    } else {
                        maxHeapLeft.insertKey(a[i]);
                    }

                } else if(maxHeapLeft.size()<minHeapRight.size()){
                    if (a[i]>=median) {
                        minHeapRight.insertKey(a[i]); //2 more on the right
                        maxHeapLeft.insertKey(minHeapRight.extractRoot()); //rebalance
                    } else {
                        maxHeapLeft.insertKey(a[i]);
                    }
                }

                if(maxHeapLeft.size()>minHeapRight.size())
                    median = maxHeapLeft.getRoot();
                else if(maxHeapLeft.size()==minHeapRight.size())
                    //now size of 2 heap are the same
                    median = (minHeapRight.getRoot() + maxHeapLeft.getRoot()) / 2.0f;
                else {
                    median = minHeapRight.getRoot();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            res[i]=median;
        }
        return res;
    }
    static double getMedian(ArrayList<Integer> arr){
        if(arr.size()%2==0){
            return (arr.get(arr.size()/2) + arr.get(arr.size()/2-1))/2.0d;
        }
        return arr.get(arr.size()/2);
    }
    static void binaryInsert(ArrayList<Integer> arr, int val){
        int l = 0;
        int r=arr.size()-1;
        int m = (l+r)/2;
        while(l<r){
            if(arr.get(m)>val)
                r=m;
            if(arr.get(m)<val)
                l=m;
        }
        //l is the position we need to insert
        arr.add(l,val);
    }

    public int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        ArrayList<Integer> count = new ArrayList<>();
        ArrayList<String> db = new ArrayList<>();

        for(String[] q:queries){
            if(q[0].equals("add"))
                db.add(q[1]);
            else{//search
                int c=0;
                for(String str:db){
                    String pat = "^"+q[1]+".*";

                    if(str.matches(pat))
                        c++;
                }
                count.add(c);

            }
        }
        int[] res = new int[count.size()];
        for(int i=0;i<count.size();i++)
            res[i] =  count.get(i);
        return  res;
    }

    public int chessKnight(String cell) {
        int[][] d={{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
        int move=0;
        for(int[] dr:d){
            String newCell = ""+(char)(cell.charAt(0)+dr[0])+(char)(cell.charAt(1)+dr[1]);
            System.out.println(newCell);
            if(isValid(newCell))
                move++;
        }

        return move;

    }

    boolean isValid(String cell){
        if(cell.charAt(0)<'a'||cell.charAt(0)>'h'
                ||cell.charAt(1)<'1'||cell.charAt(1)>'8')
            return false;
        return true;
    }

    public int[] treeBottom(String tree) {
        Node n = new Node(tree);
        int m = n.maxHeight();
        int[] res = n.getNodeSameHeight(m);
        return res;
    }

    class Node {
        int val;
        Node left;
        Node right;
        private int maxHeight;

        public int maxHeight(){
            maxHeight = 0;
            updateMaxHeightHelper(this,1);
            return maxHeight;
        }

        public int[] getNodeSameHeight(int height){
             ArrayList<Integer> arrayList = new ArrayList<>();
             getNodeSameHeightHelper(height,this,arrayList,1);
             int[] res = new int[arrayList.size()];
             int i=0;
             for(Integer integer:arrayList)
                 res[i++]=integer;
             return res;
        }

        void getNodeSameHeightHelper(int height, Node n, ArrayList<Integer> arr, int soFar) {
            if(soFar==height) {
                arr.add(n.val);
                return;
            }

            if(n.left!=null)
                getNodeSameHeightHelper(height,n.left,arr ,soFar+1);
            if(n.right!=null)
                getNodeSameHeightHelper(height,n.right,arr ,soFar+1);
        }


        private void updateMaxHeightHelper(Node n, int sofar){
            if (maxHeight<sofar)
                maxHeight = sofar;
            if(n.left!=null)
                updateMaxHeightHelper(n.left,sofar+1);
            if(n.right!=null)
                updateMaxHeightHelper(n.right,sofar+1);

        }

        public Node(String tree){
            int[] stk = new int[tree.length()];
            int idx=-1;
            StringBuilder bld = new StringBuilder();
            int sIdx = tree.indexOf(' ',1);
            if(sIdx==-1)
                sIdx=tree.indexOf(')',1);
            val= Integer.parseInt(tree.substring(1,sIdx));
            int i=sIdx+1;
            for(;i<tree.length();i++){
                if(tree.charAt(i)=='(') {
                    stk[++idx] = i;
                } else if(tree.charAt(i)==')') {
                    if (idx == 0) {
                        String leftTree = tree.substring(stk[idx], i + 1);
                        if (leftTree.length() > 2)
                            left = new Node(leftTree);
                        break;
                    }
                    idx--;
                }
            }
            idx--;
            i++;
            for(;i<tree.length();i++){
                if(tree.charAt(i)=='(') {
                    stk[++idx] = i;
                } else if(tree.charAt(i)==')') {
                    if (idx == 0) {
                        String rightTree = tree.substring(stk[idx], i + 1);
                        if (rightTree.length() > 2)
                            right = new Node(rightTree);
                        break;
                    }
                    idx--;
                }
            }
        }
    }

    public int[] bankRequests(int[] accounts, String[] requests) {
        for(int i = 0 ; i < requests.length ; i++){
            String[] cmd = requests[i].split(" ");
            int acc = Integer.parseInt(cmd[1]);
            int sum = 0;
            switch(cmd[0]){
                case "withdraw":
                    sum = Integer.parseInt(cmd[2]);
                    if(accounts[acc-1]<sum)
                        return new int[]{i+1};
                    else
                        accounts[acc-1]-=sum;
                    break;
                case "deposit":
                    sum = Integer.parseInt(cmd[2]);
                    accounts[acc-1]+=sum;
                    break;
                case "transfer":
                    int dstAcc = Integer.parseInt(cmd[2]);
                    sum = Integer.parseInt(cmd[3]);
                    if(accounts[acc-1]<sum)
                        return new int[]{i+1};
                    else{
                        accounts[acc-1]-=sum;
                        accounts[dstAcc-1]+=sum;
                    }
                    break;
            }
        }
        return accounts;
    }

    public String[][] groupingDishes(String[][] dishes) {
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String[] dish:dishes){
            for(int i=1;i<dish.length;i++){
                if(!hm.containsKey(dish[i]))
                    hm.put(dish[i],new ArrayList<String>());
                List<String> lst = hm.get(dish[i]);
                lst.add(dish[0]);

            }
        }

        List<Map.Entry<String,List<String>>> lstEntry= hm.entrySet().stream().sorted((e1, e2)->{
            return  e1.getKey().compareTo(e2.getKey());
        }).filter(en->en.getValue().size()>1).collect(Collectors.toList());
//        lstEntry=lstEntry.stream().filter(en->en.getValue().size()>1).collect(Collectors.toList());
        String[][] res = new String[lstEntry.size()][];
        int i=0;
        for(Map.Entry<String,List<String>> entry:lstEntry){
            List<String> dishList = entry.getValue();
            res[i]=new String[dishList.size()+1];
            res[i][0] = entry.getKey();
            dishList.sort((d1,d2)->{
                return d1.compareTo(d2);
            });

            for(int j=0; j<dishList.size();j++){
                res[i][j+1]=dishList.get(j);
            }
            i++;
        }
        return res;
    }


    /*Generate all subset of a set
    * */
    public void swap(Integer n1, Integer n2){
        n1=n1+n2;
        n2=n1-n2;
        n1=n1-n2;
    }
    public void swap(int n1, int n2){
        n1=n1+n2;
        n2=n1-n2;
        n1=n1-n2;
    }

    public int[][] generateSubsets(int[] set){
        ArrayList<int[]> result = new ArrayList<>();
        boolean[] chosen = new boolean[set.length];
        generateSubsetsHelper(set, chosen,0,result);
        int[][] res= new int[result.size()][];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }

    private void indent(int n){
        for(int i=0;i<n;i++)
            System.out.print("...");
    }
    private void generateSubsetsHelper(int[] set, boolean[] chosen, int choiceSoFar, ArrayList<int[]> res){
        indent(choiceSoFar+1);
        System.out.println("Choice so far "+choiceSoFar +" "+Arrays.toString(chosen));
        if(choiceSoFar>=set.length){//don't need to choose anymore
            ArrayList<Integer> lst  = new ArrayList<>();
            for(int i=0;i<set.length;i++){
                if(chosen[i]){
                    lst.add(set[i]);
                }
            }
            int[] result = new int[lst.size()];
            for (int i=0;i<lst.size();i++)
                result[i]=lst.get(i);
            System.out.println(Arrays.toString(result));
            res.add(result);
        }

        for(int i=choiceSoFar;i<set.length;i++){
            //choose choice
            chosen[i]=false;
            //explore
            generateSubsetsHelper(set,chosen,choiceSoFar+1,res);
            //unchoose choice
            chosen[i]=true;
            generateSubsetsHelper(set,chosen,choiceSoFar+1,res);
        }
    }

}
