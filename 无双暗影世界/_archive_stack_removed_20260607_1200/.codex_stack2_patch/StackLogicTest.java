import app.island.data.Depot;
import app.island.data.Goods;
import app.island.data.SpecialProperty;

public class StackLogicTest {
    public static void main(String[] args) {
        Depot depot = new Depot();
        Goods one = new SpecialProperty();
        one.id = 1333020200;
        one.goodsType = 5;
        one.canStack = 1;
        one.stackCount = 1;
        Goods two = new SpecialProperty();
        two.id = 1333020200;
        two.goodsType = 5;
        two.canStack = 1;
        two.stackCount = 1;
        System.out.println("first=" + depot.addStackableGoods(one));
        if (depot.getNextFreePos() >= 0) {
            depot.goodsList[depot.getNextFreePos()] = one;
        }
        System.out.println("second=" + depot.addStackableGoods(two));
        for (int i = 0; i < depot.goodsList.length; i++) {
            Goods g = depot.goodsList[i];
            if (g != null) {
                System.out.println(i + ":" + g.id + "," + g.stackCount);
            }
        }
    }
}
