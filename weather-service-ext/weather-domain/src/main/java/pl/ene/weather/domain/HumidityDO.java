package pl.ene.weather.domain;

public class HumidityDO {
    private float humValue;

    public float getHumValue() {
        return this.humValue;
    }

    public void setHumValue(final float humValue) {
        this.humValue = humValue;
    }

    @Override
    public String toString() {
        return String.format("HumidityDO [humValue=%s]", this.humValue);
    }
}
