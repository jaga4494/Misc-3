class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0) {
            return 0;
        }

        int low = -1;
        int high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w; // sum of all weghts then we need one day to do it.
        }

        
        // instead of starting from low and keep increasing by 1 till high, we can do binary search to find it.
        while (low <= high) {
            int mid = low + (high - low) / 2; // mid is the capacity we r going to try with

            int d = 1;
            int w = 0;
            for (int wei : weights) {
                if (w + wei <= mid) {
                    w += wei;
                }
                else {
                    w = wei;
                    d++;
                }
            }


            if (d <= days) { // same days, we can try to reduce capacity.
                high = mid - 1;
            } else {
                low = mid + 1; 
            }

        }

        return low;
    }
}