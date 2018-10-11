package InterviewPractice;

public class Arrays {
    int firstDuplicate(int[] a) {
        int dupeNumber = -1;
        for (int number : a) {
            for (int i = 0; i < a.length; i++) {
               if (a[i] == number) dupeNumber = a[i];
            }
        }
        return dupeNumber;
    }
}
