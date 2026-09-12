

class Solution {

    static class Interval {
        int start, end, weight, index;

        Interval(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    static class State {
        long weight;
        List<Integer> selected;

        State(long weight, List<Integer> selected) {
            this.weight = weight;
            this.selected = selected;
        }
    }

    Interval[] arr;
    State[][] memo;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by start
        Arrays.sort(arr, (a, b) -> {
            if (a.start != b.start)
                return Integer.compare(a.start, b.start);

            return Integer.compare(a.end, b.end);
        });

        memo = new State[n][5];

        State ans = dp(0, 4);

        int[] result = new int[ans.selected.size()];

        for (int i = 0; i < ans.selected.size(); i++) {
            result[i] = ans.selected.get(i);
        }

        return result;
    }

    private State dp(int i, int k) {

        if (i == arr.length || k == 0) {
            return new State(0, new ArrayList<>());
        }

        if (memo[i][k] != null) {
            return memo[i][k];
        }

        // OPTION 1: Skip current interval
        State skip = dp(i + 1, k);

        // OPTION 2: Take current interval
        int next = findNext(i + 1, arr[i].end);

        State nextState = dp(next, k - 1);

        List<Integer> takeList =
            new ArrayList<>(nextState.selected);

        takeList.add(arr[i].index);

        // We need indices in sorted order for lexicographical comparison
        Collections.sort(takeList);

        State take = new State(
            arr[i].weight + nextState.weight,
            takeList
        );

        // Choose better state
        if (take.weight > skip.weight) {
            memo[i][k] = take;
        }
        else if (take.weight < skip.weight) {
            memo[i][k] = skip;
        }
        else {
            // Same weight → lexicographically smaller
            if (compare(take.selected, skip.selected) < 0) {
                memo[i][k] = take;
            }
            else {
                memo[i][k] = skip;
            }
        }

        return memo[i][k];
    }

    // First interval whose start > currentEnd
    private int findNext(int start, int currentEnd) {

        int low = start;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid].start > currentEnd) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Lexicographical comparison
    private int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        // If one is prefix of another,
        // shorter one is lexicographically smaller
        return Integer.compare(a.size(), b.size());
    }
}