package edu.learning.codefights.tree;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * Created by duchuunguyen on 9/15/17.
 */
public class IsSubTrue {
    public static boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        //List<Integer> bst1 = bst(t1);
        List<Integer> bst2 = bst(t2);
        if (bst2.isEmpty())
            return true;

        Queue<Tree<Integer>> queue = new LinkedList<>();
        queue.add(t1);

        while (!queue.isEmpty()) {
            Tree<Integer> t = queue.remove();
            if (t != null) {
                if (t.value.equals(t2.value)) {
                    List<Integer> bst = bst(t);
                    boolean isSub = Collections.indexOfSubList(bst, bst2) > -1;
                    if (isSub)
                        return true;
                }
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return false;
    }

    public static List<Integer> bst(Tree<Integer> tree) {
        if (tree == null)
            return new ArrayList<>();
        Queue<Tree<Integer>> queue = new LinkedList<>();
        queue.add(tree);
        List<Integer> values = new ArrayList<>();

        while (!queue.isEmpty()) {
            Tree<Integer> t = queue.remove();
            if (t != null) {
                queue.add(t.left);
                queue.add(t.right);
            }
            values.add(t != null ? t.value : null);
        }
        return values;
    }

    public static void main(String[] args) throws IOException {
        String tree1Str = "{\n" +
                "    \"value\": 5,\n" +
                "    \"left\": {\n" +
                "        \"value\": 10,\n" +
                "        \"left\": {\n" +
                "            \"value\": 4,\n" +
                "            \"left\": {\n" +
                "                \"value\": 1,\n" +
                "                \"left\": null,\n" +
                "                \"right\": null\n" +
                "            },\n" +
                "            \"right\": {\n" +
                "                \"value\": 2,\n" +
                "                \"left\": null,\n" +
                "                \"right\": null\n" +
                "            }\n" +
                "        },\n" +
                "        \"right\": {\n" +
                "            \"value\": 6,\n" +
                "            \"left\": null,\n" +
                "            \"right\": {\n" +
                "                \"value\": -1,\n" +
                "                \"left\": null,\n" +
                "                \"right\": null\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"right\": {\n" +
                "        \"value\": 7,\n" +
                "        \"left\": null,\n" +
                "        \"right\": null\n" +
                "    }\n" +
                "}";
        String tree2Str = "{\n" +
                "    \"value\": 10,\n" +
                "    \"left\": {\n" +
                "        \"value\": 4,\n" +
                "        \"left\": {\n" +
                "            \"value\": 1,\n" +
                "            \"left\": null,\n" +
                "            \"right\": null\n" +
                "        },\n" +
                "        \"right\": {\n" +
                "            \"value\": 2,\n" +
                "            \"left\": null,\n" +
                "            \"right\": null\n" +
                "        }\n" +
                "    },\n" +
                "    \"right\": {\n" +
                "        \"value\": 6,\n" +
                "        \"left\": null,\n" +
                "        \"right\": {\n" +
                "            \"value\": -1,\n" +
                "            \"left\": null,\n" +
                "            \"right\": null\n" +
                "        }\n" +
                "    }\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        Tree<Integer> tree1 = mapper.readValue(tree1Str, Tree.class);
        Tree<Integer> tree2 = mapper.readValue(tree2Str, Tree.class);
        System.out.println(isSubtree(tree1, tree2));
    }
}
