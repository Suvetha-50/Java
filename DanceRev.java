import java.util.*;

public class DanceRev {
    public static int minMoves(int N, String[] instructions) {
        Map<String, Integer> tileIndex = new HashMap<>();
        tileIndex.put("up", 0);
        tileIndex.put("down", 1);
        tileIndex.put("left", 2);
        tileIndex.put("right", 3);

        int[] tiles = new int[N];
        for (int i = 0; i < N; i++) {
            tiles[i] = tileIndex.get(instructions[i]);
        }


        int INF = Integer.MAX_VALUE / 2;
        int[][][] dp = new int[N + 1][4][4];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        for (int left = 0; left < 4; left++) {
            for (int right = 0; right < 4; right++) {
                dp[0][left][right] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            int currentTile = tiles[i - 1];
            for (int left = 0; left < 4; left++) {
                for (int right = 0; right < 4; right++) {

                    if (currentTile != right) {
                        dp[i][currentTile][right] = Math.min(dp[i][currentTile][right],
                                dp[i - 1][left][right] + (left == currentTile ? 0 : 1));
                    }
                    if (currentTile != left) {
                        dp[i][left][currentTile] = Math.min(dp[i][left][currentTile],
                                dp[i - 1][left][right] + (right == currentTile ? 0 : 1));
                    }
                }
            }
        }

        int result = INF;
        for (int left = 0; left < 4; left++) {
            for (int right = 0; right < 4; right++) {
                result = Math.min(result, dp[N][left][right]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();


        String[] instructions = new String[N];
        for (int i = 0; i < N; i++) {
            instructions[i] = scanner.nextLine();
        }

        int result = minMoves(N, instructions);

        System.out.print(result);

        scanner.close();
    }
}
