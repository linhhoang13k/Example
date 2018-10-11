
public class MergeSortedLinkedLists {
    public static List mergeLists(List[] lists) throws Exception {
        List returnList = new List();

        while(!allListsEmpty(lists)) {
            Node lowest = lists[0].head;
            int index = 0;

            for (int i = 0; i < lists.length; i++) {
                List list = lists[i];

                if (list.head != null && (int) list.head.getData() < (int) lowest.getData()) {
                    lowest = list.head;
                    index = i;
                }
            }

            returnList.addNode(new Node(lists[index].head.getData()));
            lists[index].removeHead();
        }

        return returnList;
    }

    private static boolean allListsEmpty(List[] lists) {
        for(List list : lists) {
            if(list.head != null) {
                return false;
            }
        }

        return true;
    }

}
