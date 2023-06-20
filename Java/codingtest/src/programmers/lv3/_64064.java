package programmers.lv3;

import java.util.HashSet;
import java.util.Set;

public class _64064 {

    String[] userIds;
    String[] bannedIds;
    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        dfs(new HashSet<>(), 0);

        return result.size();
    }

    void dfs(HashSet<String> set, int depth) {
        if (depth == bannedIds.length) {
            result.add(set);
            return;
        }

        for (String userId : userIds) {

            if (set.contains(userId)) {
                continue;
            }

            if (checkUserId(userId, bannedIds[depth])) {
                set.add(userId);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userId);
            }
        }
    }

    boolean checkUserId(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        boolean isBan = true;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*')
                continue;

            if (userId.charAt(i) != bannedId.charAt(i)) {
                isBan = false;
                break;
            }
        }

        return isBan;
    }

}
