package CityCodeMap.Cities;

import java.util.Objects;

public class CityCode {

    private String code;

    public CityCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityCode cityCode = (CityCode) o;
        return code.equals(cityCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "{" +
                "City Code='" + code + '\'' +
                '-';
    }
}
