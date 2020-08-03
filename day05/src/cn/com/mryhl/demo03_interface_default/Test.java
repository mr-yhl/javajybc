package cn.com.mryhl.demo03_interface_default;

public class Test {
    public static void main(String[] args) {
        MyclassA myclassA = new MyclassA();
        myclassA.hello();
        myclassA.printWorld();
        System.out.println("===============");
        MyclassB myclassB = new MyclassB();
        myclassB.printWorld();
    }
}
