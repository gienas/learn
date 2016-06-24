package pl.ene.weather.domain;

public class WindDO {
    private String description;
    private float speedKmh;
    private DirectionDO directionDO;
    
    public DirectionDO getDirectionDO() {
        return this.directionDO;
    }

    public void setDirectionDO(DirectionDO directionDO) {
        this.directionDO = directionDO;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public float getSpeedKmh() {
        return this.speedKmh;
    }

    public void setSpeedKmh(final float speedKmh) {
        this.speedKmh = speedKmh;
    }

    @Override
    public String toString() {
        return String.format("WindDO [description=%s, speedKmh=%s]", this.description, this.speedKmh);
    }

}
