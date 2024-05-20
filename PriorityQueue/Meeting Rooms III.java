class Solution {
    private class UsedRoom {
        int roomId;
        int endTime;

        UsedRoom(int roomId, int endTime) {
            this.roomId = roomId;
            this.endTime = endTime;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] freq = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }
        int maxTime = meetings[meetings.length - 1][0];
        PriorityQueue<UsedRoom> usedRooms = new PriorityQueue<>(
                (a, b) -> a.endTime == b.endTime ? a.roomId - b.roomId : a.endTime - b.endTime);
        int meetingsIndex = 0;
        for (int time = 0; time <= maxTime && meetingsIndex < meetings.length; time++) {
            while (!usedRooms.isEmpty() && usedRooms.peek().endTime == time) {
                UsedRoom room = usedRooms.poll();
                freeRooms.offer(room.roomId);
            }
            while (meetingsIndex < meetings.length && meetings[meetingsIndex][0] == time) {
                int[] meeting = meetings[meetingsIndex];
                int startTime = meeting[0];
                int endTime = meeting[1];
                if (freeRooms.size() > 0) {
                    int minFreeRoom = freeRooms.poll();
                    freq[minFreeRoom]++;
                    usedRooms.offer(new UsedRoom(minFreeRoom, endTime));
                } else {
                    UsedRoom room = usedRooms.poll();
                    freq[room.roomId]++;
                    usedRooms.offer(new UsedRoom(room.roomId, room.endTime + (endTime - startTime)));
                }
                meetingsIndex++;
            }

        }
        int maxFreq = 0;
        int roomIdx = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                roomIdx = i;
            }
        }
        return roomIdx;
    }
}