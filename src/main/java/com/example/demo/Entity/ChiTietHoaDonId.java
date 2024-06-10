package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Objects;

public class ChiTietHoaDonId implements Serializable {
    private Integer maHD;
    private Integer id;

    public ChiTietHoaDonId() {}

    public ChiTietHoaDonId(Integer maHD, Integer id) {
        this.maHD = maHD;
        this.id = id;
    }

    // Getter và Setter
    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // hashCode và equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietHoaDonId that = (ChiTietHoaDonId) o;
        return Objects.equals(maHD, that.maHD) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHD, id);
    }
}
