package pl.ene.weather.domain;

public class TemperatureDO {
    private float celsiusValue;

    public float getCelsiusValue() {
        return this.celsiusValue;
    }

    public void setCelsiusValue(final float celsiusValue) {
        this.celsiusValue = celsiusValue;
    }

    @Override
    public String toString() {
        return String.format("TemperatureDO [celsiusValue=%s]", this.celsiusValue);
    }

    public float getFahrenheit() {

        return this.celsiusValue * 1.8f + 32.0f;
    }

    public void setFahrenheitValue(final float intial) {
        this.celsiusValue = (intial - 32.0f) / 1.8f;

    }

}
