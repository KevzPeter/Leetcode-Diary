class Solution {
    private class Winner {
        int integer;
        int winCount;

        Winner(int i, int wc) {
            integer = i;
            winCount = wc;
        }
    }

    public int getWinner(int[] arr, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
            list.add(i);
        }
        if (k >= arr.length)
            return max;

        Winner winner = new Winner(-1, 0);

        while (winner.winCount != k) {
            int firstInteger = list.get(0);
            int secondInteger = list.get(1);
            if (firstInteger > secondInteger) {
                if (winner.integer == firstInteger) {
                    winner.winCount++;
                } else
                    winner.winCount = 1;
                winner.integer = firstInteger;
                list.removeFirst();
                list.removeFirst();
                list.addLast(secondInteger);
                list.addFirst(firstInteger);
            } else {
                if (winner.integer == secondInteger) {
                    winner.winCount++;
                } else
                    winner.winCount = 1;
                winner.integer = secondInteger;
                list.removeFirst();
                list.addLast(firstInteger);
            }
        }

        return winner.integer;
    }
}