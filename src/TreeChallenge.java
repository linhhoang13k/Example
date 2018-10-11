package CodeFight;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by tranpham on 4/13/18.
 */
public class TreeChallenge {

    Tree<Integer> treeHead;
    public void tree2Dll(Tree<Integer> root){
        //traverse right to left
        if(root==null)
            return;
        tree2Dll(root.right);
        root.right=treeHead;
        if(treeHead!=null)
            treeHead.left=root;
        treeHead = root;
        tree2Dll(root.left);
    }

    public int getTreeDiameter(Tree<Integer> root){
        if (root==null)
            return 0;
        int leftD = getTreeDiameter(root.left);
        int rightD = getTreeDiameter(root.right);
        int leftH = getTreeHeight(root.left);
        int rightH = getTreeHeight(root.right);
        int diameterOverRoot = leftH + rightH +1;
        return Math.max(diameterOverRoot,Math.max(leftD,rightD));
    }

    public int getTreeHeight(Tree<Integer> root){
        int[] maxHeight = {-1};
        getTreeHeightHelper(root,1,maxHeight);
        return maxHeight[0];
    }

    public void getTreeHeightHelper(Tree<Integer> root, int heightSoFar, int[] maxHeight){
        if (root==null){
            if(heightSoFar-1>maxHeight[0])
                maxHeight[0] = heightSoFar-1;
            return;
        }
        getTreeHeightHelper(root.left,heightSoFar+1,maxHeight);
        getTreeHeightHelper(root.right,heightSoFar+1,maxHeight);
    }
    public Tree<Integer> tree2DllHelper(Tree<Integer> root){
        System.out.println("tree2DllHelper("+root.value+")");
        if (root.left==null && root.right==null){
            return root;
        }
        if(root.left!=null){
            Tree<Integer> leftNode = tree2DllHelper(root.left);
            leftNode.right = root;
            root.left = leftNode;
        }
        if(root.right!=null){
            Tree<Integer> rightNode = tree2DllHelper(root.right);
            rightNode.left = root;
            root.right = rightNode;
            return rightNode;
        }

        return root;
    }
    public Integer lowestCommonAncestor(Tree<Integer> root, Integer a, Integer b){
        String[] pathToN1 = {""};
        String[] pathToN2 = {""};
        boolean isFound1= findPath(root,a,"",pathToN1);
        boolean isFound2= findPath(root,b,"",pathToN2);
        if(!isFound1 || !isFound2)
            return -1;
        pathToN1 = pathToN1[0].split("->");
        pathToN2 = pathToN2[0].split("->");
        int i=0;
        for(;i<pathToN1.length;i++)
            if(!pathToN1[i].equals(pathToN2[i]))
                break;

        return Integer.parseInt(pathToN1[i-1]);
    }
    public boolean findPath(Tree<Integer> root, Integer n, String pathSoFar, String[] res){
        if(root==null)
            return false;
        pathSoFar+="->"+root.value;
        if(root.value.equals(n)){
            res[0]=pathSoFar;
            return true;
        }

        return findPath(root.left,n,pathSoFar,res)||findPath(root.right,n,pathSoFar,res);
    }
    //TODO
    public String leftSideView(Tree<Integer> root){
        return "";
    }
    //TODO
    public String rightSideView(Tree<Integer> root){
        return "";
    }
    //TODO
    public String bottomView(Tree<Integer> root){
        return "";
    }

    public String topView(Tree<Integer> root){
        if(root==null)
            return "";
        StringBuilder res = new StringBuilder();
        HashMap<Integer,int[]> hm  = new HashMap<>();
        topViewHelper(root,0, 1, hm);
        //sort hm by value of key
        List<Map.Entry<Integer,int[]>> lstEntry = hm.entrySet().stream().sorted((e1, e2)->{
            return e1.getKey()-e2.getKey();
        }).collect(Collectors.toList());
        for(Map.Entry<Integer,int[]> entry:lstEntry){
            res.append("->"+entry.getValue()[1]);
        }
        return res.toString();
    }

    void topViewHelper(Tree<Integer> root, int vLevel, int hLevel, HashMap<Integer,int[]> hm) {
        if (root == null)
            return;
        topViewHelper(root.left, vLevel - 1,hLevel+1, hm);
        if (!hm.containsKey(vLevel))
            hm.put(vLevel, new int[]{Integer.MAX_VALUE,0});
        int[] node = hm.get(vLevel);
        if (node[0] > hLevel){//replace by node with lower high
            node[0] = hLevel;
            node[1] = root.value;
        }
        topViewHelper(root.right,vLevel+1,hLevel+1,hm);
    }

