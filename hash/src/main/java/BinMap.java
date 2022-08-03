public class BinMap {

    byte[] bytes=new byte[1<<29];

    public void add(int num){

        /*这里l指的是在底层新建一个long类型的值。
        num需要+2^31，这里使用位运算来达到相同的效果
        这样的话，int中最小的-2^31的索引为0，以此类推*/
        long bitIndex=num+(1l<<31);
        int byteInd= (int) (bitIndex/8);
        int inInd=(int) (bitIndex%8);
        bytes[byteInd]= (byte) (bytes[byteInd] | (1 << (inInd-1)));
    }

    public boolean retrieve(int num){

        long bitIndex=num+(1l<<31);
        int byteInd=(int)(bitIndex/8);
        int inInd=(int)(bitIndex%8);
        if (((bytes[byteInd] >> (inInd-1))&1)==1){
            return true;
        }else {
            return false;
        }

    }
}
