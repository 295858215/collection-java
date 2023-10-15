package homework;
public class Passenger {
    public static void main(String[] args) {
        Passenger passenger = new Passenger();
        Booth booth = new Booth(102301438, "陈泽荣", 20, false);
        Booth booth1 = new Booth(1, "陈", 20, false);
        Booth booth2 = new Booth(2, "泽", 20, false);
        Booth booth3 = new Booth(3, "荣", 20, true);
        Booth nums1[] = new Booth[]{booth,booth1,booth2,booth3};//测试数据，创建数组
        //西瓜摊进货、顾客购买测试1：booth 正常情况：进货和购买都能够顺利完成；
        booth.restock(booth,200);
        passenger.purchase(booth, 20);
        //西瓜摊进货、顾客购买测试2：booth1 进货量>200的情况；
        booth.restock(booth1,250);
        passenger.purchase(booth1, 20);
        //西瓜摊进货、顾客购买测试3：booth2 库存量<顾客购买量的情况；
        booth.restock(booth2,20);
        passenger.purchase(booth2, 60);
        //西瓜摊进货、顾客购买测试4：booth3 顾客购买时店铺正处于休业状态；
        booth.restock(booth3,200);
        passenger.purchase(booth3, 20);
        //全部休业整顿情况测试：
        booth.closebooths(nums1);
    }

    //purchase方法
    public static void purchase(Booth name, int purchaseTotal) {
        if (purchaseTotal <= 0) {
            System.out.println("交易失败！请输入正确的购买数量！");
        } else {
            if (name.getIsClosed() == true) {
                System.out.println("交易失败！店铺正处于休业整顿！");
            } else {
                if (purchaseTotal > name.getTotal()) {
                    System.out.println("交易失败！购买数量大于店铺库存！");
                    System.out.println("店铺剩余的西瓜数量为：" + name.getTotal());
                } else {
                    name.setTotal(name.getTotal() - purchaseTotal);
                    System.out.println("恭喜您！您的交易成功！");
                    System.out.println("店铺剩余的西瓜数量为：" + name.getTotal());
                }
            }
        }
    }
}


