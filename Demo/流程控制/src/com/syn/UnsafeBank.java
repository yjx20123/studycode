package com.syn;

//不安全的取钱
//两个人去银行取钱

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000, "结婚基金");
        Drawing you = new Drawing(account, 50, "ni");
        Drawing girl = new Drawing(account, 100, "girl");
        you.start();
        girl.start();
    }
}

//账户
class Account {
    int money;  //余额
    String name;//卡名

    public Account() {

    }

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行
class Drawing extends Thread {
    Account account;//账户

    int drawingMoney;//取了的钱
    int nowMoney;//现在剩余的钱

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    public Drawing() {

    }
    //取钱

    @Override
    public void run() {
        //锁的对象就是变化的量，
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够,取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额
            account.money = account.money - drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + ":余额为" + account.money);
            System.out.println(this.getName() + "手里的钱" + nowMoney);

        }
    }
}