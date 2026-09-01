

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = 0;
        int startCol = 0;

        // Har litter ko ek index denge: 0, 1, 2...
        Map<Integer, Integer> litterIndex = new HashMap<>();
        int litterCount = 0;

        // Find starting position and litters
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litterIndex.put(i * n + j, litterCount);
                    litterCount++;
                }
            }
        }

        // visited[row][col][remainingEnergy][mask]
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();

        // {row, col, remainingEnergy, mask, moves}
        queue.offer(new int[]{
                startRow,
                startCol,
                energy,
                0,
                0
        });

        visited[startRow][startCol][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int allCollected = (1 << litterCount) - 1;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int remainingEnergy = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            // Agar saare litter collect ho gaye
            if (mask == allCollected) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {

                int newRow = row + dr[d];
                int newCol = col + dc[d];

                // Boundary check
                if (newRow < 0 || newRow >= m ||
                    newCol < 0 || newCol >= n) {
                    continue;
                }

                char cell = classroom[newRow].charAt(newCol);

                // Obstacle
                if (cell == 'X') {
                    continue;
                }

                // Move karne ke liye energy honi chahiye
                if (remainingEnergy == 0) {
                    continue;
                }

                int newEnergy = remainingEnergy - 1;
                int newMask = mask;

                // Agar litter hai to collect karo
                if (cell == 'L') {

                    int index =
                            litterIndex.get(newRow * n + newCol);

                    newMask = mask | (1 << index);
                }

                // Recharge point
                if (cell == 'R') {
                    newEnergy = energy;
                }

                // Same state already visit ho chuki hai
                if (visited[newRow][newCol][newEnergy][newMask]) {
                    continue;
                }

                visited[newRow][newCol][newEnergy][newMask] = true;

                queue.offer(new int[]{
                        newRow,
                        newCol,
                        newEnergy,
                        newMask,
                        moves + 1
                });
            }
        }

        return -1;
    }
}