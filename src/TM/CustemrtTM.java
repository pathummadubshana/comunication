package TM;

public class CustemrtTM {
    private String cid;
    private String name;
    private String total;

    public CustemrtTM() {
    }

    public CustemrtTM(String cid, String name, String total) {
        this.cid = cid;
        this.name = name;
        this.total = total;
    }

    public String getCid() {

        return cid;
    }

    public void setCid(String cid) {

        this.cid = cid;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
