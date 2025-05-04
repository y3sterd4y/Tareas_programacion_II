/*En java no hay herencia multiple de forma nativa pero se puede simular con interfases  y compocision
en este caso voy a usar compocicion para que se parezca a el diagrama*/

public class A {
    private int x;
    private int z;

    public A(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public void incrementaXZ() {
        x++;
        z++;
    }

    public void incrementaZ() {
        z++;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }
}

public class B {
    private int y;
    private int z;

    public B(int y, int z) {
        this.y = y;
        this.z = z;
    }

    public void incrementaYZ() {
        y++;
        z++;
    }

    public void incrementaZ() {
        z++;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}

public class D {
    private A a;
    private B b;

    public D(int x, int y, int z) {
        this.a = new A(x, z);
        this.b = new B(y, z);
    }

    public void incrementaXZ() {
        a.incrementaXZ();
    }

    public void incrementaYZ() {
        b.incrementaYZ();
    }

    public void incrementaZ() {
        a.incrementaZ();
        b.incrementaZ();
    }

    public void incrementaXYZ() {
        a.incrementaXZ();
        b.incrementaYZ();
    }
}