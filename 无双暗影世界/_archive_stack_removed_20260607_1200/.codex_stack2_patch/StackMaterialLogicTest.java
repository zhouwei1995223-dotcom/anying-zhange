import app.island.data.Depot;
import app.island.data.Goods;
import app.island.data.Material;

public class StackMaterialLogicTest {
    public static void main(String[] args) {
        Depot depot = new Depot();

        Material first = new Material();
        first.id = 1433000809;
        first.name = "test-material";

        Material second = new Material();
        second.id = 1433000809;
        second.name = "test-material";

        int firstMerge = depot.addStackableGoods(first);
        depot.goodsList[0] = first;
        int secondMerge = depot.addStackableGoods(second);
        Goods stored = depot.goodsList[0];

        System.out.println("firstMerge=" + firstMerge);
        System.out.println("secondMerge=" + secondMerge);
        System.out.println("slot0Id=" + stored.id);
        System.out.println("slot0CanStack=" + stored.canStack);
        System.out.println("slot0StackCount=" + stored.stackCount);
        System.out.println("slot1Empty=" + (depot.goodsList[1] == null));

        if (firstMerge != -1 || secondMerge != 0 || stored.stackCount != 2 || stored.canStack != 1 || depot.goodsList[1] != null) {
            throw new RuntimeException("material stack test failed");
        }
    }
}
