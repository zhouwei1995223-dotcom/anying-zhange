import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class StackMaterialClientPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(root + "/client/client_stack_count.zip");

        CtClass goods = cp.get("b.a.e.j");
        CtMethod isStackable = goods.getDeclaredMethod("isStackable");
        isStackable.setBody(
            "{ " +
            "if (this.fW == 1 || this.fW == 2 || this.fW == 3 || this.fW == 6) return false; " +
            "if (this.canStack == 1) return true; " +
            "if (this.fW == 8) return true; " +
            "return false; " +
            "}"
        );
        goods.writeFile(root + "/.codex_stack2_patch/client_stack_material_classes");
    }
}
