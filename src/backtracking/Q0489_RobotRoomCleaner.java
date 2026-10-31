package backtracking;

import common.model.Robot;
import java.util.*;

public class Q0489_RobotRoomCleaner {
    // Öncelik   : 🟡 Orta
    // Şirketler : Meta (#67)
    //
    // 489. Robot Room Cleaner - Hard
    // https://leetcode.com/problems/robot-room-cleaner/

    /* ------------------------------------------------------------
       | PATTERN: Backtracking (DFS + geri dönüş)
       ------------------------------------------------------------
       Robotun konumu bilinmez; başlangıcı (0, 0), yönü "yukarı" kabul et. Her hücrede temizle, ziyaret edildi olarak işaretle,
       4 yönü sırayla dene (her denemeden sonra sağa dön). Hareket başarılıysa recursive devam et,
       sonra geri dön: 180 derece dön, bir adım git, tekrar 180 derece dön (eski yöne gel).
    */
    /*  Complexity
        Time  : O(N - M) (N hücre, M engel)
        Space : O(N - M)
    */

    private int[] dirs = {-1, 0, 1, 0, -1};
    private Set<List<Integer>> vis = new HashSet<>();
    private Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        dfs(0, 0, 0);
    }

    private void dfs(int i, int j, int d) {
        robot.clean();
        vis.add(List.of(i, j));
        for (int k = 0; k < 4; ++k) {
            int nd = (d + k) % 4;
            int x = i + dirs[nd], y = j + dirs[nd + 1];
            if (!vis.contains(List.of(x, y)) && robot.move()) {
                dfs(x, y, nd);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}
