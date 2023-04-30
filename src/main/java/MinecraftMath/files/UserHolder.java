package MinecraftMath.files;

public final class UserHolder {
    // creates a Singleton instance of this object, so it exists outside the controllers
    private final static UserHolder INSTANCE = new UserHolder();
    private User user;

    private UserHolder() {}

    public static UserHolder getInstance() {
        return INSTANCE;
    }

    public void setUser(User u) {
        this.user = u;
    }

    public User getUser() {
        return this.user;
    }
}