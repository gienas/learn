package pl.ene.weather.domain;

/**
 * @author Landic
 *
 */
public enum DirectionNameDO {
    N(0.0f), NNE(22.5f), NE(45.0f), ENE(67.5f), E(90.0f), ESE(112.5f), SE(135.0f), SSE(157.5f), S(180.0f), SSW(
            202.5f), SW(225.0f), WSW(247.5f), W(270.0f), WNW(292.5f), NW(315.0f), NNW(337.5f);

    private final float degrees;

    private DirectionNameDO(final float degrees) {
        this.degrees = degrees;
    }

    /**
     * Return the nearest namen wind direction for the given direction in degrees
     *
     * @param degrees Directioion in degrees (0-360). THe value might be higher or lower , it is re-calculated modulo
     *            360.
     *
     * @return The classes named wind direction
     */
    public static DirectionNameDO forDegrees(final float degrees) {
        final float normalized = degrees % 360;
        DirectionNameDO closestDirection = null;
        float minDistance = 360.0f;
        for (final DirectionNameDO direction : DirectionNameDO.values()) {
            final float distance = direction.getDistance(normalized);
            if (distance < minDistance) {
                minDistance = distance;
                closestDirection = direction;
            }
        }
        return closestDirection;
    }

    public float getDistance(final float normalized) {
        final float set = Math.abs(normalized - getDegrees());
        final float set2 = Math.abs(getDegrees() + 360 - normalized);
        return Math.min(set, set2);
    }

    public float getDegrees() {
        return this.degrees;
    }

}
