package com.my.design;

/**
 * 策略模式
 * 1，上下文环境
 * 2，公共接口
 * 具有相同点，只是接口实现具体不同 目的减少if...else if...结构
 */
public class Strategy {
    public static void main(String[] args) {
        SCommon sCommon = new VipCustorm();
        Context context = new Context(sCommon);
        int executor = context.executor(100);
        System.out.println("需要付款：" + executor);

    }

}

class Context {
    private SCommon sCommon = null;

    public Context(SCommon sCommon) {
        this.sCommon = sCommon;
    }

    public int executor(int i) {
        return sCommon.getResult(i);
    }
}

interface SCommon {
    int getResult(int price);
}

class NewCustorm implements SCommon {

    @Override
    public int getResult(int price) {
        return price;
    }
}

class OldCustorm implements SCommon {

    @Override
    public int getResult(int price) {
        price = (price * 4) / 5;
        return price;
    }
}

class VipCustorm implements SCommon {

    @Override
    public int getResult(int price) {
        return price / 2;
    }
}