class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b ) << 1;
            //忽略进位的话，a+b的每bit相加就刚好相当于每bit做XOR
            //比如1+1=(1)0, 0+1=1, 1+0=1，忽略括号里的进位
            //然后需要进位的位置，肯定是a和b都是1的，通过a&b可以得到
            //此时进位要进到高位，因此进位后到结果就是(a&b)<<1
            //但进位之后可能还会产生新的进位，因此要再次计算
            //反复直到没有进位
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
