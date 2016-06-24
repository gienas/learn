package pl.ene.weather.domain;

public class DirectionDO {
    private int directionValue;

    public int getDirectionValue() {
        return this.directionValue;
    }

    public void setDirectionValue(final int directionValue) {
        this.directionValue = directionValue;
    }

    @Override
    public String toString() {
        return String.format("DirectionDO [directionValue=%s]", this.directionValue);
    }

}
