package pl.ene.weather.domain;

public class PrecipitationDO {
    private Float valueMmHod;
    private Float valueMmToday;

    public Float getValueMmHod() {
        return this.valueMmHod;
    }

    public void setValueMmHod(Float valueMmHod) {
        this.valueMmHod = valueMmHod;
    }

    public Float getValueMmToday() {
        return this.valueMmToday;
    }

    public void setValueMmToday(Float valueMmToday) {
        this.valueMmToday = valueMmToday;
    }

    @Override
    public String toString() {
        return String.format("PrecipitationDO [valueMmHod=%s, valueMmToday=%s]", this.valueMmHod, this.valueMmToday);
    }

}
