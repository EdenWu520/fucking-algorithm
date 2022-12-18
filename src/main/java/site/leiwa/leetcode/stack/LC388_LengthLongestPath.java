package site.leiwa.leetcode.stack;

/**
 * @desc: todo
 *
 * @see <a href="https://leetcode.cn/problems/remove-comments/">删除注释</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/4
 */

import java.util.Stack;

public class LC388_LengthLongestPath {
    public static void main(String[] args) {
        String input = "a\n\tb\n\t\tc.txt\n\taaaa.txt";
        int maxLength = new LC388_LengthLongestPath().lengthLongestPath(input);
        System.out.println(maxLength);
    }

    public int lengthLongestPath(String input) {
        String[] split = input.split("\n");
        Stack<String> stack = new Stack<>();
        int ans = 0;
        // 记录当前目录的字符串长度
        int current = 0;
        // 上级目录长度
        int prev = 0;
        for (String s : split) {
            int leve = stack.size();
            File file = parseFileFromString(s);
            if (file.isDir) {
                if (leve == file.countTabs) { // 处理下级目录
                    // 压栈并记录当前目录长度
                    stack.push(file.name);
                    prev = current;
                    current += file.name.length();
                } else if (leve - 1 == file.countTabs) { // 处理平级目录
                    current -= stack.pop().length();
                    stack.push(file.name);
                    prev = current;
                    current += file.name.length();
                } else {
                    while (stack.size() != file.countTabs) {
                        current -= stack.pop().length();
                    }
                    // 压栈并记录当前目录长度
                    stack.push(file.name);
                    prev = current;
                    current += file.name.length();
                }
            }
            if (file.isFile) {
                int fileLength = 0;
                if (leve > file.countTabs) { // 文件为上级
                    while (stack.size() != file.countTabs) {
                        current = prev;
                        prev -= stack.pop().length();
                    }
                }
                leve = stack.size();
                if (leve - 1 == file.countTabs) { // 文件和目录平级
                    fileLength = stack.size() - 1 + file.name.length() + prev;
                } else { // 文件为目录的下一级
                    // 进行对比当前文件名的长度是否是最大长度
                    fileLength = stack.size() + file.name.length() + current;
                }
                ans = Math.max(fileLength, ans);
            }
        }
        return ans;
    }

    static class File {
        int countTabs;
        String name;
        boolean isFile;
        boolean isDir;
    }

    private File parseFileFromString(String s) {
        int ans = 0;
        File file = new File();
        if (s.split("\\.").length > 1) {
            file.isFile = true;
        } else {
            file.isDir = true;
        }
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '\t') {
                break;
            }
            ans++;
        }
        file.countTabs = ans;
        file.name = s.substring(i);
        return file;
    }

    class Solution {
        public int lengthLongestPath(String input) {
            int[] lens = new int[input.length() + 1];
            int res = 0;
            for (String line : input.split("\n")) {
                // 目录层级
                int depth = getDepth(line);

                // 防止数组越界，所以 depth + 1 代表本层，depth 代表上一层
                lens[depth + 1] = lens[depth] + line.length() - depth;

                if (line.contains(".")) {
                    res = Math.max(res, lens[depth + 1] + depth);
                }
            }
            return res;
        }

        private int getDepth(String line) {
            int depth = 0;
            for (char ch : line.toCharArray()) {
                if (ch != '\t') {
                    break;
                }
                depth++;
            }
            return depth;
        }
    }
}
