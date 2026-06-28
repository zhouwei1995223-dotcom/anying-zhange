import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackMaterialServerPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(root + "/server/server_stack10.zip");
        cp.insertClassPath(root + "/server/lib/mysql-connector-java-5.0.4-bin.jar");

        CtClass goods = cp.get("app.island.data.Goods");
        CtMethod isStackable = goods.getDeclaredMethod("isStackable");
        isStackable.setBody(
            "{ " +
            "if (this.goodsType == 1 || this.goodsType == 2 || this.goodsType == 3 || this.goodsType == 6) return false; " +
            "if (this.canStack == 1) return true; " +
            "if (this.goodsType == 8) return true; " +
            "if (this.id == 1433000809 || this.id == 1333020200 || this.id == 1633060011) return true; " +
            "return false; " +
            "}"
        );
        goods.writeFile(root + "/.codex_stack2_patch/server_stack11_classes");
    }
}
