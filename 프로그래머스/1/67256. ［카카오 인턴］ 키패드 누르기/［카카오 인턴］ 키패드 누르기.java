class Solution {
    public String solution(int[] numbers, String hand) {
        int[] twoNumDis = new int[]{-1, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4};
        int[] fiveNumDis = new int[]{-1, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 2, 3};
        int[] eightNumDis = new int[]{-1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 1, 2};
        int[] zeroNumDis = new int[]{-1, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 0, 1};
        int left = 10;
        int right = 12;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < numbers.length ; i++) {
            int num = numbers[i];
            if (num == 1 || num == 4 || num == 7) {
                left = num;
                sb.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                right = num;
                sb.append("R");
            } else {
                if (num == 0) {
                    num = 11;
                }
                if (num == 2) {
                    int leftDis = twoNumDis[left];
                    int rightDis = twoNumDis[right];
                    if (leftDis < rightDis) {
                        sb.append("L");
                        left = num;
                    } else if (leftDis > rightDis) {
                        sb.append("R");
                        right = num;
                    } else {
                        if (hand.equals("right")) {
                            sb.append("R");
                            right = num;
                        } else {
                            sb.append("L");
                            left = num;
                        }
                    }
                } else if (num == 5) {
                    int leftDis = fiveNumDis[left];
                    int rightDis = fiveNumDis[right];
                    if (leftDis < rightDis) {
                        sb.append("L");
                        left = num;
                    } else if (leftDis > rightDis) {
                        sb.append("R");
                        right = num;
                    } else {
                        if (hand.equals("right")) {
                            sb.append("R");
                            right = num;
                        } else {
                            sb.append("L");
                            left = num;
                        }
                    }
                } else if (num == 8) {
                    int leftDis = eightNumDis[left];
                    int rightDis = eightNumDis[right];
                    if (leftDis < rightDis) {
                        sb.append("L");
                        left = num;
                    } else if (leftDis > rightDis) {
                        sb.append("R");
                        right = num;
                    } else {
                        if (hand.equals("right")) {
                            sb.append("R");
                            right = num;
                        } else {
                            sb.append("L");
                            left = num;
                        }
                    }
                } else if (num == 11) {
                    int leftDis = zeroNumDis[left];
                    int rightDis = zeroNumDis[right];
                    if (leftDis < rightDis) {
                        sb.append("L");
                        left = num;
                    } else if (leftDis > rightDis) {
                        sb.append("R");
                        right = num;
                    } else {
                        if (hand.equals("right")) {
                            sb.append("R");
                            right = num;
                        } else {
                            sb.append("L");
                            left = num;
                        }
                    }
                } else {
                    
                }
            }
        }
        return sb.toString();
    }
}