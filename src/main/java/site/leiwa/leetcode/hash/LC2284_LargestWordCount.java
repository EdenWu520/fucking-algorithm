package site.leiwa.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @desc: todo
 *
 * @see <a href="https://leetcode.cn/problems/sender-with-largest-word-count/">最多单词数的发件人</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/11
 */
public class LC2284_LargestWordCount {

    public static void main(String[] args) {
        System.out.println(new LC2284_LargestWordCount().largestWordCount(new String[] {"is is", "is", "I am"},
            new String[] {"Alice", "Alice", "userTwo"}));
    }

    static class Message implements Comparable<Message> {
        String name;
        List<String> msg = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Message message = (Message)o;
            return name.equals(message.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public int compareTo(Message o) {
            if (o.msg.size() - this.msg.size() == 0) {
                return o.name.compareTo(this.name);
            }
            return o.msg.size() - this.msg.size();
        }
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Message> map = new HashMap<>();

        for (int i = 0; i < messages.length; i++) {
            String name = senders[i];
            if (map.containsKey(name)) {
                Message message = map.get(name);
                message.msg.addAll(Arrays.stream(messages[i].split(" ")).collect(Collectors.toList()));
            } else {
                Message message = new Message();
                message.name = name;
                message.msg.addAll(Arrays.stream(messages[i].split(" ")).collect(Collectors.toList()));
                map.put(senders[i], message);
            }
        }

        Optional<Message> first = map.values().stream().sorted().findFirst();
        return first.get().name;
    }
}

// [
//
// "Yf yo n V U Za f np",
// "j J sk f qr e v t",
//
// "gp No g s VR",
//
// "ZS H Bi De dj dsh",
// "ep MA KI Q Ou"
// ]
//
// [
// "FnZd",
// "FnZd",
//
// "EMoUs",
//
// "EMoUs",
// "EMoUs"
// ]