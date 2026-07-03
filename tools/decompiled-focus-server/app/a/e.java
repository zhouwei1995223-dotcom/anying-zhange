/*
 * Decompiled with CFR 0.152.
 */
package app.a;

import app.a.a;
import app.a.b;
import java.io.IOException;
import java.net.Socket;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class e {
    private b do;
    private a if;
    private Socket a;
    private boolean for;

    public a a() {
        return this.if;
    }

    e(b b2, a a2, Socket socket) {
        this.do = b2;
        this.if = a2;
        this.a = socket;
    }

    public boolean do() {
        return this.for;
    }

    public b for() {
        return this.do;
    }

    public void if() {
        if (this.for) {
            return;
        }
        this.for = true;
        try {
            this.a.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

