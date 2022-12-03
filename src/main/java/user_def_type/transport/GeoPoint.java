package user_def_type.transport;

public class GeoPoint {
  private  String longitude;
  private String latitude;

    public GeoPoint(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
