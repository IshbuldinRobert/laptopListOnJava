package projectLaptop;

import java.util.Objects;

public class Laptop {
    int imei;
    String maker;
    String model;
    int ram;
    int rom;
    String os;

    public Laptop(int imei, String maker, String model, int ram, int rom, String os) {
        this.imei = imei;
        this.maker = maker;
        this.model = model;
        this.ram = ram;
        this.rom = rom;
        this.os = os;
    }

    // геттеры
    public int getImei() {
        return imei;
    }
    public String getMaker() {
        return maker;
    }
    public String getModel() {
        return model;
    }
    public int getRam() {
        return ram;
    }
    public int getRom() {
        return rom;
    }
    public String getOs() {
        return os;
    }

    // сеттеры
    public void setImei(int imei) {
        this.imei = imei;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public void setRom(int rom) {
        this.rom = rom;
    }
    public void setOs(String os) {
        this.os = os;
    }

    // другие методы
    @Override
    public String toString() {
        return String.format("[imei: %d, maker: %s, model: %s, ram: %d, rom: %d, os: %s]", imei, maker, model, ram, rom, os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei, maker, model, ram, rom, os);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop lt = (Laptop) obj;
        return imei == lt.imei && maker.equals(lt.maker) && model.equals(lt.model)  && ram == lt.ram && rom == lt.rom && os == lt.os;
    }
}