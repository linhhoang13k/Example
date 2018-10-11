import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class MinDistance {
    public static void main(String[] args) {
        String sentence = "dog cat hello cat dog dog hello cat world";
        String[] words = {"hello", "world"};

        System.out.println(getMinDistance(sentence, words));
    }

    @AllArgsConstructor
    static class Location {
        @Getter @Setter String word;
        @Getter @Setter int location;
    }

    private static int getMinDistance(String all, String[] words) {
        List<Location> locations = new ArrayList<>();

        String[] parts = all.split(" ");

        for (int i = 0; i < parts.length; i++) {
            if(parts[i].equals(words[0])) {
                locations.add(new Location(words[0], i));
            } else if(parts[i].equals(words[1])) {
                locations.add(new Location(words[1], i));
            }
        }

        int[] smallestGap = {0, Integer.MAX_VALUE};

        for(int i = 1; i < locations.size(); i++) {
            Location init = locations.get(i - 1);
            Location next = locations.get(i);

            if(!init.word.equals(next.word) &&
                    next.location - init.location < smallestGap[1] - smallestGap[0]){
                smallestGap[0] = init.location;
                smallestGap[1] = next.location;
            }

        }

        return Math.abs(smallestGap[1] - smallestGap[0]);
    }
}

