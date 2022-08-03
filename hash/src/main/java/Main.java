import cn.hutool.crypto.SecureUtil;

public class Main {
    //位映射

    //布隆过滤器
    //一致性哈希

    public static void main(String[] args) {
        BloomFilter bloomFilter=new BloomFilter();
        bloomFilter.add(55);
        System.out.println(bloomFilter.retrieve(56));

    }
}
