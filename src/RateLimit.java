package boot.kik;

import java.util.*;

/**
 * Created by JavierSainz on 1/22/17.
 * Your company decides to give Kik a try and write a chat bot to be used on the platform. You've worked hard and it's almost finished, and all that's left to do now is test it. One of the things you want to check is whether the number of messages your bot sends exceeds the per user rate limit.
 * <p>
 * The purpose of the per user rate limit is to prevent bots from sending an excessively high number of messages to individual users every day. This limit is defined on a per-user basis: at midnight each day (00:00 in local server time, which also happens to be Coordinated Universal Time) the baseline limit is reset to startingAllowance. Once your bot sends a message to a given user that day, the per user rate limit (for that user) is decreased by 1. Whenever a user messages the bot, the per user rate limit increases by 1 (for that user). If at some point your bot tries to send a message to a user whose current per user rate limit equals 0, the sending fails.
 * <p>
 * Importantly, the rate limit is applied to batches of messages sent to multiple users. For example, if a batch of 25 messages is sent to various users, but the rate limit of at least one of them is 0, then the whole batch fails and no message is sent to any of the users.
 * <p>
 * You're given the logs of the sentBatches of messages your bot sent without setting the per user rate limit, and information about the receivedMessages. Which of the sent batches would fail if there was a per user rate limit with the initial value of startingAllowance?
 * <p>
 * Example
 * <p>
 * For
 * <p>
 * sentBatches = [[1471040000, 736273, 827482, 2738283],
 * [1471040005, 736273, 2738283],
 * [1471040010, 827482, 2738283],
 * [1471040015, 2738283],
 * [1471040025, 827482],
 * [1471046400, 736273, 827482, 2738283]]
 * receivedMessages = [[1471040001, 2738283],
 * [1471040002, 2738283],
 * [1471040010, 827482],
 * [1471040020, 2738283]]
 * and startingAllowance = 1, the output should be
 * <p>
 * rateLimit(sentBatches, receivedMessages, startingAllowance) = [1, 4].
 * <p>
 * Here is why:
 * <p>
 * There are 3 recipients: 736273, 827482, 2738283. The per user rate limit for each of them is initially startingAllowance = 1.
 * At 1471040000 the first batch of messages is sent to each of the recipients, their per user rate limit after that equals 0.
 * At 1471040001 the first message is received from 2738283, so their per user rate limit is now equal to 1.
 * At 1471040002 the second message from 2738283 is received, increasing their per user limit to 2.
 * At 1471040005 the second batch of messages is sent. However, the current per user limit of the recipient 736273 is 0, so no new messages can be sent. The sending of the entire batch is canceled.
 * At 1471040010 two events happen almost simultaneously:
 * The user 827482 sends a message, which increases their per user limit by 1 (it's 1 now).
 * The third batch is sent. Now, the recipients limits are 0, 0, 1, respectively.
 * At 1471040015 the fourth batch is successfully sent.
 * At 1471040020 user 2738283 sends another message making their per user limit equal to 1.
 * At 1471040025 the fifth batch is supposed to be sent. However, user 827482 has per user limit equal to 0, so the batch isn't sent.
 * At 1471046400 the per user limits of all users are set to startingAllowance again (it's 00:00 in local server time). Thus, the last batch is successfully sent.
 * So, batches 2 and 5 (1 and 4 0-based) aren't sent.
 * <p>
 * Input/Output
 * <p>
 * [time limit] 3000ms (java)
 * [input] array.array.integer sentBatches
 * <p>
 * Array representing the logs of sent batches of messages. Each batch is given in the following format: [<timestamp>, <recipient_1>, <recipient_2>, ...], where <timestamp> is the UNIX time of when the batch was sent, and <recipient_i> is the ID of the message recipient.
 * <p>
 * The batches are sorted in ascending order of their timestamps, and the recipients in each batch are sorted by their IDs in ascending order. It is guaranteed that the recipients of each batch are distinct.
 * <p>
 * If two consecutive batches have the same timestamps, assume that the one that appears in the array first was sent earlier.
 * If a batch is received at 00:00, assume that it happened after the per user rate limit was reset.
 * <p>
 * Constraints:
 * <p>
 * 0 ≤ sentBatches.length ≤ 100,
 * <p>
 * 2 ≤ sentBatches[i].length ≤ 100,
 * <p>
 * 1 ≤ sentBatches[i][j] ≤ 2 · 109.
 * <p>
 * [input] array.array.integer receivedMessages
 * <p>
 * Array representing the logs of received messages. Each message is given in the format [<timestamp>, <recipient>], where <timestamp> is the UNIX time of when the message was received, and <recipient> is the ID of the the recipient.
 * <p>
 * The messages are sorted in ascending order of their timestamps.
 * <p>
 * If two consecutive messages have the same timestamps, assume that the one that appears in the array first was received earlier. In case the timestamp of a sent batch coinQides with the timestamp of a received message, assume that the message was received earlier than the batch was sent.
 * <p>
 * If a message is received at 00:00, assume that it happened after the per user rate limit was reset.
 * <p>
 * Constraints:
 * <p>
 * 0 ≤ receivedMessages.length ≤ 100,
 * <p>
 * receivedMessages[i].length = 2,
 * <p>
 * 1 ≤ receivedMessages[i][j] ≤ 2 · 109.
 * <p>
 * [input] integer startingAllowance
 * <p>
 * The initial per user rate limit.
 * <p>
 * Constraints:
 * <p>
 * 1 ≤ startingAllowance ≤ 50.
 * <p>
 * [output] array.integer
 * <p>
 * The 0-based indices of batches that wouldn't be sent if the per user rate limit was applied.
 */
