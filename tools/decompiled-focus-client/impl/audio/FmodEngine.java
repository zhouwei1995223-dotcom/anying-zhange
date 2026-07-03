/*
 * Decompiled with CFR 0.152.
 */
package impl.audio;

import a.a.q;
import a.c.a;
import java.awt.Point;
import java.io.File;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FmodEngine
implements a {
    private static boolean d = false;
    private File void;
    private int e = 100;
    private Point b = new Point();
    private q c = new q();

    public void setListenerPosition(int n2, int n3) {
        this.b.setLocation(n2, n3);
    }

    private native int Fmod_Release();

    public void playMusic(String string) {
        if (!d) {
            return;
        }
        File file = new File(this.void, string);
        if (!file.exists() || file.isDirectory()) {
            return;
        }
        string = file.getAbsolutePath();
        this.Fmod_PlayMusic(string.getBytes());
    }

    private native int Fmod_PlayMusic(byte[] var1);

    private int a(String string, float f2, float f3) {
        if (!d) {
            return -1;
        }
        Integer n2 = (Integer)this.c.for(string);
        if (n2 == null) {
            File file = new File(this.void, string);
            if (!file.exists() || file.isDirectory()) {
                System.out.println("sound file not exists:" + string);
                this.c.a((Object)string, (Object)new Integer(-1));
                return -1;
            }
            String string2 = file.getAbsolutePath();
            int n3 = this.Fmod_PlaySound(string2.getBytes(), f2, f3);
            n2 = new Integer(n3);
            this.c.a((Object)string, (Object)n2);
            return n3;
        }
        int n4 = n2;
        if (n4 < 100 & n4 >= 0) {
            int n5 = this.Fmod_PlaySound(n4, f2, f3);
            return n5;
        }
        System.out.println("sound exception,name:" + string + " index:" + n4);
        return -1;
    }

    private native int Fmod_PlaySound(byte[] var1, float var2, float var3);

    public void pauseMusic() {
    }

    private native int Fmod_PlaySound(int var1, float var2, float var3);

    private native int Fmod_Init();

    private native int Fmod_SetVolume(int var1);

    public File getWorkDir() {
        return this.void;
    }

    public void setWorkDir(File file) {
        this.void = file;
    }

    public void resumeMusic() {
    }

    private native int Fmod_StopMusic();

    public void update() {
        if (d) {
            this.Fmod_Update();
        }
    }

    public void play3DSound(String string, int n2, int n3) {
        int n4 = n2 - this.b.x;
        int n5 = this.b.y - n3;
        float f2 = (float)(1000.0 - Math.sqrt(n4 * n4 + n5 * n5)) / 1000.0f;
        if (f2 < 2.0E-4f) {
            return;
        }
        float f3 = (float)n4 / 1000.0f;
        this.a(string, f2, f3);
    }

    private native int Fmod_Update();

    static {
        try {
            System.loadLibrary("jfmod");
            d = true;
        }
        catch (Error error) {
            error.printStackTrace();
        }
    }

    public int getMusicVolume() {
        return this.e;
    }

    public void setMusicVolume(int n2) {
        this.e = n2;
        if (d) {
            this.Fmod_SetVolume(n2);
        }
    }

    public void stopMusic() {
        if (d) {
            this.Fmod_StopMusic();
        }
    }

    public int init() {
        if (!d) {
            return -1;
        }
        int n2 = this.Fmod_Init();
        return n2;
    }

    public void play2DSound(String string) {
        this.a(string, 1.0f, 0.0f);
    }
}

