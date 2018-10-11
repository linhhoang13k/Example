package CodeFight;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 4/13/18.
 */
public class TreeChallengeTest {
    @Test
    public void lowestCommonAncestor() throws Exception {
        Tree<Integer> root = treeChallenge.readJsonFile(System.getProperty("user.dir")+"/src/main/resources/tree2.json");
        Integer actual = treeChallenge.lowestCommonAncestor(root,305,470);
        Assert.assertEquals(159,actual.intValue());

    }

    @Test
    public void topView() throws Exception {
        Tree<Integer> root = treeChallenge.readJsonFile(System.getProperty("user.dir")+"/src/main/resources/tree1.json");
        String res = treeChallenge.topView(root);
        System.out.print(res);
    }

    @Test
    public void readJsonFile() throws Exception {
    }

    @Test
    public void parseJson() throws Exception {
    }

    @Test
    public void createSampleTree() throws Exception {
    }

    @Test
    public void verticalTraverse() throws Exception {
        String projectPath= System.getProperty("user.dir");
        Tree<Integer> root= treeChallenge.readJsonFile(projectPath+"/src/main/resources/tree1.json");
        String res =  treeChallenge.verticalTraverse(root);
        System.out.print(res);
    }

    @Test
    public void findProfessionMath() throws Exception {
        Assert.assertEquals(treeChallenge.findProfession(4,6),"Engineer");
    }

    @Test
    public void levelTraverse() throws Exception {
    }

    @Test
    public void findProfession() throws Exception {
        Assert.assertEquals(treeChallenge.findProfession(3,3),"Doctor");
    }

    @Test
    public void generate() throws Exception {

    }

    @Test
    public void isSymmetric() throws Exception {
        Tree<Integer> root= treeChallenge.readJsonFile("/Users/tranpham/Documents/Project/DesignPattern/src/main/resources/tree1.json");
        Assert.assertTrue(treeChallenge.isSymmetric(root));

    }

    TreeChallenge treeChallenge = new TreeChallenge();

    @Test
    public void preOrderTraverse() throws Exception {
        Tree<Integer> root = treeChallenge.createSampleTree();
        String actual = treeChallenge.preOrderTraverse(root);

    }

    @Test
    public void postOrderTraverse() throws Exception {
        Tree<Integer> root = treeChallenge.createSampleTree();
        String actual = treeChallenge.postOrderTraverse(root);
    }

    @Test
    public void inOrderTraverse() throws Exception {
        Tree<Integer> root = treeChallenge.createSampleTree();
        String actual = treeChallenge.inOrderTraverse(root);
    }

    @Test
    public void hasPathWithGivenSum() throws Exception {

    }

    @Test
    public void tree2Dll() {
        Tree<Integer> root = treeChallenge.readJsonFile(System.getProperty("user.dir")+"/src/main/resources/tree1.json");
        treeChallenge.tree2Dll(root);
        Tree<Integer> dList = treeChallenge.treeHead;
        while (dList!=null){
            System.out.print("->" + dList.value);
            dList=dList.right;
        }
    }

    @Test
    public void tree2Dllfail() {
        Tree<Integer> root = treeChallenge.readJsonFile(System.getProperty("user.dir")+"/src/main/resources/tree1.json");
        Tree<Integer> dList =treeChallenge.tree2DllHelper(root);

        while (dList!=null){
            System.out.print("->" + dList.value);
            dList=dList.left;
        }
    }

    @Test
    public void getTreeHeight() {
        Tree<Integer> root = treeChallenge.readJsonFile(System.getProperty("user.dir")+"/src/main/resources/tree1.json");
        int height= treeChallenge.getTreeHeight(root);
        Assert.assertEquals(height,5);
    }

    @Test
    public void getTreeDiameter() {
        Tree<Integer> root = treeChallenge.readJsonFile(System.getProperty("user.dir")+"/src/main/resources/tree1.json");
        int diameter= treeChallenge.getTreeDiameter(root);
        Assert.assertEquals(11, diameter);

    }

    @Test
    public void getTreeHeightHelper() {
    }

    @Test
    public void tree2DllHelper() {
    }

    @Test
    public void findPath() {
    }

    @Test
    public void leftSideView() {
    }

    @Test
    public void rightSideView() {
    }

    @Test
    public void bottomView() {
    }

    @Test
    public void topViewHelper() {
    }

    @Test
    public void verticalTraverseHelper() {
    }

    @Test
    public void findProf() {
    }

    @Test
    public void inverse() {
    }

    @Test
    public void isMirror() {
    }
}