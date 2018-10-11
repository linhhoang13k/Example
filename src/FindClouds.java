package interviewpractice.heapsStacksQueues;

/**
 * @author benmakusha
 */
public class FindClouds {

    int countClouds(char[][] skyMap) {
        if (skyMap == null || skyMap.length == 0 || skyMap[0].length ==0)
            return 0;

        int m = skyMap.length;
        int n = skyMap[0].length;

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (skyMap[i][j] == '1') {
                    result++;
                    findClouds(skyMap, i , j);
                }
            }
        }
        return result;
    }

    void findClouds(char[][] skyMap, int i, int j) {
        int m = skyMap.length;
        int n = skyMap[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || skyMap[i][j] != '1')
            return;

        skyMap[i][j] = 'X';

        findClouds(skyMap, i - 1, j);
        findClouds(skyMap, i + 1, j);
        findClouds(skyMap, i, j - 1);
        findClouds(skyMap, i, j + 1);
    }

}
