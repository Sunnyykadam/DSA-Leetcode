class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = mountainpeak(mountainArr);

        int ans = search(mountainArr, target, 0, peak);

        if (ans != -1) {
            return ans;
        }

        return revsearch(mountainArr, target,
                peak + 1,
                mountainArr.length() - 1);
    }

    public int mountainpeak(MountainArray mountainArr) {

        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start; // peak index
    }

    public int search(MountainArray mountainArr,
                      int target,
                      int left,
                      int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int revsearch(MountainArray mountainArr,
                         int target,
                         int left,
                         int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}