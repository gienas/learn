package pl.ene.weather.domain;

public class PlaceDO {
    private String city;
    private String country;

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
        result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
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
        final PlaceDO other = (PlaceDO) obj;
        if (this.city == null) {
            if (other.city != null) {
                return false;
            }
        }
        else if (!this.city.equals(other.city)) {
            return false;
        }
        if (this.country == null) {
            if (other.country != null) {
                return false;
            }
        }
        else if (!this.country.equals(other.country)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("PlaceDO [city=%s, country=%s]", this.city, this.country);
    }

}
