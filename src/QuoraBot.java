package CodeFight;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tranpham on 3/12/18.
 */
public class QuoraBot {

    int[][][] mostViewedWriters(int[][] topicIds, int[][] answerIds, int[][] views) {
        int[][][] res;
        HashMap<Integer,List<Integer>> hm_tp = new HashMap<Integer,List<Integer>>();
        //create hashMap<Topic,List<AnswerId>>
        for(int row_t=0;row_t<topicIds.length;row_t++){
            for(int col_t=0;col_t<topicIds[row_t].length;col_t++) {
                if (!hm_tp.containsKey(topicIds[row_t][col_t]))
                    hm_tp.put(topicIds[row_t][col_t], new ArrayList());
                List<Integer> lst = hm_tp.get(topicIds[row_t][col_t]);
                for (int col_a = 0; col_a < answerIds[row_t].length; col_a++) {
                    lst.add(answerIds[row_t][col_a]);
                }
            }
        }
        res = new int[hm_tp.size()][][];
        int idx=0;
        List<Integer> sortedKeySet= hm_tp.keySet().stream().sorted().collect(Collectors.toList());
            for(Integer tid:sortedKeySet){
            List<Integer> ansList = hm_tp.get(tid);
            HashMap<Integer,Integer> hm_view = new HashMap<>();
            for(Integer ansId:ansList){
                for(int[] view:views){
                    if(view[0]==ansId){
                        if(!hm_view.containsKey(view[1]))
                            hm_view.put(view[1],0);
                        hm_view.put(view[1],hm_view.get(view[1])+view[2]);
                    }
                }
            }
            //sort by view count of each user
            //
            List<Map.Entry<Integer,Integer>> sortedList= hm_view.entrySet().stream().sorted((o2, o1) -> {
                if(o1.getValue()<o2.getValue()){
                    return -1;
                }
                else if(o1.getValue()==o2.getValue()){
                    if(o1.getKey()<o2.getKey()){
                        return 1;
                    } else if(o1.getKey()==o2.getKey()){
                        return 0;
                    } else {
                        return -1;
                    }
                }else {
                    return 1;
                }
            }).collect(Collectors.toList());
            int max_usr = Math.min(10,sortedList.size());
    //            res[tid] = new int[max_usr][2];
            res[idx] = new int[max_usr][2];
            for(int i=0;i<max_usr;i++){
                Map.Entry<Integer,Integer> entry=sortedList.get(i);
                res[idx][i][0]=entry.getKey();
                res[idx][i][1]=entry.getValue();
            }
            idx++;
        }
        return res;
    }

    public int relatedQuestions(int n, int[] t, int[][] edges){

        int idx=0;
        float[] weight = new float[t.length];
        for(int[] arr:edges){
            weight[arr[0]]+=1+1.0/t[arr[0]];
            weight[arr[1]]+=1+1.0/t[arr[1]];
        };

        float preVal=1000000;
        float currVal=1001;
        while (currVal<preVal){
            preVal=currVal;
            float maxWeigh = 0;
            int bestIdx=-1;
            for(int i =0;i<weight.length;i++){
                if(weight[i]>maxWeigh){
                    maxWeigh = weight[i];
                    bestIdx = i;
                }
            }
            if(bestIdx!=-1){
                weight[bestIdx]=-1;
                int[] traversed = new int[edges.length];
                currVal=getTotalFromBook(bestIdx,t, edges,traversed);
                if (currVal<preVal){
                    idx = bestIdx;
                }
            }
        }
        return idx;
    }

    public float getTotalFromBook(int bookId, int[] arrTime,int[][] edges, int[] traversed){
        int count=0;
        float total=0;
        for(int i=0;i<edges.length ;i++){
            if(traversed[i]!=1){
                int[] arr=edges[i];
                if(arr[0]==bookId || arr[1]==bookId){
                    count++;
                    int recurs_idx=  arr[0]+ arr[1] - bookId;
                    traversed[i]=1;
                    total+=getTotalFromBook(recurs_idx,arrTime,edges,traversed);
                }
            }
        }
        return arrTime[bookId]+(count>0?total/count:0);
    }
}
