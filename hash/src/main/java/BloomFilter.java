import cn.hutool.crypto.SecureUtil;

public class BloomFilter {


    BinMap map=new BinMap();

    public void add(int num){
        int[] hash=hash(num);
        for (int i=0;i<hash.length;i++) {
            map.add(hash[i]);
        }
    }

    public boolean retrieve(int num){
        boolean f=true;
        int[] hash=hash(num);
        for (int i=0;i<hash.length;i++) {
            f=f&map.retrieve(hash[i]);
        }
        return f;
    }

    public int[] hash(int num){
        int[] ints=new int[3];
        ints[0]=Math.abs(13 * (33554432 - 1) & num);
        ints[1]=Math.abs(46 * (33554432 - 1) & num);
        ints[2]=Math.abs(71 * (33554432 - 1) & num);
        return ints;
    }
}
