public class MyCar {
    private String token;

    public MyCar() {
        this.token = "00000";
    }

    public MyCar(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
