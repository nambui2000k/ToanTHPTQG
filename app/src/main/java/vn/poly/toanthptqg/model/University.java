package vn.poly.toanthptqg.model;

public class University {
    private String idUniversity;
    private String nameUniversity;
    private float longitude;
    private float latitude;
    private String linkScore;
    private String linkLogo;

    public University() {
    }

    public University(String idUniversity, String nameUniversity, float longitude, float latitude, String linkScore, String linkLogo) {
        this.idUniversity = idUniversity;
        this.nameUniversity = nameUniversity;
        this.longitude = longitude;
        this.latitude = latitude;
        this.linkScore = linkScore;
        this.linkLogo = linkLogo;
    }

    public University(String idUniversity, String nameUniversity, String linkLogo) {
        this.idUniversity = idUniversity;
        this.nameUniversity = nameUniversity;
        this.linkLogo = linkLogo;
    }

    public String getIdUniversity() {

        return idUniversity;
    }

    public void setIdUniversity(String idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getLinkScore() {
        return linkScore;
    }

    public void setLinkScore(String linkScore) {
        this.linkScore = linkScore;
    }

    public String getLinkLogo() {
        return linkLogo;
    }

    public void setLinkLogo(String linkLogo) {
        this.linkLogo = linkLogo;
    }
}
