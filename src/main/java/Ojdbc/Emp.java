package Ojdbc;

import java.math.BigDecimal;
import java.util.Date;

public class Emp {
    private String empid;
    private String ename;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Emp() {
    }

    public Emp(String empid, String ename) {
        this.empid = empid;
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empid='" + empid + '\'' +
                ", ename='" + ename + '\'' +
                '}';
    }
}
