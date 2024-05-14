public class Test {
    public static void main(String[] args) {
        String s= "我,的,世,届";

        String[] str= s.split(",");

        for(int i=0;i<4;i++){
            if(str[i]!=null){
                System.out.println(i);
            }else{
                str[i]=" ";
            }
        }

        System.out.println(str[3]);
    }
}