public class RateLimit {
    enum EventType {
        IN, OUT
    }

    class Event implements Comparable<Event> {
        Date occurredOn;
        EventType type;
        int[] recipients;
        int index;

        public Event(Date occurredOn, EventType type, int[] recipients, int index) {
            this.occurredOn = occurredOn;
            this.type = type;
            this.recipients = recipients;
            this.index = index;
        }

        public Date getOccurredOn() {
            return occurredOn;
        }

        public EventType getType() {
            return type;
        }

        public int[] getRecipients() {
            return recipients;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Event e) {
            if (occurredOn.before(e.getOccurredOn())) {
                return -1;
            } else if (occurredOn.equals(e.getOccurredOn())) {
                if (type != e.getType()) {
                    return type == EventType.IN ? -1 : 1;
                }
                return index < e.getIndex() ? -1 : 1;
            }
            return 1;
        }
    }

    int[] rateLimit(int[][] sentBatches, int[][] receivedMessages, int startingAllowance) {
        ArrayList<Event> events = new ArrayList<>(sentBatches.length + receivedMessages.length);
        addEvents(events, sentBatches, EventType.OUT);
        addEvents(events, receivedMessages, EventType.IN);
        HashMap<Integer, Integer> rateLimits = new HashMap<>();
        Collections.sort(events);
        Date previousEventDate = null;
        ArrayList<Integer> failedSentBatches = new ArrayList<>();
        for (Event e : events) {
            if (previousEventDate != null) {
                if (isANewDay(previousEventDate, e.getOccurredOn())) {
                    resetLimits(rateLimits, startingAllowance);
                }
            }
            if (e.getType() == EventType.OUT) {
                boolean wasSent = updateRateLimitsOutcommingMessages(e, rateLimits, startingAllowance);
                if (!wasSent) {
                    failedSentBatches.add(e.getIndex());
                }
            } else {
                updateRateLimitsIncommingMessages(e, rateLimits, startingAllowance);
            }
            previousEventDate = e.getOccurredOn();
        }
        return failedSentBatches.stream().mapToInt(i -> i).toArray();
    }

    boolean isANewDay(Date previousEventDate, Date newEventDate) {
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c1.setTime(previousEventDate);
        Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c2.setTime(newEventDate);
        return c1.get(Calendar.DATE) != c2.get(Calendar.DATE);
    }

    void resetLimits(HashMap<Integer, Integer> rateLimits, int startingAllowance) {
        for (Integer recipient : rateLimits.keySet()) {
            rateLimits.put(recipient, startingAllowance);
        }
    }

    boolean updateRateLimitsOutcommingMessages(Event e, HashMap<Integer, Integer> rateLimits, int startingAllowance) {
        for (int recipient : e.getRecipients()) {
            Integer rateLimit = rateLimits.get(recipient);
            if (rateLimit == null) {
                rateLimit = startingAllowance;
                rateLimits.put(recipient, rateLimit);
            }
            if (rateLimit == 0) {
                return false;
            }
        }
        for (int recipient : e.getRecipients()) {
            Integer rateLimit = rateLimits.get(recipient);
            rateLimits.put(recipient, --rateLimit);
        }
        return true;
    }

    void updateRateLimitsIncommingMessages(Event e, HashMap<Integer, Integer> rateLimits, int startingAllowance) {
        for (int recipient : e.getRecipients()) {
            Integer rateLimit = rateLimits.get(recipient);
            if (rateLimit == null) {
                rateLimit = startingAllowance;
            }
            rateLimits.put(recipient, ++rateLimit);
        }
    }

    void addEvents(ArrayList<Event> events, int[][] entries, EventType type) {
        for (int i = 0; i < entries.length; i++) {
            int[] entry = entries[i];
            Date date = new Date(entry[0] * 1000L);
            int[] recipients = new int[entry.length - 1];
            System.arraycopy(entry, 1, recipients, 0, recipients.length);
            events.add(new Event(date, type, recipients, i));
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RateLimit().rateLimit(
                new int[][]{{1471040000, 736273, 827482, 2738283},
                        {1471040005, 736273, 2738283},
                        {1471040010, 827482, 2738283},
                        {1471040015, 2738283},
                        {1471040025, 827482},
                        {1471046400, 736273, 827482, 2738283}},
                new int[][]{{1471040001, 2738283},
                        {1471040002, 2738283},
                        {1471040010, 827482},
                        {1471040020, 2738283}},
                1
        )));
    }
}
