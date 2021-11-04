package Test;

public class Read {
    private int readid;
    private String readname;
    private String readsex;
    private String mold;

    public Read(int readid, String readname, String readsex, String mold) {
        this.readid = readid;
        this.readname = readname;
        this.readsex = readsex;
        this.mold = mold;
    }

    public Read(String readname, String readsex) {
        this.readname = readname;
        this.readsex = readsex;
    }

    public Read() {
    }

    public int getReadid() {
        return readid;
    }

    public void setReadid(int readid) {
        this.readid = readid;
    }

    public String getReadname() {
        return readname;
    }

    public void setReadname(String readname) {
        this.readname = readname;
    }

    public String getReadsex() {
        return readsex;
    }

    public void setReadsex(String readsex) {
        this.readsex = readsex;
    }

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }
}
