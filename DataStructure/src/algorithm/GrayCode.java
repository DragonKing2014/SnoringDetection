package algorithm;

/**
 * 生成n位格雷码
 */
public class GrayCode {
    public String[] getGray(int n) {

        if (n == 1) {
            String[] result = new String[2];
            result[0] = "0";
            result[1] = "1";
            return result;
        } else {
            //递归实现，temp是n-1位的格雷码
            String[] temp = getGray(n - 1);
            String[] result = new String[temp.length * 2];
            //镜像反转法生成格雷码，首先将temp复制一份，相比之前的数组是逆序排列，然后在每个元素之前加"1"
            //第一组数组，正序排列，并且每个数组元素字符串前面加"0"
            for (int i = 0; i < temp.length; i++) {
                result[i] = "0" + temp[i];
            }
            //第二组数组，逆序排列，并且每个数组元素字符串前面加"1"
            for (int i = 0; i < temp.length; i++) {
                result[i + temp.length] = "1" + temp[temp.length - 1 - i];
            }
            return result;
        }
    }

    public static void main(String[] a){
        String[] result=new GrayCode().getGray(5);
        for (int i=0;i<=result.length-1;i++){
            System.out.println(result[i]);
        }
    }
}
