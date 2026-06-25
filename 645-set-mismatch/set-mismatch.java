class Solution {
    public int[] findErrorNums(int[] arr) {

        int i = 0;

        // Cyclic sort
        while (i < arr.length) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        int duplicate = -1;
        int missing = -1;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                duplicate = arr[j];
                missing = j + 1;
            }
        }

        return new int[]{duplicate, missing};
    }
}