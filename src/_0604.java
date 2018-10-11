package me.cwuyi;

import java.util.*;

/**
 * Created by xyy on 2017/6/4.
 */
public class _0604 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if (n <= 0) return true;
            if (flowerbed[i] != 1) {
                if (i > 0 && i < flowerbed.length-1) {
                    if (flowerbed[i-1] != 1 && flowerbed[i+1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else if (i == 0) {
                    if (flowerbed.length != 1 && flowerbed[i+1] == 1) {
                        continue;
                    }
                    flowerbed[i] = 1;
                    n--;
                } else if (i == flowerbed.length-1) {
                    if (flowerbed.length > 1 && flowerbed[i-1] == 1) {
                        continue;
                    }
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        if(n <= 0) {
            return true;
        }

        return false;
    }

    public static String tree2str(TreeNode t) {
        if (t == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(t.val);

        if (t.left == null && t.right != null) {
            sb.append("()" + "(" + tree2str(t.right) + ")");
        } else if (t.left != null && t.right == null) {
            sb.append("(" + tree2str(t.left) + ")");
        } else if (t.left != null && t.right != null) {
            sb.append("(" + tree2str(t.left) + ")");
            sb.append("(" + tree2str(t.right) + ")");
        }
        return sb.toString();
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < paths.length; i++) {
            String path = paths[i];
            String[] item = path.split(" ");
            for(int j = 1; j < item.length; j++) {
                String file = item[j];
                String fileContent = file.substring(file.indexOf("("), file.length());
                if (map.containsKey(fileContent)) {
                    map.get(fileContent).add(item[0] + "/" + file.substring(0, file.indexOf("(")));
                }
                else {
                    List<String> list = new ArrayList<>();
                    list.add(item[0] + "/" + file.substring(0, file.indexOf("(")));
                    map.put(fileContent, list);
                }
            }
        }

        List<List<String>> ret = new ArrayList<>();
        Set entrys = map.entrySet();

        for(Iterator<Map.Entry<String, List>> iter = entrys.iterator(); iter.hasNext();) {
            List value = iter.next().getValue();
            if(value.size() > 1) {
                ret.add(iter.next().getValue());
            }
        }

        return ret;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
