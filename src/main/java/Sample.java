import java.net.InetAddress;

public class Sample {
    public static void main(String[] args) throws Exception{
        long startTime = System.nanoTime();
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getCanonicalHostName());
        System.out.println("test : " + (System.nanoTime() - startTime));
    }
}
