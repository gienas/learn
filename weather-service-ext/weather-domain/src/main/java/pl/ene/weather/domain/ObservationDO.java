package pl.ene.weather.domain;

import java.time.Instant;

public class ObservationDO {
    private String place;
    private Instant time;

    public String getPlace() {
        return this.place;
    }

    public void setPlace(final String place) {
        this.place = place;
    }

    public Instant getTime() {
        return this.time;
    }

    public void setTime(final Instant time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.place == null) ? 0 : this.place.hashCode());
        result = prime * result + ((this.time == null) ? 0 : this.time.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObservationDO other = (ObservationDO) obj;
        if (this.place == null) {
            if (other.place != null) {
                return false;
            }
        }
        else if (!this.place.equals(other.place)) {
            return false;
        }
        if (this.time == null) {
            if (other.time != null) {
                return false;
            }
        }
        else if (!this.time.equals(other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("ObservationDO [place=%s, time=%s]", this.place, this.time);
    }

}
