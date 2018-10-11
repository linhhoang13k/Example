package boot.kik;

import java.util.*;

/**
 * Created by JavierSainz on 1/22/17.
 */
public class SpamDetection {
    String[] spamDetection(String[][] messages, String[] spamSignals) {
        String[] rules = new String[4];
        Arrays.fill(rules, "passed");
        int wordsLengthRuleFailed = 0;
        double totalMessages = messages.length;
        HashMap<String, HashMap<String, Integer>> repeatedMessages = new HashMap<>();
        HashMap<String, Integer> messagesCountToEachRecipient = new HashMap<>();
        HashMap<String, Integer> messagesCount = new HashMap<>();

        HashSet<String> spamSignalsFound = new HashSet<>();
        TreeSet<Integer> wordsWithSpamSignal = new TreeSet<>();

        for (int i = 0; i < totalMessages; i++) {
            String message = messages[i][0];
            String recipient = messages[i][1];
            String[] words = messages[i][0].split("([\\W]+)");
            HashMap<String, Integer> messagesToRecipient = repeatedMessages.get(recipient);
            if (messagesToRecipient == null) {
                messagesToRecipient = new HashMap<>();
            }
            Integer messageCountToRecipient = messagesToRecipient.get(message);
            if (messageCountToRecipient == null) {
                messageCountToRecipient = 0;
            }
            messagesToRecipient.put(message, ++messageCountToRecipient);
            repeatedMessages.put(recipient, messagesToRecipient);
            Integer messageCount = messagesCount.get(message);
            if (messageCount == null) {
                messageCount = 0;
            }
            messagesCount.put(message, ++messageCount);
            Integer totalMessageCount = messagesCountToEachRecipient.get(recipient);
            if (totalMessageCount == null) {
                totalMessageCount = 0;
            }
            messagesCountToEachRecipient.put(recipient, ++totalMessageCount);
            if (words.length < 5) {
                wordsLengthRuleFailed++;
            }

            for (String signal : spamSignals) {
                signalLoop:
                for (String word : words) {
                    if (signal.equalsIgnoreCase(word)) {
                        spamSignalsFound.add(signal);
                        wordsWithSpamSignal.add(i);
                        break signalLoop;
                    }
                }
            }
        }

        if (wordsLengthRuleFailed / totalMessages > 0.9) {
            int gcd = gcd((int) totalMessages, wordsLengthRuleFailed);
            rules[0] = "failed: " + (wordsLengthRuleFailed / gcd) + "/" + (int) (totalMessages / gcd);
        }

        TreeSet<String> secondRuleFailed = new TreeSet<>();
        for (Map.Entry<String, HashMap<String, Integer>> entry : repeatedMessages.entrySet()) {
            String recipient = entry.getKey();
            double totalMessagesToRecipient = messagesCountToEachRecipient.get(recipient);
            if (totalMessagesToRecipient > 1) {
                for (Map.Entry<String, Integer> messagesToRecipient : entry.getValue().entrySet()) {
                    if (totalMessagesToRecipient > 1 && messagesToRecipient.getValue() / totalMessagesToRecipient > 0.5) {
                        secondRuleFailed.add(recipient);
                    }
                }
            }
        }
        if (!secondRuleFailed.isEmpty()) {
            rules[1] = "failed: " + String.join(" ", secondRuleFailed);
        }

        for (Map.Entry<String, Integer> messageEntry : messagesCount.entrySet()) {
            if (totalMessages > 1 && messageEntry.getValue() / totalMessages > 0.5) {
                rules[2] = "failed: " + messageEntry.getKey();
                break;
            }
        }

        if (wordsWithSpamSignal.size() / totalMessages > 0.5) {
            rules[3] = "failed: " + String.join(" ", spamSignalsFound);
        }

        return rules;
    }

    int gcd(int a, int b) {
        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SpamDetection().spamDetection(
                new String[][]{{"Check Codefights out", "7284736"},
                        {"Check Codefights out", "7462832"},
                        {"Check Codefights out", "3625374"},
                        {"Check Codefights out", "7264762"}}
                , new String[]{"sale",
                        "discount",
                        "offer"}
        )));

        System.out.println(Arrays.toString(new SpamDetection().spamDetection(
                new String[][]{{"a", "1"}}
                , new String[]{"b"}
        )));
    }
}