    public String verticalTraverse(Tree<Integer> root){
        StringBuilder res = new StringBuilder();
        Map<Integer,List<Integer>> hm = new HashMap<>();

        verticalTraverseHelper(root,0,hm);
        //sort hm by value of key
        List<Map.Entry<Integer,List<Integer>>> lstEntry = hm.entrySet().stream().sorted((e1, e2)->{
            return e1.getKey()-e2.getKey();
        }).collect(Collectors.toList());
        for(Map.Entry<Integer,List<Integer>> entry:lstEntry){
            res.append(Arrays.toString(entry.getValue().toArray())+"\n");
        }
        return res.toString();
    }

    void verticalTraverseHelper(Tree<Integer> root, int level, Map<Integer,List<Integer>> hm){
        if(root==null)
            return;
        verticalTraverseHelper(root.left,level-1,hm);
        if(!hm.containsKey(level))
            hm.put(level,new LinkedList<Integer>());
        List<Integer> lst = hm.get(level);
        lst.add(root.value);
        verticalTraverseHelper(root.right,level+1,hm);
    }
    //another solution solved by tree traversal without building the tree
    public String findProfessionMath(int level, int pos){
        boolean isEng = findProf(level,true,pos);
        return  isEng?"Engineer":"Doctor";
    }
    boolean findProf(int level, boolean isEng, int pos){
        int half = (int)Math.pow(2,level-1);
        if(pos>half){//switch prof
            pos-=half;
            isEng=!isEng;
        }
        if(level==1)
            return isEng;
        return findProf(level-1,isEng,pos);
    }

    public String findProfession(int level, int pos) {
        if(level==1&&pos==1)
            return "Engineer";

        String decendents=generate(level-1,"E");
        if(decendents.charAt(pos-1)=='D')
            return "Doctor";
        return "Engineer";
    }

    String generate(int level, String str){
        if(level==0)
            return str;
        String thisLevel = str+inverse(str);
        return generate(level-1,thisLevel);
    }

    String inverse(String str){
        StringBuilder bd = new StringBuilder();
        for(char c:str.toCharArray()){
            if(c=='E')
                bd.append('D');
            else
                bd.append('E');
        }
        return bd.toString();
    }

    public boolean isSymmetric(Tree<Integer> root){
        if(root==null)
            return true;
        return isMirror(root.left,root.right);
    }

    boolean isMirror(Tree<Integer> left, Tree<Integer> right){
        if(left==null || right==null)
            return left==null && right == null;

        if(left.value.equals(right.value))
            return isMirror(left.left,right.right)&&isMirror(left.right,right.left);

        return false;
    }

    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {

        return false;
    }

    public Tree<Integer> readJsonFile(String filePath){
        Tree<Integer> root = new Tree<>();
        try{
            JSONParser parser = new JSONParser();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            JSONObject jsonObj = (JSONObject)parser.parse(fileReader);
            root = parseJson(jsonObj);
        } catch (Exception ex){
            System.out.printf("Error occur:%s",ex.getMessage());
        }
        return root;
    }

    Tree<Integer> parseJson(JSONObject jsonObj){
        if(jsonObj==null)
            return null;
        Tree<Integer> root = new Tree<>();
        root.value = (int)((long)jsonObj.get("value"));
        root.left = parseJson((JSONObject)jsonObj.get("left"));
        root.right = parseJson((JSONObject)jsonObj.get("right"));
        return root;
    }

    public Tree<Integer> createSampleTree(){
        Tree<Integer> root = new Tree<>(8);
        root.left = new Tree<>(4);
        root.left.left=new Tree<>(2);
        root.left.left.left=new Tree<>(1);
        root.left.left.right=new Tree<>(3);
        root.left.right=new Tree<>(6);
        root.left.right.left=new Tree<>(5);
        root.left.right.right=new Tree<>(7);
        root.right = new Tree<>(12);
        root.right.left=new Tree<>(10);
        root.right.left.left=new Tree<>(9);
        root.right.left.right=new Tree<>(11);
        root.right.right=new Tree<>(14);
        root.right.right.left=new Tree<>(13);
        root.right.right.right=new Tree<>(15);
        return root;
    }

    public String inOrderTraverse(Tree<Integer> root){
        if (root==null)
            return "";
        return inOrderTraverse(root.left)+" "+root.value+" "+inOrderTraverse(root.right);
    }

    public String preOrderTraverse(Tree<Integer> root){
        if (root==null)
            return "";
        return root.value+" "+ preOrderTraverse(root.left)+" "+preOrderTraverse(root.right);
    }

    public String postOrderTraverse(Tree<Integer> root){
        if (root==null)
            return "";
        return postOrderTraverse(root.left)+" "+postOrderTraverse(root.right)+" "+root.value;
    }

    public int[] levelTraverse(Tree<Integer> root){
        List<Integer> lst = new LinkedList<>();

        int[] res = new int[lst.size()];
        return res;
    }
}
