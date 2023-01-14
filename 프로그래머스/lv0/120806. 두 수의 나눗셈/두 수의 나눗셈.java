class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double temp = (double)(num1) / num2;
        answer = (int) (temp * 1000);
        return answer;
    }
}